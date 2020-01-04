import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpellChecker {
    public boolean spellCheck(String input, String dict[]) {
        String current = "";
        boolean noErrors = true;
        Scanner sc = new Scanner(input);
        while (sc.hasNext()) {
            current = sc.nextLine();
            if (!isSpecial(current)) {
                if (!checkWord(current, dict)) {
                    System.out.println(current + " is spelt incorrectly");
                    noErrors = false;
                }
            }
        }
        return noErrors;

    }

    public boolean isSpecial(String input) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        return m.find();
    }

    public boolean checkWord(String input, String dict[]) {
        boolean valid = false;
        int length = dict.length;
        int i = 0;
        while (!valid && i < length) {
            if (input.trim().equalsIgnoreCase(dict[i])) {
                valid = true;
            }
            i++;
        }
        return valid;
    }
}
