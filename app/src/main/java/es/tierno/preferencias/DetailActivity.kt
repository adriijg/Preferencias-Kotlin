package es.tierno.preferencias

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getExtras()
    }

    private fun getExtras() {
        val extras = intent.extras
        val nombre = extras?.getString(Constantes.NAME)
        val etNombre: EditText = findViewById(R.id.etNombre2)
        etNombre.setText(nombre)
    }

    fun navegar() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}