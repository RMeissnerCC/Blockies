package com.pixels.blockies.app;


import android.app.Activity;
import android.os.Bundle;

import com.pixels.blockies.app.game.BlockMover;


public class GameActivity extends Activity {
    DrawingView drawView = null;
    BlockMover mover = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new DrawingView(this);
        mover = new BlockMover();
        drawView.setBlockMover(mover);
        Thread movementThread = new Thread(mover);
        movementThread.start();
        setContentView(drawView);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }
}
