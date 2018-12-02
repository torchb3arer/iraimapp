package com.example.torchb3arer.iraimapp.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.torchb3arer.iraimapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickCalcular (view: View){
        var sexo : Char = 'N'
        var suma : Double = 0.0

        if(edadInp.text.isEmpty() || pesoInp.text.isEmpty() || creaInp.text.isEmpty()
                || (!radioM.isChecked() && !radioF.isChecked())){
            Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_SHORT).show()

        }
        else{
            val  edad : Int = edadInp.text.toString().toInt()
            val  peso : Double= pesoInp.text.toString().toDouble()
            val  creat : Double= creaInp.text.toString().toDouble()

            if(radioM.isChecked){
                sexo = 'M'
                suma = ((140-edad)*peso)/(72*creat)
            }
            else if (radioF.isChecked){
                sexo ='F'
                suma = (((140-edad)*peso)/(72*creat))*0.85

            }
            val resultado :Double = Math.round(suma * 100.0) / 100.0

            val activityResultado = Intent(this, Resultado::class.java)
            activityResultado.putExtra("RESULTADO",resultado.toString())
            startActivity(activityResultado)
        }
    }
}
