package com.example.tictacgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buclick(view: View) {
        val buselceted=view as Button
        Log.d("buselect",buselceted.id.toString())
        var cellid=0
        when(buselceted.id)
        {
            R.id.bu1-> cellid=1
            R.id.bu2-> cellid=2
            R.id.bu3-> cellid=3
            R.id.bu4-> cellid=4
            R.id.bu5-> cellid=5
            R.id.bu6-> cellid=6
            R.id.bu7-> cellid=7
            R.id.bu8-> cellid=8
            R.id.bu9-> cellid=9
        }
        Log.d("buselect",buselceted.id.toString())
        Log.d("buclee:",cellid.toString())
        playGame(cellid,buselceted)

    }
    var activePlayer=1
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()

    fun playGame(cellid:Int,buselleted:Button) {
        if(activePlayer==1)
        {       buselleted.text="X"
            buselleted.setBackgroundResource(R.color.blue)
            player1.add(cellid)
            activePlayer=2
            autoPlay()


        }
        else
        {
            buselleted.text="O"
            buselleted.setBackgroundResource(R.color.darkgreen)
            player2.add(cellid)
            activePlayer=1
        }
        buselleted.isEnabled=false



    }
   fun checkWinner()
   {
       var winer=-1
       //row 1
       if(player1.contains(1)&&player1.contains(2)&&player1.contains(3))
       winer=1
       if(player2.contains(1)&&player2.contains(2)&&player2.contains(3))
           winer=2
       //row 2
       if(player1.contains(4)&&player1.contains(5)&&player1.contains(6))
           winer=1
       if(player1.contains(4)&&player1.contains(5)&&player1.contains(6))
           winer=2
       //row3
       if(player1.contains(7)&&player1.contains(8)&&player1.contains(9))
           winer=1
       if(player2.contains(7)&&player2.contains(8)&&player2.contains(9))
           winer=2
      //colum1
       if(player1.contains(1)&&player1.contains(4)&&player1.contains(4))
       winer=1
       if(player2.contains(1)&&player2.contains(4)&&player2.contains(4))
           winer=2

       //colum 2
       if(player1.contains(2)&&player1.contains(5)&&player1.contains(8))
           winer=1
       if(player2.contains(2)&&player2.contains(5)&&player2.contains(8))
           winer=2
       //colum3
       if(player1.contains(3)&&player1.contains(6)&&player1.contains(9))
           winer=1
       if(player2.contains(3)&&player2.contains(6)&&player2.contains(9))
           winer=2
       if(winer==1)
       {
           Toast.makeText(this,"Player 1 win the game",Toast.LENGTH_LONG).show()
           resetGame()
       }
       else if (winer==2)
       {
           Toast.makeText(this,"Player 2 win the game",Toast.LENGTH_LONG).show()
           resetGame()
       }
       else
       {
           resetGame()
       }

   }
    fun autoPlay() {
        var emptyCells=ArrayList<Int>()
        for (cellid in 1..9)
        {
            if(!(player1.contains(cellid)|| player2.contains(cellid)))
                emptyCells.add(cellid)
        }
        val r= Random
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellId=emptyCells[randIndex]
        var buselleted:Button?
        buselleted=when (cellId)
        {
            1->bu1
            2->bu2
            3->bu3
            4->bu4
            5->bu5
            6->bu6
            7->bu7
            8->bu8
            9->bu9
            else->{bu1}

        }
        playGame(cellId,buselleted)
    }
    fun resetGame()
    {
        bu1.setBackgroundResource(R.color.white)
        bu2.setBackgroundResource(R.color.white)
        bu3.setBackgroundResource(R.color.white)
        bu4.setBackgroundResource(R.color.white)
        bu5.setBackgroundResource(R.color.white)
        bu6.setBackgroundResource(R.color.white)
        bu7.setBackgroundResource(R.color.white)
        bu8.setBackgroundResource(R.color.white)
        bu9.setBackgroundResource(R.color.white)
        player1.clear()
        player2.clear()

    }

}
