package com.devtoledo.conversorbtc;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devtoledo.conversorbtc.remote.repository.BitcoinClient;
import com.devtoledo.conversorbtc.remote.repository.PriceList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private Load load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load = new Load(this);

        this.mViewHolder.editAmount = (EditText) findViewById(R.id.edit_amount);
        this.mViewHolder.textDollar = (TextView) findViewById(R.id.text_dollar);
        this.mViewHolder.textEuro = (TextView) findViewById(R.id.text_euro);
        this.mViewHolder.textReal = (TextView) findViewById(R.id.text_real);
        this.mViewHolder.buttonCalculate = (Button) findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bitcoin Converter");
        }

        this.clearValues();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_calculate) {
            String amountString = this.mViewHolder.editAmount.getText().toString();
            if (TextUtils.isEmpty(amountString)) {
                this.clearValues();
            } else {
                final Double amount = Double.valueOf(this.mViewHolder.editAmount.getText().toString());
                BitcoinClient client = new BitcoinClient();
                BitcoinClient.Client bitcoinClient = client.getClient();

                load.show();

                Log.i("MainActivity", "Vai chamar");
                Call<Map<String, PriceList>> call = bitcoinClient.getPriceList();
                call.enqueue(new Callback<Map<String, PriceList>>() {
                                 @Override
                                 public void onResponse(Call<Map<String, PriceList>> call, Response<Map<String, PriceList>> response) {

                                     Map<String, PriceList> prices = response.body();
                                     Log.i("MainActivity", "Retorno: " + prices);

                                     PriceList usd = prices.get("USD");
                                     PriceList eur = prices.get("EUR");
                                     PriceList brl = prices.get("BRL");

                                     mViewHolder.textDollar.setText(String.format("%.2f", amount * usd.getBuy()));
                                     mViewHolder.textEuro.setText(String.format("%.2f", amount * eur.getBuy()));
                                     mViewHolder.textReal.setText(String.format("%.2f", amount * brl.getBuy()));

                                     load.hide();
                                 }

                                 @Override
                                 public void onFailure(Call<Map<String, PriceList>> call, Throwable t) {
                                     Log.e("MainActivity", "Erro: " + t);
                                     load.hide();
                                 }
                             }
                );
            }
        }

    }

    private void clearValues() {
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textReal.setText("");
    }

    private static class ViewHolder {

        EditText editAmount;
        TextView textDollar;
        TextView textEuro;
        TextView textReal;
        TextView buttonCalculate;


    }
}
