/*
* Done By Ecclesiastes Gan
* UNI: efg2123
*/
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem2 {

    // Entry point of the program
    public static void main(String[] args) {
    	try{
        AvlTree tree = new AvlTree();//creates new AVL tree
        Scanner inFile = new Scanner(new File(args[0]));//take in the file
        int lineNumber = 0;//instantiates a line number

        while (inFile.hasNextLine()) {
            lineNumber++;//increase the lineNumber every iteration of the while loop
            String line = inFile.nextLine();

            try(Scanner scanner = new Scanner(line);)
            {
            while (scanner.hasNext()) {
            	/*
            	 * to be honest i didn't know how to get rid of all punctuations
            	 * so i googled and i found out how to
            	 * http://stackoverflow.com/questions/23332146/remove-punctuation-preserve-letters-and-white-space-java-regex
            	 */
                String word = scanner.next().toLowerCase().replaceAll("\\W", "");
                tree.indexWord(word, lineNumber);
            }
            }
        }

        inFile.close();
        tree.printIndex();
        System.out.println("This is the line numbers where 'you' is found " + tree.getLinesForWord("you"));
    	}
    	catch(IOException e){
            System.out.println("Invalid file name given");
            System.out.println(e.getMessage());
    	}
    	catch(ArrayIndexOutOfBoundsException e){
    		System.out.println("No file inputted into command line HOW DARE YOU!");
    	}
    	finally{

        }
    }
}
