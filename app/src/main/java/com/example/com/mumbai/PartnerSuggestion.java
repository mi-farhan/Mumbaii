package com.example.com.mumbai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class PartnerSuggestion extends AppCompatActivity {
TextView textView;
DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("test");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_suggestion);
        textView=(TextView)findViewById(R.id.retriev);
        //String str=getIntent().getStringExtra("city");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                collect((Map<String,Object>)dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void collect(Map<String, Object> value) {
        String search=getIntent().getStringExtra("city").trim();
        ArrayList<String> city=new ArrayList<>();
        ArrayList<String>name=new ArrayList<>();
        ArrayList<String>email=new ArrayList<>();
        for (Map.Entry<String,Object>entry:value.entrySet()){
            Map singleUser=(Map)entry.getValue();
            city.add((String) singleUser.get("city"));
            name.add((String) singleUser.get("name"));
            email.add((String) singleUser.get("email"));
        }
        for (int i=0;i<city.size();i++){
            if (city.get(i).equals(search)){
                textView.append("User:\n"+name.get(i)+"\n \t "+email.get(i)+"\n");
            }
        }
    }
}
