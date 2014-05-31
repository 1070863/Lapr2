/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author
 */
public class Utils {
    /**
     * 
     * @param strPrompt
     * @return 
     */
    public static String readLineFromConsole(String strPrompt) {
        try {
            System.out.println(strPrompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 
     * @param strPrompt
     * @return 
     */
    public static Date readDateFromConsole(String strPrompt) {
        do {
            try {
                String strDate = readLineFromConsole(strPrompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     *
     * @param stEmail
     * @return
     *
     * email tem de ser sempre em minúsculas, não acentuado, sem espaços e no
     * meio conter @
     *
     * email validation by mkyong.com:
     * http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
     */
    static public boolean validaEmail(String stEmail) {
        String EMAIL_PATTERN
                = "^[a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(stEmail);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
