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

/**
 * Created by cokimutai on 10/13/2017.
 */
public class BTC_Results_Fragment extends Fragment {

    private static TextView resultsBox;
    private static TextView amountViewBox;
    private static TextView Btc_buyPrice;
    EditText enterdValues;
    double results;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState){
        final View view = inflater.inflate(
                R.layout.btc_results_fragment, container, false);

        resultsBox = (TextView)view.findViewById(R.id.diplayBox);

        enterdValues = (EditText)view.findViewById(R.id.inputdigz);
        resultsBox = (TextView)view.findViewById(R.id.diplayBox);
        amountViewBox = (TextView)view.findViewById(R.id.amount);
        Btc_buyPrice = (TextView)view.findViewById(R.id.btc_buyPrice);


        BTC_Fragment_View act = (BTC_Fragment_View)getActivity();
        String myDats = act.getMyData();
        String buyPrice = act.getBuyingPrice();
        amountViewBox.setText("Amount" +myDats + ":");
        Btc_buyPrice.setText(buyPrice);

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

        double btc_buy = Double.parseDouble(Btc_buyPrice.getText().toString());
        double myEnter = 1;
        if (enterdValues != null )
            myEnter = Double.parseDouble(!enterdValues.getText().toString().equals("")?
                    enterdValues.getText().toString() : "0");
        results = myEnter * btc_buy;
        String shwthis = String.valueOf(results);
        resultsBox.setText(shwthis);
    }

    public interface OnSetNameListener{
        public void setName(String text);
    }
}
