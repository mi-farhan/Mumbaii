package com.example.com.mumbai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Partner extends AppCompatActivity {
    EditText ed;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);
        ed=(EditText)findViewById(R.id.search);
        button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=ed.getText().toString().trim();
                Intent i=new Intent(Partner.this,PartnerSuggestion.class);
                if (ed.getText().length()>0){
                    i.putExtra("city",str);
                    startActivity(i);
                }else {
                    ed.setError("Enter city");
                }

            }
        });
    }
}
