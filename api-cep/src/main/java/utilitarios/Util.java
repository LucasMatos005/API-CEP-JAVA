package utilitarios;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
    public static String converteJsonEmString(BufferedReader bufferedReader) throws IOException {
        String resposta, jsonString = "";
        while ((resposta = bufferedReader.readLine()) != null) {
            jsonString += resposta;
        }
        return jsonString;
    }

}
