package com.example.torchb3arer.iraimapp.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.torchb3arer.iraimapp.R
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val entrada = intent.extras
        if (entrada != null) {
            val stringEntrada = entrada.getString("RESULTADO")
            txtResuFnal.setText(stringEntrada)

        }
    }
}
