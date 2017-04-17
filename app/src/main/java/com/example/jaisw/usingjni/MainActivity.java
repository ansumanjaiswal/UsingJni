package com.example.jaisw.usingjni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String BUNDLE_STRING_KEY = "jniStringKey";
    private static final String BUNDE_INT_KEY = "jniIntKey";
    Button btnGetStringData;
    Button btnGetIntegerData;
    Button btnShowTriangle;
    TextView tv_stringFromJni;
    TextView tv_integerFromJni;
    Context activityContext;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-passdatalib");
        System.loadLibrary("native-intlib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityContext = this;
        // Example of a call to a native method
        initView();
        btnGetStringData.setOnClickListener(getOnClickListenerForStringFromJNI());
        btnGetIntegerData.setOnClickListener(getOnClickListenerForIntegerFromJNI());
        btnShowTriangle.setOnClickListener(getOnClickListenerForShowTriangle());
        if(savedInstanceState != null){
            reloadDataFromBundle(savedInstanceState);
        }
    }

    private void reloadDataFromBundle(Bundle bundle) {
        tv_stringFromJni.setText(bundle.getString(BUNDLE_STRING_KEY));
        tv_integerFromJni.setText(bundle.getString(BUNDE_INT_KEY));
    }

    private void initView(){
        btnGetStringData = (Button)findViewById(R.id.btn_getString);
        btnGetIntegerData = (Button)findViewById(R.id.btn_getInt);
        btnShowTriangle = (Button)findViewById(R.id.btn_showTriangle);
        tv_stringFromJni = (TextView)findViewById(R.id.tv_string_from_jni);
        tv_integerFromJni = (TextView)findViewById(R.id.tv_integer_from_jni);
    }

    private View.OnClickListener getOnClickListenerForStringFromJNI(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_stringFromJni.setText(getStringFromJNI());
            }
        };
    }

    private View.OnClickListener getOnClickListenerForIntegerFromJNI(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_integerFromJni.setText("The Sum of 5 and 7 = "+getIntFromJNI(5,7));
            }
        };
    }

    private View.OnClickListener getOnClickListenerForShowTriangle(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activityContext,
                        TriangleActivity.class));
            }
        };
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_STRING_KEY, tv_stringFromJni.getText().toString());
        outState.putString(BUNDE_INT_KEY, tv_integerFromJni.getText().toString());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String getStringFromJNI();
    public native int getIntFromJNI(int a, int b);
}
