package com.cokimutai.cryprrency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by cokimutai on 10/13/2017.
 */
public class BTC_Fragment_View extends AppCompatActivity
        implements BTC_Results_Fragment.OnSetNameListener,BTC_sell.onSetBtcSellPrice {

    TextView textView;
    Button buyButton;
    Button sellButton;

    private String myVal;
    private String buyingPrice;
    private String sellingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btc_activity_fragment);

        textView = (TextView)findViewById(R.id.cCurrency);
        buyButton = (Button)findViewById(R.id.btc_buy_btn);
        sellButton = (Button)findViewById(R.id.btc_sell_button);

        Intent intent = getIntent();
        myVal = intent.getStringExtra("abrreviation");
        buyingPrice = intent.getStringExtra("buying");
        sellingPrice = intent.getStringExtra("btc_sell");

        textView.setText(myVal);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =
                manager.beginTransaction();
        final BTC_Results_Fragment btcResultsFragment =
                new BTC_Results_Fragment();
        transaction.add(R.id.fragment_container, btcResultsFragment);
        transaction.commit();


        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction =
                        manager.beginTransaction();
                transaction.replace(R.id.fragment_container, btcResultsFragment );
                transaction.commit();

            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction =
                        manager.beginTransaction();
                BTC_sell btcSell = new BTC_sell();
                transaction.replace(R.id.fragment_container, btcSell );
                transaction.commit();
            }
        });
    }

    public String getMyData(){
        return myVal;
    }
    public String getBuyingPrice(){
        return buyingPrice;
    }

    public String getSellingPrice(){
        return sellingPrice;
    }

    @Override
    public void setName(String text) {

    }

    @Override
    public void setBTCSellName(String text) {

    }

}
