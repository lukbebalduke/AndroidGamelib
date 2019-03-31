package com.example.myapplication.GameEngine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.myapplication.GameEngine.GameSystem.GameStep;

// Essa classe deve ser abstrata
public abstract class GameObject
{
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Fields
    protected float x=0,y=0,z=0;
    protected int color=0;

    //Controllers
    protected Context context;
    protected GameStep controller;

    //Constructor
    public GameObject(Context context, GameStep controller, float x, float y)
    {
        //Setting initial values
        this.context = context;
        this.controller = controller;

        //Setting initial pos
        setPos( x, y);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Methodo Draw
    public void draw(Canvas canvas, Paint paint)
    {

    }

    // Methodo Step
    public void step()
    {

    }

    //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // ////////////
    // setPos
    public void setPos( float posx, float posy)
    {
        x = posx;
        y = posy;
    }

    // setDepth
    public void setDepth( float posz)
    {
        z = posz;
    }

    // setColor
    public void setColor( int r, int g, int b)
    {
        //Set color
        color = Color.rgb(r, g, b); //(r & 0x0ff) << 16)|((g&0x0ff)<<8)|(b&0x0ff);
    }

    // On Click
    public void onClick()
    {

    }

    // Collision Point
    public boolean collisionPoint( float mousex, float mousey)
    {
        return false;
    }
}
