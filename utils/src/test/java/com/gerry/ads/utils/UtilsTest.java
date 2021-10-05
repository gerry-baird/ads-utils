package com.gerry.ads.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    void testGetAge50() throws ParseException {

        String sNow="28/06/2021";
        String sDob="15/06/1971";

        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sDob);
        Date now = new SimpleDateFormat("dd/MM/yyyy").parse(sNow);

        int age = Utils.getAge(now, dob);

        assertEquals(50, age);
    }

    @Test
    void testGetAge5() throws ParseException {

        String sNow="01/05/2021";
        String sDob="15/06/2015";

        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sDob);
        Date now = new SimpleDateFormat("dd/MM/yyyy").parse(sNow);

        int age = Utils.getAge(now, dob);

        assertEquals(5, age);
    }

    @Test
    void testGetAge16() throws ParseException {

        String sNow="04/10/2021";
        String sDob="26/09/2005";

        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sDob);
        Date now = new SimpleDateFormat("dd/MM/yyyy").parse(sNow);

        int age = Utils.getAge(now, dob);

        assertEquals(16, age);
    }

}