package com.example.torchb3arer.iraimapp.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.torchb3arer.iraimapp.R
import com.example.torchb3arer.iraimapp.Utilitarios.*
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

            val categoria = Bundle()


            val activityResultado = Intent(this, Resultado::class.java)
            when{
                (resultado <15) -> {
                    categoria.putString("CATEGORIA",CINCO)
                    categoria.putString("CATEGORIA_DES",G_CINCO)
                    activityResultado.putExtras(categoria)
                }

                (resultado in 15..29) -> {
                    categoria.putString("CATEGORIA", CUATRO)
                    categoria.putString("CATEGORIA_DES", G_CUATRO)
                    activityResultado.putExtras(categoria)
                }
                (resultado in 30..44) -> {
                    categoria.putString("CATEGORIA", TRES_B)
                    categoria.putString("CATEGORIA_DES", G_TRES_B)
                    activityResultado.putExtras(categoria)
                }
                (resultado in 45..59) -> {
                    categoria.putString("CATEGORIA", TRES_A)
                    categoria.putString("CATEGORIA_DES", G_TRES_A)
                    activityResultado.putExtras(categoria)
                }
                (resultado in 60..89) -> {
                    categoria.putString("CATEGORIA", DOS)
                    categoria.putString("CATEGORIA_DES", G_DOS)
                    activityResultado.putExtras(categoria)
                }
                (resultado >=90) -> {
                    categoria.putString("CATEGORIA", UNO)
                    categoria.putString("CATEGORIA_DES", G_UNO)
                    activityResultado.putExtras(categoria)
                }
            }



            activityResultado.putExtra("RESULTADO",resultado.toString())
            startActivity(activityResultado)
        }
    }
}
