package es.tierno.preferencias

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtNombre = findViewById(R.id.txtNombre)

        val nombre = leer()
        if (!nombre.isNullOrEmpty()) {
            txtNombre.setText(nombre)
        }
    }

    fun guardar(view: View) {
        val sharedPref = getPreferences(MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString(Constantes.NAME, txtNombre.text.toString())
            apply()
        }
        navegar()
    }

    private fun leer(): String? {
        val sharedPref = getPreferences(MODE_PRIVATE)
        return sharedPref.getString(Constantes.NAME, Constantes.BLANCO)
    }

    private fun navegar() {
        val intent = Intent(this, DetailActivity::class.java)
        addExtras(intent)
        startActivity(intent)
    }

    private fun addExtras(intent: Intent) {
        intent.putExtra(Constantes.NAME, txtNombre.text.toString())
    }
}