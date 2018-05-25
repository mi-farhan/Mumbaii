package com.example.com.mumbai;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PrePartnerInfo extends AppCompatActivity {
EditText Edname,Edemail,Edcity;
TextView already;
Button submit;
DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("test");
DatabaseReference rootref,demoref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_partner_info);
        Edname=(EditText)findViewById(R.id.name);
        Edemail=(EditText)findViewById(R.id.email);
        Edcity=(EditText)findViewById(R.id.city);
        submit=(Button)findViewById(R.id.btn);
        already=(TextView)findViewById(R.id.alreadyFilled);
        rootref=FirebaseDatabase.getInstance().getReference();
        demoref=rootref.child("test");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PrePartnerInfo.this,PartnerSuggestion.class);
                String iCity=Edcity.getText().toString().trim();
                i.putExtra("city",iCity);
                saveUserInfo();
                startActivity(i);
            }
        });


    }

    private void saveUserInfo() {
        String name=Edname.getText().toString().trim();
        String email=Edemail.getText().toString().trim();
        String city=Edcity.getText().toString().trim();
        if (Edname.getText().length()>0 && Edemail.getText().length()>0 && Edcity.getText().length()>0){
            UserInformation userInformation=new UserInformation(name,email,city);

            //demoref=uniqueKey usme child banayega name ka and thn uski value set karega
            demoref.push().setValue(userInformation);
        }else if(Edemail.getText().length()>0 && Edcity.getText().length()>0){
            Edname.setError("Provide Your Name");
        }else if(Edname.getText().length()>0 && Edemail.getText().length()>0){
            Edname.setError("Provide This");
        }else if(Edname.getText().length()>0 && Edcity.getText().length()>0){
            Edname.setError("Provide This");
        }else {
            Toast.makeText(PrePartnerInfo.this,"Something Missing",Toast.LENGTH_LONG).show();
        }


    }

    public void dialog(View view) {
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(PrePartnerInfo.this);
        View mView=getLayoutInflater().inflate(R.layout.activity_partner,null);
        final EditText search=(EditText)mView.findViewById(R.id.search);
        Button mSearchButton=(Button)mView.findViewById(R.id.btn);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=search.getText().toString().trim();
                Intent i=new Intent(PrePartnerInfo.this,PartnerSuggestion.class);
                i.putExtra("city",str);
                startActivity(i);
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog=mBuilder.create();
        dialog.show();
    }
}
