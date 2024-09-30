package com.torres.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.flow.callbackFlow

class MainActivity : AppCompatActivity() {

    var num1: Int = 10
    var num2: Int = 20
    var resultado: Int = 0
    var aux:String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        resultado = sumar(num1,num2)
        Log.v("Resultado",resultado.toString())
        Log.d("Resultado",resultado.toString())
        Log.i("Resultado", resultado.toString())
        Log.w("Resultado", "$resultado")
        Log.e("Resultado", "$resultado")
        Log.wtf("Resultado", "$resultado")
        crearLog()
        callBackFun{
            Log.wtf("No se", "Ejecutando")
        }

        callBackFunTwo({
            Log.wtf("Funcion", "first")
        }){
            Log.wtf("Funcion", "Action")
        }
        //If - else
        if(num2<30){
            crearLogConMsg("es Menor")
        }else{
            crearLogConMsg("es Mayor")
        }
        if (num2<30)crearLogConMsg("es Menor") else crearLogConMsg("es Mayor")

    //When
    when(num1){
        in 1..5 ->crearLogConMsg("es menorde 6")
        6 -> crearLogConMsg("es igual a 6")
        in 7..20->crearLogConMsg("es mayor que 6")
        else -> crearLogConMsg("entro al else")
    }
     //For
     for(i in 1..5){
         crearLogConMsg("$i")
     }

     //lista de nombres
     val nombres = listOf("Ana","Pedro","Luis","Martin")
     for (nombre in nombres){
         crearLogConMsg("$nombre")
     }

    //For con indice
    for ((index,nombre) in nombres.withIndex()){
        crearLogConMsg("$index - $nombre")
    }

    //While
    var contador = 1
    while (contador <= 5){
        crearLogConMsg("$contador")
        contador++
    }
    //Do while
    var contador2 = 0
    do {
        crearLogConMsg("$contador2")
        contador2++
    } while (contador2 > 5)

        val kia = Carro(4,"picanto",2)
        crearLogConMsg("${kia.antigue}")
        kia.agregarAnios()
        crearLogConMsg("${kia.antigue}")


    // val nissan = Carro(6,10,"sentra")
    // Let para evitar nulos
        val profesor: String? = "Jean"
        val androidProfesor = profesor?.let { nomProfesor ->
            crearLogConMsg(nomProfesor)
        }
    //Run
    val jeep = Carro(4,"Jeep", 20).run {
        agregarAnios()
        for (i in 1..5){
            agregarAnios()
        }

        crearLogConMsg(antigue.toString())
    }



    }
    fun crearLog(): Unit {
        Log.e("Error", "Ejecutando")
    }

    fun crearLogConMsg(msg:String): Unit {
        Log.e("Error", msg)
    }
    fun sumar(a: Int, b:Int): Int{
        return a+b
    }
    fun callBackFun(action: () -> Unit){
        Log.d("callBackFun", "callBackFun")
        action()
    }

    fun callBackFunTwo(firsTAction:()-> Unit, action: () -> Unit){
        firsTAction()
        Log.d("callBackFun", "callBackFun")
        action()
    }

}