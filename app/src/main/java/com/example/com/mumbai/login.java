package com.example.com.mumbai;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    CheckBox checkBox;
    EditText edPass,edEmail;
    TextView forgotPass;
    Button loginBtn;
    final String user="travel";
    final String pass="guide";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.login_lay);
        AnimationDrawable animationDrawable=(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        checkBox=(CheckBox) findViewById(R.id.checkBox);
        edEmail=(EditText)findViewById(R.id.email_login);
        edPass=(EditText) findViewById(R.id.pass_login);
        loginBtn=(Button) findViewById(R.id.login_btn);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    edPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
                    edPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }

    public void forgotPass(View view) {
        Intent fogPass=new Intent(this,Activity2.class);
        startActivity(fogPass);
    }

    public void signup(View view) {
        Intent fogPass=new Intent(this,signup2.class);
        startActivity(fogPass);
    }

    public void login(View view) {
        String email=edEmail.getText().toString().trim();
        String pass=edPass.getText().toString().trim();
        if(edEmail.getText().length()>0){
            if (edPass.getText().length()>0){
                progressDialog.setMessage("Signing In");
                progressDialog.show();
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            progressDialog.dismiss();
                            Toast.makeText(login.this,"Logged In Successfully",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(login.this,curCity.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(login.this,"Something went Wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }else {
                edPass.setError("Please Enter Password");
            }
        }else{
            edEmail.setError("Please Enter Email");
        }
    }
}
