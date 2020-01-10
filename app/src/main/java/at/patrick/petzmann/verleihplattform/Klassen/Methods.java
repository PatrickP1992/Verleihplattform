package at.patrick.petzmann.verleihplattform.Klassen;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.util.Date;

public class Methods {
    @RequiresApi(api = Build.VERSION_CODES.N)


    public static Date toDateFormat(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");


        Date datum = formatter.parse(s);


        return datum;
    }
}
