package com.cokimutai.cryprrency;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cokimutai on 10/9/2017.
 */
public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;

    public RecyclerAdapter(Context context){
        this.context = context;
    }

    private String[] currencies = { "United States dollar",
            "Nigerian naira",
            "European euro",
            "Australian dollar",
            "Danish krone",
            "Egyptian pound",
            "Ghanaian cedi",
            "Iranian rial",
            "Israeli new shekel",
            "Japanese yen",
            "Pound sterling",
            "Kenyan shilling",
            "Ugandan shilling",
            "Russian ruble",
            "Rwandan franc",
            "South African rand",
            "Swedish krona",
            "Sri Lankan rupee",
            "Saudi Arabian riyal",
            "UAE dirham",
    };

    private String[] currencies_abbrv = {"(USD)",
            "(NGN)",
            "(EUR)",
            "(AUD)",
            "(DKK)",
            "(EGP)",
            "(GHS)",
            "(IRR)",
            "(ILS)",
            "(JPY)",
            "(GBP)",
            "(KES)",
            "(UGX)",
            "(RUB)",
            "(RWF)",
            "(ZAR)",
            "(SEK)",
            "(LKR)",
            "(SAR)",
            "(AED)",
    };

    private String[] BTC_BuyPrice = {"0.0001415",
            "0.000182",
            "0.0001623",
            "0.000153",
            "0.000143",
            "0.000173",
            "0.000182",
            "0.000183",
            "0.000180",
            "0.000185",
            "0.000183",
            "0.000184",
            "0.000283",
            "0.000182",
            "0.000181",
            "0.000163",
            "0.000191",
            "0.00019",
            "0.000283",
            "0.000173",
    };

    private String[] BTC_SellPrice = {"7031.86",
            "5131.49",
            "6131.49",
            "4131.49",
            "3131.49",
            "5231",
            "6131",
            "6231.41",
            "6231.52",
            "5431.29",
            "5241",
            "3141.49",
            "2131.29",
            "6161.49",
            "6241.32",
            "6131.12",
            "4431.49",
            "4171.11",
            "2214.31",
            "6121",
    };

    private String[] ETH_BuyPrice = {"0.0001830",
            "0.0001840",
            "0.0001830",
            "0.0001844",
            "0.000185",
            "0.000184",
            "0.0001832",
            "0.0001841",
            "0.0001851",
            "0.0001833",
            "0.00018213",
            "0.00018336",
            "0.0001837",
            "0.0001837",
            "0.0001839",
            "0.0001835",
            "0.0001838",
            "0.0001837",
            "0.0001835",
            "0.0001839",
    };


    private String[] ETH_SellPrice = {"5412.5",
            "5413.9",
            "5412.5",
            "5422.5",
            "5415.8",
            "5112.5",
            "5512.5",
            "5472.5",
            "6412.5",
            "5482.5",
            "5912.5",
            "7412.7",
            "5812.6",
            "5112.5",
            "6912.5",
            "6212.5",
            "5812.4",
            "6412.5",
            "4412.5",
            "5492.5",
    };


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView currencyTitle;
        public TextView currencyAbbrv;
        TextView BTC_BuyBox;
        TextView BTC_Sellprice;
        TextView ETH_BuyBox;
        TextView ETH_Sellprice;

        public ViewHolder(View itemView){
            super(itemView);
            currencyTitle =
                    (TextView)itemView.findViewById(R.id.currency_name);
            currencyAbbrv =
                    (TextView)itemView.findViewById(R.id.currency_abbrv);
            BTC_BuyBox =
                    (TextView)itemView.findViewById(R.id.btcBuyView);
            BTC_Sellprice =
                    (TextView)itemView.findViewById(R.id.btcSellPrice);
            ETH_BuyBox =
                    (TextView)itemView.findViewById(R.id.ethBuyPrice);
            ETH_Sellprice =
                    (TextView)itemView.findViewById(R.id.ethSellPrice);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String currencyShortName =
                            currencyAbbrv.getText().toString();
                    String btc_buyPrice =
                            BTC_BuyBox.getText().toString();
                    String btc_Sell =
                            BTC_Sellprice.getText().toString();
                    String eth_buyPrice =
                            ETH_BuyBox.getText().toString();
                    String eth_Sell =
                            ETH_Sellprice.getText().toString();


                    final Intent theIntent =
                            new Intent(context, Crypto_Spinner.class);
                    theIntent.putExtra("abrreviation", currencyShortName);
                    theIntent.putExtra("buying", btc_buyPrice);
                    theIntent.putExtra("btc_sell", btc_Sell);
                    theIntent.putExtra("eth buying", eth_buyPrice);
                    theIntent.putExtra("eth selling", eth_Sell );
                    context.startActivity(theIntent);
                }
            });

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i){

        viewHolder.currencyTitle.setText(currencies[i]);
        viewHolder.currencyAbbrv.setText(currencies_abbrv[i]);
        viewHolder.BTC_BuyBox.setText(BTC_BuyPrice[i]);
        viewHolder.BTC_Sellprice.setText(BTC_SellPrice[i]);
        viewHolder.ETH_BuyBox.setText(ETH_BuyPrice[i]);
        viewHolder.ETH_Sellprice.setText(ETH_SellPrice[i]);

    }
    @Override
    public int getItemCount(){
        return currencies.length;
    }
}
