package com.example.sthottam.bahamianvat;

class Calculator {

    public String getResult(String currentDisplay, String expressionUsedForParsing) {
        try {
            System.out.println("Displayed Output " + expressionUsedForParsing);
        } catch (Exception e) {
            currentDisplay = "Error";
        }
        return currentDisplay;
    }
}
