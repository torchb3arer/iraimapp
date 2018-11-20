package com.example.torchb3arer.iraimapp.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.torchb3arer.iraimapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickCalcular (view: View){
        val  edad : Int = edadInp.text.toString().toInt()
        val  peso : Double= pesoInp.text.toString().toDouble()
        val  creat : Double= creaInp.text.toString().toDouble()
        var sexo : Char = 'N'
        var suma : Double = 0.0
        if(radioM.isChecked){
            sexo = 'M'
            suma = ((140-edad)*peso)/(72*creat)
        }
        else if (radioF.isChecked){
            sexo ='F'
            suma = (((140-edad)*peso)/(72*creat))*0.85

        }
        val resultado :Double = Math.round(suma * 100.0) / 100.0

        System.out.println("Edad $edad")
        System.out.println("Peso $peso")
        System.out.println("creatina: $creat")
        System.out.println("Sexo: $sexo")
        System.out.println("Suma: $suma")
        System.out.println("Resultado: $resultado")

        val activityResultado = Intent(this, Resultado::class.java)
        activityResultado.putExtra("RESULTADO",resultado.toString())
        startActivity(activityResultado)

    }
}
