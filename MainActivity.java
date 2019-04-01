package com.example.myapplication;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.myapplication.GameEngine.GameObject;
import com.example.myapplication.GameEngine.GameSystem.GameDraw;
import com.example.myapplication.GameEngine.GameSystem.GameStep;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Field
    GameDraw gameDraw;
    GameStep gameStep;
    List<GameObject> gameObjects;
    FrameLayout frameLayout;

    //On Create
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Super and set content
        super.onCreate(savedInstanceState);

            //Fullscreen
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Create list
        gameObjects = new ArrayList<GameObject>();

        // Initialize game
        initializeGameSystems();
    }

    //Initialize systems
    private void initializeGameSystems()
    {
        // GameDraw
        frameLayout = (FrameLayout)
                findViewById(R.id.frameLayout);
        gameDraw = new GameDraw(this);
        gameDraw.changeBackground( 255, 229, 117);
        frameLayout.addView(gameDraw);

        // GameStep
        gameStep = new GameStep( this);

        // Game Thread
        new Thread(new Runnable() {

            // Running game
            private volatile boolean running = true;

            // Thread run method and calling updates
            public void run()
            {
                while(running)
                {
                    //Tick

                        //Controller
                        gameStep.step();

                        //Objects
                        for(GameObject obj : gameObjects)
                        {
                            obj.step();
                        }

                        //Render
                        gameDraw.invalidate();

                    //Next
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //Touch event
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // Get position
        int x = (int)event.getX();
        int y = (int)event.getY();

        // Switch statements
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                // Loop and check interaction
                for(GameObject obj : gameObjects)
                {
                    //Check if clicked
                    if (obj.collisionPoint( x, y))
                    {
                        obj.onClick();
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }

    //Add object to list
    public void addList(GameObject id)
    {
        //Add to list
        gameObjects.add( id);
    }

    //Get list of the objects in game
    public List<GameObject> getObjectList()
    {
        return gameObjects;
    }

    //Get view percent
    public float getWidth()
    {
        //Display and point
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //Value
        return (size.x);
    }

    //Get view percent
    public float getHeight()
    {
        //Display and point
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //Value
        return (size.y);
    }
}
