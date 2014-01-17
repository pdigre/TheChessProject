package no.pdigre.chess.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileUtils {

    public static ArrayList<String> stream2lines(InputStream in) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                lines.add(line);
            }
            in.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static String stream2string(InputStream in) {
    	ArrayList<String> lines = stream2lines(in);
    	StringBuffer sb = new StringBuffer();
    	for (String line:lines)
			sb.append(line+"\r\n");
	    return sb.toString();
    }

}
