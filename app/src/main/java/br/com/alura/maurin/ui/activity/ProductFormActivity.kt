package br.com.alura.maurin.ui.activity

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.maurin.R
import br.com.alura.maurin.dao.ProdutosDao
import br.com.alura.maurin.databinding.ActivityProductFormBinding
import br.com.alura.maurin.model.Produto
import java.math.BigDecimal


class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {

    private lateinit var campoNome: EditText
    private lateinit var campoDescricao: EditText
    private lateinit var campoValor: EditText

    private lateinit var binding: ActivityProductFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraBotaoSalvar()
        configuraForm()
    }

    private fun configuraForm() {
        campoNome = binding.activityProdutoFormNome
        campoDescricao = binding.activityProdutoFormDescricao
        campoValor = binding.activityProdutoFormValor
    }

    private fun configuraBotaoSalvar() {
        val salvarButtom = binding.activityProdutoFormSalvarButtom
        salvarButtom.setOnClickListener {
            val produtoNovo = criaProduto()
        }
    }

    private fun criaProduto() {
        val nome = campoNome.text.toString()
        val descricao = campoDescricao.text.toString()
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }
        val produto = Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )

        val dao = ProdutosDao()
        dao.adiciona(produto)
        finish()
    }
}

