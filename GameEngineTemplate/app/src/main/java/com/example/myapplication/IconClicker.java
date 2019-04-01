package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import com.example.myapplication.GameEngine.GameSystem.GameStep;
import com.example.myapplication.GameEngine.SpriteObject;

public class IconClicker extends SpriteObject {

    //Field
    private boolean correctOne,avaiable;
    private int nextFace;
    private float originScale,targetScale;

    //Constructor
    public IconClicker(Context context, GameStep gameStep, float x, float y, int face)
    {
        //Super
        super( context, gameStep, x, y);

        //Target
        targetScale = 1f;
        originScale = 1f;
        avaiable = true;
        nextFace = 0;

        // Set correct sprite
        setFace( face);
    }

    //Step
    @Override
    public void step()
    {
        //Super
        super.step();

        //Custom
        if (avaiable == true)
        {
            targetScale = originScale;
        }
        else
        {
            targetScale = 0f;
        }

        //Learp
        float newScale = (imageXscale + (targetScale - imageXscale)*0.25f);
        setScale( newScale, Math.max( newScale, originScale));

        //Check
        if ((avaiable == false) && (newScale < 0.03f))
        {
            //Avaiable
            avaiable = true;
            setFace( nextFace);
        }
    }

    //OnClick
    @Override
    public void onClick()
    {
        imageXscale += 0.2f;
        imageYscale += 0.2f;
        controller.reshuffle( (correctOne == true));
    }

    //ChangeFace
    public void changeFace(int face)
    {
        //Avaiable
        avaiable = false;
        nextFace = face;
    }

    //SetFace
    private void setFace(int face)
    {
        // Set correct sprite
        switch (face)
        {
            case 0:
                setSprite( new int[] {R.drawable.icon1});
                break;
            case 1:
                setSprite( new int[] {R.drawable.icon2});
                break;
            case 2:
                setSprite( new int[] {R.drawable.icon3});
                break;
            case 3:
                setSprite( new int[] {R.drawable.icon4});
                break;
            case 4:
                setSprite( new int[] {R.drawable.icon5});
                break;
        }

        // Set value
        if (face == 0)
        {
            correctOne = true;
        }
        else
        {
            correctOne = false;
        }
    }

    //SetOriginScale
    public void setOriginScale( float value)
    {
        originScale = value;
    }
}
