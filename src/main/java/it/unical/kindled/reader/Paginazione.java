package it.unical.kindled.reader;

import java.util.ArrayList;
import java.util.List;

public class Paginazione {
    private static final int MAX_PAROLE_PAG=1289;
    public static List<String> split(String text){
        List<String> pagine= new ArrayList<>();

        if(text == null || text.isBlank()){
            return pagine;
        }
        text = text.replace("\r\n", "\n");
        String[] frasi = text.split("(?<=[.!?])\\s+");
        StringBuilder pagina = new StringBuilder();

        for (String frase : frasi) {
            if (pagina.length() + frase.length() > MAX_PAROLE_PAG) {

                if (!pagina.isEmpty()) {
                    pagine.add(pagina.toString());
                    pagina = new StringBuilder();
                }
            }

            pagina.append(frase).append(" ");
        }
        if (!pagina.isEmpty()) {
            pagine.add(pagina.toString());
        }

        return pagine;
    }
}


