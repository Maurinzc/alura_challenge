package br.com.alura.maurin.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.maurin.R
import br.com.alura.maurin.dao.ProdutosDao
import br.com.alura.maurin.model.Produto
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding = ProductFormActivityBinding.inflate(layoutInflater)
        configuraBotaoSalvar()

    }

    private fun configuraBotaoSalvar() {
        val salvarButtom = findViewById<Button>(R.id.activity_produto_form_salvar_buttom)
        val dao = ProdutosDao()
        salvarButtom.setOnClickListener {
            val (nome, descricao, valor) = criaProduto()

        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_produto_form_nome)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.activity_produto_form_descricao)
        val descricao = campoDescricao.text.toString()
        val campoValor = findViewById<EditText>(R.id.activity_produto_form_valor)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }
        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )

    }
}