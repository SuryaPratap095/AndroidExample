package com.example.suryasolanki.matka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.suryasolanki.matka.Java.BidData;

public class WalletActivity extends AppCompatActivity {

    private TextView txtWalletAmount;
    private float amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        amount=100;
        BidData.amount=amount;
        txtWalletAmount=(TextView) findViewById(R.id.textWalletAmount);
        txtWalletAmount.setText(String.valueOf(String.format("%.2f",BidData.amount)));

    }
}
