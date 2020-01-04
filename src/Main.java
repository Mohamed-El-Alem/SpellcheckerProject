import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        HashDictionary dict = new HashDictionary();
        Load load = new Load();
        Scanner sc = new Scanner(System.in);
        load.loadFile("C:\\Users\\Mouin\\IdeaProjects\\Course\\src\\dict.txt");
        String word = "";
        boolean b = true;
        while (b) {
            System.out.println("choose an option: ");
            System.out.println("1 - Load a dictionary from a given text file ");
            System.out.println("2 - Search for an entry in the dictionary ");
            System.out.println("3 - insert a word in the dictionary ");
            System.out.println("4 - delete a word from the dictionary ");
            System.out.println("5 - do spell check for a given text file ");
            System.out.println("6 - exit the program ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("type file path or copy it and past it here");
                    String path = sc.next();
                    load.loadFile(path);
                    break;
                case 2:
                    System.out.println("type a word to search :");
                    word = sc.next();
                    dict.search(word);
                    break;
                case 3:
                    System.out.println("type a word to insert in the dictionary: ");
                    word = sc.next();
                    dict.insert(word);
                    break;
                case 4:
                    System.out.println("type a word to delete :");
                    word = sc.next();
                    String deleted = dict.delete(word);
                    if (deleted != null)
                        System.out.println(word + " has been deleted");
                    else
                        System.out.println(word + " does not exist ");
                    break;
                case 5:
                    System.out.println("type file path to check or copy it and past it :");
                    System.out.println("Example: C:\\\\Users\\\\Mouin\\\\IdeaProjects\\\\Course\\\\src\\\\dict.txt");
                    word = sc.next();
                    load.loadFileToCheck(word);
                    break;
                case 6:
                    b = false;
                    break;
            }
        }

    }
        //System.out.println(dict.delete("Aaronical"));
        //System.out.println(dict.search("Aaronical"));
    }




