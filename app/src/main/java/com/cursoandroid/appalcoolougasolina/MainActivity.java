package com.cursoandroid.appalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText alcoholPrice, gasolinePrice;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcoholPrice = findViewById(R.id.inputAlcoholPrice);
        gasolinePrice = findViewById(R.id.inputGasolinePrice);
        result = findViewById(R.id.result);
    }

    public void calculate(View view) {
        String aPrice = alcoholPrice.getText().toString();
        String gPrice = gasolinePrice.getText().toString();

        Boolean fieldValidated = validateFields(aPrice, gPrice);

        if (fieldValidated) {
            Double alcPrice = Double.parseDouble(aPrice);
            Double gasPrice = Double.parseDouble(gPrice);
            if (alcPrice / gasPrice < 0.7) {
                result.setText(R.string.choose_alcohol);
            } else {
                result.setText(R.string.choose_gasoline);
            }
        }
    }

    public Boolean validateFields(String ap, String gp) {
        if (ap == null || ap.equals("")) {
            result.setText(R.string.insert_alcohol_price);
            return false;
        }
        if (gp == null || gp.equals("")) {
            result.setText(R.string.insert_gasoline_price);
            return false;
        }
        return true;
    }
}