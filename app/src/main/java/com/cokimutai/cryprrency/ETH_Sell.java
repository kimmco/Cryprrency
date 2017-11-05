package com.cokimutai.cryprrency;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ETH_Sell extends Fragment {

    private static TextView resultsBox;
    private static TextView amountBox;
    private static TextView Eth_sellPrice;
    private static TextView TotalViewBox;
    EditText enterdValues;
    double results;



    public ETH_Sell() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.eth__sell_fragment, container, false);

        resultsBox = (TextView)view.findViewById(R.id.diplayBox);

        enterdValues = (EditText)view.findViewById(R.id.inputdigz);
        resultsBox = (TextView)view.findViewById(R.id.diplayBox);
        amountBox = (TextView)view.findViewById(R.id.Sellamount);
        Eth_sellPrice = (TextView)view.findViewById(R.id.eth_sellPrice);
        TotalViewBox = (TextView)view.findViewById(R.id.ethTotal);

        ETH_Fragment_View ethFragmentView = (ETH_Fragment_View) getActivity();
        String currency = ethFragmentView.getCurrencyId();
        String sellValue = ethFragmentView.getETH_SellPrice();

        TotalViewBox.setText("Total" +  currency  );
        Eth_sellPrice.setText(sellValue);

        Selection.setSelection(enterdValues.getText(), enterdValues.getText().length());

        enterdValues.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculate();

            }
        });
        return view;
    }

    private void calculate() {
        double btc_sell = Double.parseDouble(Eth_sellPrice.getText().toString());
        double myEnter = 1;
        if (enterdValues != null )
            myEnter = Double.parseDouble(!enterdValues.getText().toString().equals("")?
                    enterdValues.getText().toString() : "0");
        results = myEnter * btc_sell;
        String shwthis = String.valueOf(results);
        resultsBox.setText(shwthis);
    }

    public interface onSetETHSellPrice{
        public void setBTCSellName(String text);
    }
}
