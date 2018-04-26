package com.example.sthottam.bahamianvat;

import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.text.Html;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

//import com.inducesmile.completecalculatorapp.helpers.Helper;
//import com.inducesmile.completecalculatorapp.ultility.Calculator;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.function.Function;


public class SecondActivity extends Fragment implements View.OnClickListener {
    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button plus, subtract, divide, multiply, plusMinus;
    private Button ac, percent, dot, double_zero, equal;
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private TextView outputResult;
    private Calculator mCalculator;
    public SimpleCalculatorFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_calculator, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        outputResult = view.findViewById(R.id.display);
        outputResult.setText("");
        mCalculator = new Calculator();
        one = view.findViewById(R.id.one);
        two = view.findViewById(R.id.two);
        three = view.findViewById(R.id.three);
        four = view.findViewById(R.id.four);
        five = view.findViewById(R.id.five);
        six = view.findViewById(R.id.six);
        seven = view.findViewById(R.id.seven);
        eight = view.findViewById(R.id.eight);
        nine = view.findViewById(R.id.nine);
        zero = view.findViewById(R.id.zero);
        plus = view.findViewById(R.id.plus);
        subtract = view.findViewById(R.id.minus);
        divide = view.findViewById(R.id.divide);
        multiply = view.findViewById(R.id.multiply);
        plusMinus = view.findViewById(R.id.plus_minus);
        ac = view.findViewById(R.id.ac);
        percent = view.findViewById(R.id.percent);
        dot = view.findViewById(R.id.dot);
        double_zero = view.findViewById(R.id.double_zero);
        equal = view.findViewById(R.id.equal);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        plusMinus.setOnClickListener(this);
        ac.setOnClickListener(this);
        percent.setOnClickListener(this);
        dot.setOnClickListener(this);
        double_zero.setOnClickListener(this);
        equal.setOnClickListener(this);
        return view;
    }
    private void obtainInputValues(String input){
        switch (input){
            case "0":
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;
            case "1":
                currentDisplayedInput += "1";
                inputToBeParsed += "1";
                break;
            case "2":
                currentDisplayedInput += "2";
                inputToBeParsed += "2";
                break;
            case "3":
                currentDisplayedInput += "3";
                inputToBeParsed += "3";
                break;
            case "4":
                currentDisplayedInput += "4";
                inputToBeParsed += "4";
                break;
            case "5":
                currentDisplayedInput += "5";
                inputToBeParsed += "5";
                break;
            case "6":
                currentDisplayedInput += "6";
                inputToBeParsed += "6";
                break;
            case "7":
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                break;
            case "8":
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                break;
            case "9":
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                break;
            case ".":
                currentDisplayedInput += ".";
                inputToBeParsed += ".";
                break;
            case "+":
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                break;
            case "-":
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                break;
            case "/":
                currentDisplayedInput += "/";
                inputToBeParsed += "/";
                break;
            case "x":
                currentDisplayedInput += "*";
                inputToBeParsed += "*";
                break;
            case "%":
                currentDisplayedInput += "%";
                inputToBeParsed += "%";
                break;
            case "00":
                currentDisplayedInput += "00";
                inputToBeParsed += "00";
                break;
            case "=":
                currentDisplayedInput += "00";
                inputToBeParsed += "00";
                break;
        }
        outputResult.setText(currentDisplayedInput);
    }
    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        Toast.makeText(getContext(), "Click " + data, Toast.LENGTH_LONG).show();
        if(data.equals("AC")){
            outputResult.setText("");
            currentDisplayedInput = "";
            inputToBeParsed = "";
        }
        else if(data.equals("=")){
            String enteredInput = outputResult.getText().toString();
            // call a function that will return the result of the calculate.
            String resultObject = mCalculator.getResult(currentDisplayedInput, inputToBeParsed);
            outputResult.setText(removeTrailingZero(resultObject));
        }
        else{
            obtainInputValues(data);
        }
    }
    private String removeTrailingZero(String formattingInput){
        if(!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if(newValue.equals(".0")){
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }





}