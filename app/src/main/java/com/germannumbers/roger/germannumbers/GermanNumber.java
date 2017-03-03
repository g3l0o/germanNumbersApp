package com.germannumbers.roger.germannumbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roger on 14/02/17.
 */
public class GermanNumber {
    private static final Map<Integer, String> LESS_THAN_TWENTY = new HashMap<Integer, String>();
    private static final Map<Integer, String> TENS = new HashMap<Integer, String>();
    private static final Map<Integer, String> HUNDREDS = new HashMap<Integer, String>();

    public GermanNumber(){
        initiateDictionaries();
    }

    public String fromNumberToString(int n){
        if(n < 20){
            return LESS_THAN_TWENTY.get(n);
        }else if (n < 100){
            int tens = (int) ((n/10) * 10);
            int units = n - tens;
            String un = (units != 0) ? LESS_THAN_TWENTY.get(units) : "";
            if(units <= 2 & units != 0){
                un = un.substring(0, un.length()-1);
            }
            return  un + (units != 0 ? "und" : "") +TENS.get(tens);
        }else if (n < 1_000){
            int hun = (int) (n/100);
            int tens = n - (hun*100);
            String tenAnswer = (tens != 0) ? fromNumberToString(tens) : "";
            String hund = fromNumberToString(hun);
            String hundAnswer = (hun <= 2) ? hund.substring(0, hund.length()-1) : hund;
            return hundAnswer + "hundert" + tenAnswer;
        }else if (n < 1_000_000){
            int thousand = (int) (n/1_000);
            int hundreds = n - (thousand * 1_000);
            String thousandAnswer = fromNumberToString(thousand) + "tausend";
            String hundredsAnswer = (hundreds != 0) ? fromNumberToString(hundreds) : "";
            return thousandAnswer + hundredsAnswer;

        }else{
            return "No yet implemented";
        }
    }

    private void initiateDictionaries() {
        // TODO Auto-generated method stub
        initiateLessThanTwenty();
        initiateTens();

    }

    private void initiateLessThanTwenty() {
        // TODO Auto-generated method stub
        LESS_THAN_TWENTY.put(0, "null");
        LESS_THAN_TWENTY.put(1, "eins");
        LESS_THAN_TWENTY.put(2, "zweis");
        LESS_THAN_TWENTY.put(3, "drei");
        LESS_THAN_TWENTY.put(4, "vier");
        LESS_THAN_TWENTY.put(5, "fünf");
        LESS_THAN_TWENTY.put(6, "sechs");
        LESS_THAN_TWENTY.put(7, "sieben");
        LESS_THAN_TWENTY.put(8, "acht");
        LESS_THAN_TWENTY.put(9, "neun");
        LESS_THAN_TWENTY.put(10, "zehn");
        LESS_THAN_TWENTY.put(11, "elf");
        LESS_THAN_TWENTY.put(12, "zwölf");
        LESS_THAN_TWENTY.put(13, "dreizehn");
        LESS_THAN_TWENTY.put(14, "vierzehn");
        LESS_THAN_TWENTY.put(15, "fünfzehn");
        LESS_THAN_TWENTY.put(16, "sechzehn");
        LESS_THAN_TWENTY.put(17, "siebzehn");
        LESS_THAN_TWENTY.put(18, "achtzehn");
        LESS_THAN_TWENTY.put(19, "neuzehn");
    }

    private void initiateTens() {
        // TODO Auto-generated method stub
        TENS.put(20, "zwanzig");
        TENS.put(30, "dreissig");
        TENS.put(40, "vierzig");
        TENS.put(50, "fünfzig");
        TENS.put(60, "sechzig");
        TENS.put(70, "siebzig");
        TENS.put(80, "achtzig");
        TENS.put(90, "neunzig");
    }
}
