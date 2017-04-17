package com.example.jaisw.usingjni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnGetData;
    TextView text;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("native-passdatalib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        initView();
        btnGetData.setOnClickListener(getOnClickListener());
    }

    private void initView(){
        btnGetData = (Button)findViewById(R.id.btn);
        text = (TextView)findViewById(R.id.tv);
    }

    private View.OnClickListener getOnClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(getStringFromJNI());
            }
        };
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String getStringFromJNI();
}
