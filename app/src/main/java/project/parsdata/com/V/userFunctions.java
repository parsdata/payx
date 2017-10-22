package project.parsdata.com.V;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.Toast;

public class userFunctions {
    private Context context;

    private SharedPreferences setting;
    private Toast toast;
    private Typeface typeface;
    public Dialog dialog;

    private String[] englishNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] persianNumbers = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};

    public String toEnglishNumber(String text) {
        if ("".equals(text)) return "";
        String ch, str = "";
        int i = 0;
        while (text.length() > i) {
            ch = String.valueOf(text.charAt(i));
            if (TextUtils.isDigitsOnly(ch)) str += englishNumbers[Integer.parseInt(ch)];
            else str += ch;
            i++;
        }
        return str;
    }

    public String toPersianNumber(String text) {
        if ("".equals(text)) return "";
        String out = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out += persianNumbers[number];
            } else if (c == '٫') {
                out += '،';
            } else {
                out += c;
            }
        }
        return out;
    }

}
