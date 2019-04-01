package com.example.myapplication.GameEngine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;

import com.example.myapplication.GameEngine.GameObject;
import com.example.myapplication.GameEngine.GameSystem.GameStep;

public class TextObject extends GameObject {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Field
    protected String text;
    protected Paint custom;

    //Constructor
    public TextObject(Context context, GameStep gameStep, float x, float y)
    {
        //Super
        super( context, gameStep, x, y);

        //Paint
        custom = new Paint();
        custom.setAntiAlias(true);

        //Settings
        text = "Text";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Method Step
    @Override
    public void step()
    {
        //Super step
        super.step();
    }

    // Method Draw
    @Override
    public void draw(Canvas canvas, Paint paint)
    {
        //Super
        super.draw(canvas, paint);

        //Drawtext
        canvas.drawText( text, x, y + custom.getTextSize()*0.35f, custom);
    }

    //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // ////////////
    //Set Text
    public void setText( String text)
    {
        this.text = text;
    }

    //Set Font
    public void setType( Typeface font)
    {
        custom.setTypeface(font);
    }

    //Set Align
    public void setAllign( Paint.Align ali)
    {
        custom.setTextAlign(ali);
    }

    //Set size
    public void setSize( float size)
    {
        custom.setTextSize( size);
    }

    //Set color
    @Override
    public void setColor( int r, int g, int b)
    {
        custom.setARGB( 255, r, g, b);
    }

    //Set Style
    public void setStyle( float size, int r, int g, int b, Paint.Align align, Typeface font)
    {
        //Use all
        setSize(size);
        setColor( r, g, b);
        setAllign(align);
        setType(font);
    }
}
