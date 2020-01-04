import java.io.*;
import java.util.Scanner;


    public class Load {
        SpellChecker sp =new SpellChecker();
        HashDictionary dict = new HashDictionary();

        public void loadFile(String path) throws FileNotFoundException {
            Scanner sc = new Scanner(new File (path));
            System.out.println("loading file.........");
            int i=0;
            while(sc.hasNextLine() && i<10 ) {
               String s = sc.nextLine();
                dict.insert(s);
                i++;
            }
            System.out.println("file has been loaded");
        }

        public void loadFileToCheck(String path) throws FileNotFoundException {
            Scanner sc = new Scanner(new File (path));
            System.out.println("loading file to check.........");
            while(sc.hasNextLine()) {
               String  s = sc.nextLine();
                if(sp.checkWord(s, dict.getDictionary()))
                    System.out.println(s+" is correct");
                else
                    System.out.println(s+" is spelt wrong");

            }
        }


}
