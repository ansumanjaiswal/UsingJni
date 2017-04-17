package com.example.jaisw.usingjni;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by jaisw on 4/17/2017.
 */

public class TriangleActivity extends Activity {

    GLSurfaceView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        view = new GLSurfaceView(this);
        view.setRenderer(new ShapeRenderer());
        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.onPause();
    }

}
