package com.example.suryasolanki.matka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

public class PhoneLogin extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "nRDimMhaS8K510nUupHVicN2K";
    private static final String TWITTER_SECRET = "BaZdoyrCnYM5rWsCCjlLbI6h3Xik1pg7aDy6WVXshfpnSP2gf6";
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());
        setContentView(R.layout.activity_phone_login);

        //sharedPreferences=getApplicationContext().getSharedPreferences("LoginShared",MODE_PRIVATE);

            sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getBoolean("Key_LOGIN",false)){
            Intent intent=new Intent(PhoneLogin.this,HomeActivity.class);
            startActivity(intent);
        }

        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getApplicationContext(), "Authentication successful for "
                        + phoneNumber, Toast.LENGTH_LONG).show();
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("KEY_LOGIN",true);
                editor.commit();
            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });


    }

    public void onRestart(){
        super.onRestart();

        if(sharedPreferences.getBoolean("Key_LOGIN",false)){
            Intent intent=new Intent(PhoneLogin.this,HomeActivity.class);
            startActivity(intent);
        }

    }
}
