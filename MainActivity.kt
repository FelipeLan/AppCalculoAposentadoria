package com.example.appcalculoaposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val spn_Sexo = findViewById<Spinner>(R.id.spn_Sexo)
        val txt_Idade = findViewById<TextView>(R.id.txt_Idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        spn_Sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino","Feminino"))

        btn_Calcular.setOnClickListener {
            val sexo = spn_Sexo.selectedItem as String
            val idade = txt_Idade.text.toString()

            if (idade.isEmpty()) {
                txt_Resultado.text = "Digite uma idade válida"
                return@setOnClickListener

            var resultado = 0
            if (sexo == "Masculino"){
                resultado = 64 - idade
            } else if (sexo == "Feminino") {
                resultado = 59 - idade
            }
            txt_Resultado.text = "Ainda faltam $resultado anos para você se aposentar"

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}