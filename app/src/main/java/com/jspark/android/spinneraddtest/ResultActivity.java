package com.jspark.android.spinneraddtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textResult;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textResult = (TextView)findViewById(R.id.textResult);

        Intent i = getIntent();
        int maximum = i.getExtras().getInt("count");
        result = result + i.getExtras().getString("resultOrg");

        for(int j=0;j<maximum;j++) {
            result = result +" / "+ i.getExtras().getString("result"+(j+1));
        }

        textResult.setText(result);
    }
}
