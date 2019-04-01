package com.example.myapplication.GameEngine.GameSystem;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.myapplication.GameEngine.GameObject;
import com.example.myapplication.GameEngine.TextObject;
import com.example.myapplication.IconClicker;
import com.example.myapplication.MainActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStep {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Field
    Context context;

    //Constructor
    public GameStep(Context context)
    {
        //Context
        this.context = context;

        //Create
        create();
    }

    //Instantiate
    public GameObject instantiate(GameObject id)
    {
        //Add
        ((MainActivity)context).addList(id);

        //Return
        return id;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Field

    private void create()
    {
        
    }

    public void step()
    {

    }

    //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // ////////////
        //Adiciona pontos ou remove
        if (acertou == true)
        {
            //Adiciona
            score += 100;
        }
        else
        {
            //Remove
            score -= 100;
            if (score < 0)
            {
                score = 0;
            }
        }

        //Reembaralha
        ArrayList<Integer> shuffleList = new ArrayList<Integer>();
        shuffleList.add( 0);
        shuffleList.add( 1);
        shuffleList.add( 2);
        shuffleList.add( 3);
        shuffleList.add( 4);
        Collections.shuffle(shuffleList);

        //Cada um dos icones
        for(int i = 0; i < 5; i++)
        {
            iconsList.get(i).changeFace( shuffleList.get(i));
        }
    }
}
