package com.api.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverter {
    public static Date convertStringToDate(String data) throws ParseException {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (java.util.Date) formatter.parse(data);

            return date;
        } catch (ParseException e) {
            throw e;
        }
    }

    public static String convertDateToString(Date data) throws ParseException {
        return data != null
                ? new SimpleDateFormat("dd/MM/yyyy").format(data)
                : "";
    }
}
