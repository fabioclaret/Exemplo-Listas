package com.android.exemplolistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.exemplolistas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var estados = mapOf(
        "AC" to "Acre",
        "AL" to "Alagoas",
        "AP" to "Amapa",
        "AM" to "Amazonas",
        "BA" to "Bahia",
        "CE" to "Ceara",
        "DF" to "Distrito Federal"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val siglas    = resources.getStringArray(R.array.lista_estados)
        val adaptador = ArrayAdapter<String>(this, R.layout.item_spinner,siglas)

        val spinner = binding.spiner
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent  : AdapterView<*>?,
                                        view    : View?,
                                        position: Int,
                                        id      : Long) {

                var sigla  = siglas[position]
                var estado = estados.get(sigla)

                Toast.makeText(this@MainActivity,"Item selecionado\n" + estado ,
                    Toast.LENGTH_LONG)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}















