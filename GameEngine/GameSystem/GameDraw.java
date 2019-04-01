package com.example.myapplication.GameEngine.GameSystem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.GameEngine.GameObject;
import com.example.myapplication.GameEngine.SpriteObject;
import com.example.myapplication.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class GameDraw extends View {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Field
    private Context context;
    private Paint paint;
    private int r, g, b;
    private Canvas canvas;

    // Constructor
    public GameDraw(Context context)
    {
        // Super
        super(context);
        this.context = context;

        // Background
        changeBackground( 45, 45, 45);

        // Paint
        paint = new Paint();
    }

    // Main Renderer
    @Override
    protected void onDraw(Canvas canvas)
    {
        //Super
        super.onDraw(canvas);

        //Clear
        canvas.drawRGB(r,g,b);

        //Loop
        for(GameObject obj : ((MainActivity) context).getObjectList())
        {
            obj.draw(canvas,paint);
        }
    }

    //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // //////////// //////////// // ////////////
    // Set background color
    public void changeBackground( int col_red, int col_green, int col_blue)
    {
        r = col_red;
        g = col_green;
        b = col_blue;
        invalidate();
    }

    // Get Canvas
    public Canvas getCanvas()
    {
        return canvas;
    }
}
