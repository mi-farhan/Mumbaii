package com.example.com.mumbai;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup2 extends AppCompatActivity {
    EditText etmail,pass;
    String email,passt;
    Button submit;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.layoutSignup);
        AnimationDrawable animationDrawable= (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        firebaseAuth = FirebaseAuth.getInstance();

        submit=(Button)findViewById(R.id.submit_signup);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                initialize();

                if(!validate()){
                    Toast.makeText(signup2.this,"Failed",Toast.LENGTH_LONG).show();
                }else {
                    submite();
                }
            }
        });
    }

    private boolean validate() {
        boolean valid=true;
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            valid=false;
            etmail.setError("Please Enter A valid Email");
        }if(pass.getText().toString().length()<6){
            valid=false;
            pass.setError("Please enter password of length 6");
        }
        return valid;
    }

    public void initialize() {
        progressDialog=new ProgressDialog(this);
        etmail=(EditText) findViewById(R.id.email_signup);
        pass=(EditText) findViewById(R.id.password_signup);
        email=etmail.getText().toString().trim();
        passt=pass.getText().toString().trim();

    }

    public void submite() {
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,passt).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(signup2.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(signup2.this,curCity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(signup2.this,"Error Occured while registering user",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });

    }
}
