package com.cokimutai.cryprrency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Created by cokimutai on 10/11/2017.
 */
public class Crypto_Spinner extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceStance){
        super.onCreate(savedInstanceStance);
        setContentView(R.layout.crypto_spinner);

        Intent theIntent = getIntent();
        final String currencyAbbrv = theIntent.getStringExtra("abrreviation");
        final String buyingPrice = theIntent.getStringExtra("buying");
        final String ETH_buyingPrice = theIntent.getStringExtra("eth buying");
        final String btc_sellingPrice = theIntent.getStringExtra("btc_sell");
        final String eth_sellingPrice = theIntent.getStringExtra("eth selling");

        final Spinner spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent;

                switch (position){
                    case 0:
                        break;

                    case 1:
                        intent = new Intent(Crypto_Spinner.this, BTC_Fragment_View.class);
                        intent.putExtra("abrreviation", currencyAbbrv);
                        intent.putExtra("buying", buyingPrice);
                        intent.putExtra("btc_sell", btc_sellingPrice);
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(getApplication(), ETH_Fragment_View.class);
                        intent.putExtra("abrreviation", currencyAbbrv);
                        intent.putExtra("buying", buyingPrice);
                        intent.putExtra("eth buying", ETH_buyingPrice);
                        intent.putExtra("btc_sell", btc_sellingPrice);
                        intent.putExtra("eth selling", eth_sellingPrice);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
