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
    List<IconClicker> iconsList;
    float w;
    float h;
    float offset;
    float score, showscore;
    TextObject textScore;

    private void create()
    {
        //Variables
        iconsList = new ArrayList<IconClicker>();
        w = ((MainActivity)context).getWidth();
        h = ((MainActivity)context).getHeight();
        offset = 0.2f;

        //Score
        score = 0;

        //Loop
        for(int i = 0; i < 5; i++)
        {
            //Create
            IconClicker obj = (IconClicker) instantiate( new IconClicker(context, this, 0, 0, i));

            //Set Scale
            float scale = (w * 0.26f) / obj.spriteGetWidth();
            obj.setOriginScale( scale);

            //Add
            iconsList.add( obj);
        }

        //Create HUD
        textScore = (TextObject) instantiate(new TextObject( context, this, w * 0.5f, h * 0.5f));
        textScore.setStyle( 75, 255, 97, 53, Paint.Align.CENTER, Typeface.DEFAULT_BOLD);
    }

    public void step()
    {
        //Rotating
        offset += 0.002f;

        //Iterating
        for(int i = 0; i < 5; i++)
        {
            //Pos
            float posx = (w * 0.5f) + (float) (Math.cos((((float) (i) + offset) / 5f) * 2f * Math.PI) * (w * 0.32f));
            float posy = (h * 0.5f) + (float) (Math.sin((((float) (i) + offset) / 5f) * 2f * Math.PI) * (w * 0.32f));

            //Set
            iconsList.get(i).setPos( posx, posy);
        }

        //Showscore
        if (showscore != score)
        {
            showscore += (score - showscore) * 0.1f;
            textScore.setText("" + Math.round(showscore));
        }
    }

    //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // ////////////
    public void reshuffle( boolean acertou)
    {
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
