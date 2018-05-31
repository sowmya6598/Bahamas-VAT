package com.example.sthottam.bahamianvat;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView Results;
    EditText Price;
    Button AddButton, SubtractButton;

    double result;
    double vat;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Results = findViewById(R.id.Results);

        Price = findViewById(R.id.Price);

        AddButton = findViewById(R.id.AddButton);
        SubtractButton = findViewById(R.id.SubtractButton);



        AddButton.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                double price = Double.parseDouble(Price.getText().toString());

                DecimalFormat df = new DecimalFormat("######.##");

                if(price > 0.00 && price < 0.21) {
                    result = Double.parseDouble(df.format(price + 0.01));
                }
                else {
                    result = Double.parseDouble(df.format(price * 1.12));
                }

                vat = Double.parseDouble(df.format(result - price));
                Results.setText(
                        "Excluding VAT " + "$" + price + "\n" +
                                "VAT (12% )" + "$" + vat + "\n" +
                                "Including VAT " + "$" + String.valueOf(result)
                );

            }
        });

        SubtractButton.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                double price = Double.parseDouble(Price.getText().toString());

                DecimalFormat df = new DecimalFormat("#####.##");

                if(price > 0.00 && price < 0.21) {
                    result = Double.parseDouble(df.format(price - 0.01));
                }
                else {
                    result = Double.parseDouble((df.format(price / 1.12)));
                }

                vat = Double.parseDouble(df.format(price - result));
                Results.setText(
                        "Including VAT " + "$" + price + "\n" +
                                "VAT (12%) " + "$" + vat + "\n" +
                                "Excluding VAT " + "$" + String.valueOf(result)
                );
            }
        });

        Price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView myTextView = findViewById(R.id.Results);
                myTextView.setText("");
            }
        });

//        EditText editText = findViewById(R.id.Price);
//
//        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    AddButton.performClick();
//                    return true;
//                }
//                return false;
//            }
//        });


    }
}