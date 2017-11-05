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


public class BTC_sell extends Fragment {

    private static TextView resultsBox;
    private static TextView amountBox;
    TextView Btc_sellPrice;
    private static TextView TotalViewBox;
    EditText enterdValues;
    double results;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_btc_sell, container, false);

        resultsBox = (TextView)view.findViewById(R.id.diplayBox);

        enterdValues = (EditText)view.findViewById(R.id.inputdigz);
        resultsBox = (TextView)view.findViewById(R.id.diplayBox);
        amountBox = (TextView)view.findViewById(R.id.Sellamount);
        Btc_sellPrice = (TextView)view.findViewById(R.id.btc_sellPrice);
        TotalViewBox = (TextView)view.findViewById(R.id.btcTotal);


        BTC_Fragment_View btcFragmentView = (BTC_Fragment_View)getActivity();
        String BTC_IdValue = btcFragmentView.getMyData();
        String BTC_sellValue = btcFragmentView.getSellingPrice();

        TotalViewBox.setText("Total" +  BTC_IdValue  );
        Btc_sellPrice.setText(BTC_sellValue);



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
        double btc_sell = Double.parseDouble(Btc_sellPrice.getText().toString());
        double myEnter = 1;
        if (enterdValues != null )
            myEnter = Double.parseDouble(!enterdValues.getText().toString().equals("")?
                    enterdValues.getText().toString() : "0");
        results = myEnter * btc_sell;
        String shwthis = String.valueOf(results);
        resultsBox.setText(shwthis);
    }

    public interface onSetBtcSellPrice{
        public void setBTCSellName(String text);
    }

}
