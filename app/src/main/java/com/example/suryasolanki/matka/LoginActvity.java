package com.example.suryasolanki.matka;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActvity extends AppCompatActivity {

    private EditText editEmail,editPassword;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    private FirebaseAuth firebaseAuth;
    private static final String TAG="Email Password";

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actvity);



        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null) {
            Intent intent = new Intent(LoginActvity.this, MainActivity.class);
        }

            editEmail=(EditText) findViewById(R.id.email);
            editPassword=(EditText)findViewById(R.id.password);
            progressBar=(ProgressBar) findViewById(R.id.progressBar);
            progressBar=(ProgressBar) findViewById(R.id.progressBar);

            btnLogin=(Button) findViewById(R.id.btn_login);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signIn(editEmail.getText().toString(),editPassword.getText().toString());
                }
            });

        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.d(TAG,"on AuthStateChanged AuthStateListener: Signed in"+user.getUid());

                }
                else{
                    Log.d(TAG,"on AuthStateChanged AuthStateListener: Signed out");
                    firebaseAuth.signOut();
                }
            }
        };



    }

    private void signInButtonCheck(){

    }

    public void signIn(String email,String password){
        Log.d(TAG,"SignIn");

        if(!Validate()){
            return;
        }

        progressBar.setVisibility(ProgressBar.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginActvity.this,HomeActivity.class));
                        }
                        Log.d(TAG,"Successfull Login"+task.isSuccessful());
                        if(!task.isSuccessful()){
                            Log.w(TAG,"Login Failed"+task.getException());
                            Toast.makeText(LoginActvity.this,"Login Unsuccessfull Enter correct Credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        progressBar.setVisibility(ProgressBar.GONE);
    }

    private boolean Validate(){
        String email=editEmail.getText().toString();
        String password=editEmail.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Email required ",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Password required ",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null) {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }
}
