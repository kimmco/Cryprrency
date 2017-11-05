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
public class ETH_Results_Fragment extends Fragment {

    private static TextView resultsBox;
    private static TextView amountView;
    private static TextView ETH_buyPrice;
    EditText enterdValues;
    double results;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState){
        View view = inflater.inflate(
                R.layout.eth_results_fragment, container, false);

        resultsBox = (TextView)view.findViewById(R.id.diplayBox);

        enterdValues = (EditText)view.findViewById(R.id.inputdigz);
        resultsBox = (TextView)view.findViewById(R.id.diplayBox);
        amountView = (TextView)view.findViewById(R.id.eth_amount);
        ETH_buyPrice = (TextView)view.findViewById(R.id.eth_buyPrice);

        ETH_Fragment_View ethFragmentView = (ETH_Fragment_View) getActivity();
        String selectedValue = ethFragmentView.getCurrencyId();
        String buyValue = ethFragmentView.getBuyingPrice();
        amountView.setText("Amount" + selectedValue + ":");
        ETH_buyPrice.setText(buyValue);

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

        double eth_buy = Double.parseDouble(ETH_buyPrice.getText().toString());
        double myEnter = 1;
        if (enterdValues != null )
            myEnter = Double.parseDouble(!enterdValues.getText().toString().equals("")?
                    enterdValues.getText().toString() : "0");
        results = myEnter * eth_buy;
        String shwthis = String.valueOf(results);
        resultsBox.setText(shwthis);
    }

    public interface OnSetETHNameListener{
        public void setETHName(String text);
    }
}
