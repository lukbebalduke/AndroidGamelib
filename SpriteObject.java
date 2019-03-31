package com.example.myapplication.GameEngine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.example.myapplication.GameEngine.GameSystem.GameStep;

public class SpriteObject extends GameObject {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Field
    protected Bitmap[] sprite;
    protected float imageIndex, imageSpeed;
    protected float imageYscale, imageXscale;
    protected boolean clickable;

    //Constructor
    public SpriteObject(Context context, GameStep gameStep, float x, float y)
    {
        //Super
        super( context, gameStep, x, y);

        //Settings
        clickable = true;

        //Sprite
        imageIndex = 0;
        setImageSpeed( 0.1f);
        setScale( 1, 1);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Method Step
    @Override
    public void step()
    {
        //Super step
        super.step();

        //Animation
        tickAnimation();
    }

    // Method Draw
    @Override
    public void draw(Canvas canvas, Paint paint)
    {
        //Super
        super.draw(canvas, paint);

        //Get info
        float h = sprite[ getImageIndex()].getHeight() * imageYscale;
        float w = sprite[ getImageIndex()].getWidth() * imageXscale;

        //Verts
        float verts[] = new float[8];

            //Top left
            verts[0] = (x - w*0.5f);
            verts[1] = (y - h*0.5f);

            //Top right
            verts[2] = (x + w*0.5f);
            verts[3] = (y - h*0.5f);

            //Bottom left
            verts[4] = (x - w*0.5f);
            verts[5] = (y + h*0.5f);

            //Bottom right
            verts[6] = (x + w*0.5f);
            verts[7] = (y + h*0.5f);

        //Draw Sprite
        canvas.drawBitmapMesh( sprite[ getImageIndex()], 1, 1, verts, 0, null, 0, paint);
    }

    //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // ////////////
    //Set Sprite
    public void setSprite( int id[])
    {
        //New
        sprite = new Bitmap[id.length];

        //Iterate
        for( int i = 0; i < id.length; i++)
        {
            sprite[i] = BitmapFactory.decodeResource( context.getResources(), id[i]);
        }
    }

    //Set Scale
    public void setScale( float imageXscale, float imageYscale)
    {
        //Set
        this.imageXscale = imageXscale;
        this.imageYscale = imageYscale;
    }

    //Set Speed
    public void setImageSpeed( float value)
    {
        this.imageSpeed = value;
    }

    //Get imageIndex
    public int getImageIndex()
    {
        return (int) Math.floor( imageIndex);
    }

    //Tick animation
    private void tickAnimation()
    {
        //Values
        float size = (float)sprite.length;

        //Tick
        imageIndex += imageSpeed;
        if (imageIndex >= size)
        {
            imageIndex -= size;
        }
    }

    //Verify Click
    @Override
    public boolean collisionPoint( float mousex, float mousey)
    {
        // Collision box
        float h = sprite[ getImageIndex()].getHeight() * imageYscale;
        float w = sprite[ getImageIndex()].getWidth() * imageXscale;

        // In box
        if ((clickable == true) && ( mousex >= (x - w*0.5)) && ( mousey >= (y - h*0.5)) && ( mousex <= (x + w*0.5)) && ( mousey <= (y + h*0.5)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
