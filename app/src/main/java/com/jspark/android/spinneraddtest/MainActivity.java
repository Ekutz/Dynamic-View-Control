package com.jspark.android.spinneraddtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;
    Spinner spinnerOrg;
    Button btnAdd, btnFin, btnDel;

    List<String> data = new ArrayList<>();
    ArrayAdapter<String> adapter;

    final int spinnerFinalNum = 5350;
    int spinnerNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=1;i<6;i++) {
            data.add("list "+i);
        }

        linear = (LinearLayout)findViewById(R.id.linearLayout);
        spinnerOrg = (Spinner)findViewById(R.id.spinnerOriginal);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnFin = (Button)findViewById(R.id.btnFinish);
        btnDel = (Button)findViewById(R.id.btnDelete);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);

        spinnerOrg.setAdapter(adapter);

        setButtonAdd();
        setButtonFinish();
        setButtonDelete();
    }

    private void setButtonAdd() {

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerNum++;
                Spinner newSpin = new Spinner(MainActivity.this);
                newSpin.setId(spinnerFinalNum+spinnerNum);
                newSpin.setAdapter(adapter);
                linear.addView(newSpin, new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
            }
        });
    }

    private void setButtonFinish() {
        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("count", spinnerNum);
                i.putExtra("resultOrg", spinnerOrg.getSelectedItem().toString());
                if(spinnerNum>0){
                    for(int j=1;j<spinnerNum+1;j++) {
                        Spinner getSpinner = (Spinner)findViewById(spinnerFinalNum+j);
                        i.putExtra("result"+j, getSpinner.getSelectedItem().toString());
                    }
                }
                startActivity(i);
            }
        });
    }

    private void setButtonDelete() {
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerNum!=0) {
                    Spinner removeSpinner = (Spinner) findViewById(spinnerFinalNum + spinnerNum);
                    linear.removeView(removeSpinner);
                    spinnerNum--;
                }
            }
        });
    }
}
