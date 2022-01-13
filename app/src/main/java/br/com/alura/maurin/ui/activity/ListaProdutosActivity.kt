package br.com.alura.maurin.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.maurin.R
import br.com.alura.maurin.dao.ProdutosDao
import br.com.alura.maurin.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ListaProdutosActivityBinding.inflate(layoutInflater)
//        val recyclerView = binding.listaProdutosActivityRecyclerview
//        recyclerView.adapter = adapter
        configuraRecycleView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Cesta de frutas"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Morango, laranja e limão"
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "19.99"

    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_produto_lista_fab)
        fab.setOnClickListener {
            vaiParaFormularioProduto()

        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecycleView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_produto_lista_recyclerView)
        recyclerView.adapter = adapter
    }
}