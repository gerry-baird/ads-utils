package com.gerry.ads.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.rules.engine.annotations.PureFunction;

public class Utils {

    @PureFunction
    public static int getAge(Date now, Date dateOfBirth) {
        LocalDate currentDate = convertToLocalDateViaSqlDate(now);
        LocalDate birthDate = convertToLocalDateViaSqlDate(dateOfBirth);

        if ((birthDate != null) && (currentDate != null)) {
            //return Period.between(birthDate, currentDate).getYears();
            long years = ChronoUnit.YEARS.between(birthDate, currentDate);
            return (int)years;
        } else {
            return 0;
        }
    }

    private static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    @PureFunction
    public static boolean stringDoesNotMatchPattern(String str, String ptn) {

        Pattern myPattern = Pattern.compile(ptn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = myPattern.matcher(str);

        if(matcher.matches()) {
            //If it matches then it's not invalid
            return false;
        }else {
            return true;
        }
    }
}

