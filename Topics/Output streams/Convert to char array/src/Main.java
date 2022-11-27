import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        // implement the method
        CharArrayWriter cw = new CharArrayWriter();

        for (String word: words){
            cw.write(word);
        }

        return cw.toCharArray();
    }
}