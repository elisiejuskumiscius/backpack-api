package com.example.backpackapi.validator;

import com.example.backpackapi.exceptions.RequestException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BackpackValidator {

    public static void validateRequest(int kilometers, String date) {
        if (kilometers < 1 || kilometers > 100) {
            throw new RequestException(String.format("Entered invalid kilometers value %s", kilometers));
        }

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        try {
            sdf.parse(date);
        } catch (ParseException e) {
            throw new RequestException(String.format("Entered invalid date value %s", date));
        }
    }
}
