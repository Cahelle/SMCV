package com.example.laptopcahelle.csi_week_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Textv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textv = (TextView)findViewById(R.id.subjectNameTextview);
        Intent in= getIntent();
        Bundle b = in.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("suspectName");
            Textv.setText(j);
        }
        Button btn = (Button) findViewById(R.id.ReportBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
