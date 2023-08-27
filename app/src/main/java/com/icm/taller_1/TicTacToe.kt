package com.icm.taller_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.icm.taller_1.databinding.ActivityMainBinding
import com.icm.taller_1.databinding.ActivityTicTacToeBinding

class TicTacToe : AppCompatActivity() {

    enum class Turn{
        EQUIS,
        CIRCULO
    }

    private var firstTurn = Turn.EQUIS
    private var currentTurn = Turn.EQUIS
    private var boardList= mutableListOf<Button>()
    private lateinit var binding: ActivityTicTacToeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()

        binding.Reinicio.setOnClickListener(){
            resetBoard()
        }
    }

    private fun initBoard() {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun boardTapped(view: View){
        if(view !is Button)
            return
        addToBoard(view)

        if(Campeon(CIRCULO)){
            result("Campeon O")
        }
        else if(Campeon(EQUIS)){
            result("Campeon X")
        }

        if(fullBoard()){
            result("Empate")
        }

    }

    private fun Campeon(s: String): Boolean {
        if (match(binding.a1,s) && match(binding.a2,s) && match(binding.a3,s))
            return true
        if (match(binding.b1,s) && match(binding.b2,s) && match(binding.b3,s))
            return true
        if (match(binding.c1,s) && match(binding.c2,s) && match(binding.c3,s))
            return true

        if (match(binding.a1,s) && match(binding.b1,s) && match(binding.c1,s))
            return true
        if (match(binding.a2,s) && match(binding.b2,s) && match(binding.c2,s))
            return true
        if (match(binding.a3,s) && match(binding.b3,s) && match(binding.c3,s))
            return true


        if (match(binding.a1,s) && match(binding.b2,s) && match(binding.c3,s))
            return true
        if (match(binding.a3,s) && match(binding.b2,s) && match(binding.c1,s))
            return true
        return false
    }

    private fun match(button: Button,simbolo:String): Boolean = button.text == simbolo

    private fun result(s: String) {
        binding.result.text = s
    }

    private fun resetBoard(){
        for (button in boardList){
            button.text=""
        }

        if(firstTurn == Turn.CIRCULO)
            firstTurn = Turn.EQUIS
        else if (firstTurn == Turn.EQUIS)
            firstTurn = Turn.CIRCULO

        currentTurn = firstTurn
        binding.result.text = " "
        setTurnColor()
    }

    private fun fullBoard(): Boolean {
        for(button in boardList){
            if (button.text == " ")
                return true
        }
        return false
    }

    private fun addToBoard(view: Button) {
        if(view.text != "")
            return

        if(currentTurn == Turn.CIRCULO){
            view.text = CIRCULO
            currentTurn = Turn.EQUIS
        }
        else if(currentTurn == Turn.EQUIS){
            view.text = EQUIS
            currentTurn = Turn.CIRCULO
        }
        setTurnColor()
    }

    private fun setTurnColor() {
        if(currentTurn == Turn.EQUIS){
            binding.x.setTextColor(ContextCompat.getColor(this, R.color.blue))
            binding.o.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
        else if(currentTurn == Turn.CIRCULO){
            binding.o.setTextColor(ContextCompat.getColor(this, R.color.blue))
            binding.x.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }

    companion object{
        const val CIRCULO = "O"
        const val EQUIS = "X"

    }

}