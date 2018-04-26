package com.example.sthottam.bahamianvat;

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

        Results = (TextView)findViewById(R.id.Results);

        Price = (EditText)findViewById(R.id.Price);

        AddButton = (Button)findViewById(R.id.AddButton);
        SubtractButton = (Button)findViewById(R.id.SubtractButton);

//        gestureObject = new GestureDetectorCompat(this, new LearnGesture());


        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double price = Double.parseDouble(Price.getText().toString());

                DecimalFormat df = new DecimalFormat("######.##");

                if(price > 0.00 && price < 0.21) {
                    result = Double.parseDouble(df.format(price + 0.01));
                }
                else {
                    result = Double.parseDouble(df.format(price * 1.075));
                }

                vat = Double.parseDouble(df.format(result - price));
                Results.setText(
                        "Excluding VAT " + "$" + price + "\n" +
                                "VAT (7.5% )" + "$" + vat + "\n" +
                                "Including VAT " + "$" + String.valueOf(result)
                );

            }
        });

        SubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double price = Double.parseDouble(Price.getText().toString());

                DecimalFormat df = new DecimalFormat("#####.##");

                if(price > 0.00 && price < 0.21) {
                    result = Double.parseDouble(df.format(price - 0.01));
                }
                else {
                    result = Double.parseDouble((df.format(price / 1.075)));
                }

                vat = Double.parseDouble(df.format(price - result));
                Results.setText(
                        "Including VAT " + "$" + price + "\n" +
                                "VAT (7.5%) " + "$" + vat + "\n" +
                                "Excluding VAT " + "$" + String.valueOf(result)
                );
            }
        });


    }

//    private GestureDetectorCompat gestureObject;
//
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        this.gestureObject.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
//
//    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
//
//        @Override
//        public boolean onFling(MotionEvent event1, MotionEvent event2,
//                               float velocityX, float velocityY) {
//
//            if (event2.getX() < event1.getX()) {
//
//                Intent intent = new Intent(
//                        MainActivity.this, SecondActivity.class);
//                finish();
//                startActivity(intent);
//            }
//            else if (event2.getX() > event1.getX()) {
//
//            }
//            return true;
//
//        }
//
//    }
}