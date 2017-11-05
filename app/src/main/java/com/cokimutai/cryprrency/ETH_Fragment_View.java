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
 * Created by cokimutai on 1/1/2017.
 */
public class ETH_Fragment_View extends AppCompatActivity
implements ETH_Results_Fragment.OnSetETHNameListener, ETH_Sell.onSetETHSellPrice {


    TextView textView;
    Button buyButton;
    Button sellButton;


    private String CurrencyId;
    private String ETH_BuyingPrice;
    private String ETH_SellingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eth_activity_fragment);

    textView = (TextView)findViewById(R.id.cCurrency);
    buyButton = (Button)findViewById(R.id.btc_buy_btn);
    sellButton = (Button)findViewById(R.id.btc_sell_button);


    Intent intent = getIntent();
    CurrencyId = intent.getStringExtra("abrreviation");
    ETH_BuyingPrice = intent.getStringExtra("eth buying");
    ETH_SellingPrice = intent.getStringExtra("eth selling");


     textView.setText(CurrencyId);

    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction =
            manager.beginTransaction();
    final ETH_Results_Fragment eth_results_fragment =
            new ETH_Results_Fragment();
    transaction.add(R.id.fragment_container, eth_results_fragment);
    transaction.commit();


    buyButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = getIntent();
            CurrencyId = intent.getStringExtra("abrreviation");

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction =
                    manager.beginTransaction();
            transaction.replace(R.id.fragment_container, eth_results_fragment );
            transaction.commit();

        }
    });

    sellButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction =
                    manager.beginTransaction();
            ETH_Sell ethSell = new ETH_Sell();
            transaction.replace(R.id.fragment_container, ethSell );
            transaction.commit();
        }
    });
    }

    public String getCurrencyId(){
        return CurrencyId;
    }
    public String getBuyingPrice(){
        return ETH_BuyingPrice;
    }
    public String getETH_SellPrice(){
        return ETH_SellingPrice;
    }

    // Override Interface methods:
    @Override
    public void setETHName(String text) {

    }

    @Override
    public void setBTCSellName(String text) {

    }
}
