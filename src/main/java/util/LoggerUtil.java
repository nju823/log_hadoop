package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by cong on 2018-03-08.
 */
public class LoggerUtil {

    public static void log(String message){
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("log",true));
            bufferedWriter.append('\n');
            bufferedWriter.append(message);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
