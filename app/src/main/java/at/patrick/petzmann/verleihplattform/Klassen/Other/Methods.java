package at.patrick.petzmann.verleihplattform.Klassen.Other;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Methods {
    @RequiresApi(api = Build.VERSION_CODES.N)


    public static Date toDateFormat(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        Date datum = formatter.parse(s);

        return datum;
    }

    public static Date dateToday() {

        return Calendar.getInstance().getTime();

    }

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^29\\.02\\.((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$"
                    + "|^(0[1-9]|1[0-9]|2[0-8])\\.02\\.(((19|2[0-9])[0-9]{2}))$"
                    + "|^(0[1-9]|[12][0-9]|3[01])\\.(0[13578]|10|12)\\.(((19|2[0-9])[0-9]{2}))$"
                    + "|^(0[1-9]|[12][0-9]|30)\\.(0[469]|11)\\.(((19|2[0-9])[0-9]{2}))$");

    public static boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }

    public static boolean PASSWORD_PATTERN(String password) {
        if (password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}")) {
            return true;
        } else return false;
    }

    public static boolean FILLED_REGISTER(String vorname, String nachname, String username, String adresse, String plz, String ort, String password1, String password2) {
        if (vorname.isEmpty() || nachname.isEmpty() || username.isEmpty() || adresse.isEmpty() || plz.isEmpty() || ort.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
            return false;
        } else return true;
    }

    public static String dateToString(Date date){
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");

        String ausgabe = format.format(date);

        return ausgabe;
    }

}
