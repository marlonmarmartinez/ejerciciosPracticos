
package ejerciciospracticas4;

import java.util.ArrayList;


public class LongestPassword {
    public static void main(String[] args) {
        String S = " prueba 5 a0A pass007? Xy1 ";
        
        System.out.println(longestPassword(S));
        //System.out.println(solution(S));
    }
    public static int solution(String S) {
        
        int res = 0;
        //formamos una matriz con las palabras dadas
        String[] strings = S.split(" ");
        
        //filtramos las palabras con caracteres no alfanuméricos 
        ArrayList<String> listWithAlphanumeric = new ArrayList<>();
        for (String s : strings) {
            if (s.matches("^[a-zA-Z0-9]*$")) 
                listWithAlphanumeric.add(s);
        }
        
        int countLetters = 0;
        int countNumbers = 0;
        ArrayList<String> toRemove = new ArrayList<>();
        // Analizamos cada palabra y contamos sus letras y números.
        // cuando las letras o los números no cumplen con las restricciones, agregamos la palabra a arrayList para Eliminar
        for (String s : listWithAlphanumeric) {
            String lower = s.toLowerCase();
            countLetters = 0;
            countNumbers = 0;
            for (int i = 0; i < lower.length(); i++) {
                if ((lower.codePointAt(i) >= 97 && lower.codePointAt(i) <= 122)) {
                    countLetters++;
                    continue;
                }
                if (lower.codePointAt(i) >= 48 && lower.codePointAt(i) <= 57)
                    countNumbers++;
            }
            if (countLetters % 2 == 1 || countNumbers % 2 == 0)
                toRemove.add(s);
        }
        
         // eliminamos las palabras de toRemove de arrayList listWithAlphanumeric
        for (String s : toRemove) {
            for (String string : listWithAlphanumeric) {
                if (s == null ? string == null : s.equals(string)) {
                    listWithAlphanumeric.remove(string);
                    break;
                }
            }
        }
        
        if (listWithAlphanumeric.isEmpty())
            return -1;
        else
             // encontramos la palabra más larga aceptada
            for (String s : listWithAlphanumeric)
                if (s.length() > res)
                    res = s.length();
        
        return res;
    }
    
     public static int longestPassword(String password) {
        String[] words = password.replaceAll("\\s+", "\\áéíóúñ.,_\\-\\&\\/?").split("[\\áéíóúñ.,_\\-\\&\\/?]");
        
        int maxLength = -1;
        for (String word : words) {
            if (word.matches("^[0-9a-zA-Z]*$") &&
                    word.replaceAll("[0-9]+", "").length() % 2 == 0 &&
                    word.replaceAll("[a-zA-Z]+", "").length() % 2 == 1) {
                maxLength = Math.max(maxLength, word.length());
            }
        }
        return maxLength;
    }
}
