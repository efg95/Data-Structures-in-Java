/*
 * Problem1.java done by Ecclesiastes Gan
 * UNI: efg2123
 */

//import java.util.Scanner;

public class Problem1 {

    // Start the test
    public static void main(String[] args) {
    	
    	//all this scanner stuff is actually asking for user input, i didn't read that we only needed to hardcode in postfix expressions my bad.
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter a postfix expression: ");
        //String postfix = in.nextLine();
    	
    	//test subject given in assignment, works fine.
    	String postfix = "34 2 - 5 *";
        ExpressionTree tree = new ExpressionTree(postfix);
        System.out.println("Postfix: " + tree.postfix());
        System.out.println("Prefix: " + tree.prefix());
        System.out.println("Infix: " + tree.infix());
        System.out.println("Evaluated expression: " + tree.eval());
        
        
        //my own test postfix materials
        System.out.println("________________________________________________________");
        System.out.println("My Own Tester");
        String postfix1 = "1 2 + 3 * 6 + 2 3 + /";
        ExpressionTree tree1 = new ExpressionTree(postfix1);
        System.out.println("Postfix: " + tree1.postfix());
        System.out.println("Prefix: " + tree1.prefix());
        System.out.println("Infix: " + tree1.infix());
        System.out.println("Evaluated expression: " + tree1.eval());
        
        //my own test postfix materials tests for empty input
        System.out.println("________________________________________________________");
        System.out.println("My Own Tester");
        String postfix2 = "";//empty input
        ExpressionTree tree2 = new ExpressionTree(postfix2);
        System.out.println("Postfix: " + tree2.postfix());
        System.out.println("Prefix: " + tree2.prefix());
        System.out.println("Infix: " + tree2.infix());
        System.out.println("Evaluated expression: " + tree2.eval());
        
        //tests for null input
        System.out.println("________________________________________________________");
        System.out.println("My Own Tester");
        String postfix3 = null;
        ExpressionTree tree3 = new ExpressionTree(postfix3);
        System.out.println("Postfix: " + tree3.postfix());
        System.out.println("Prefix: " + tree3.prefix());
        System.out.println("Infix: " + tree3.infix());
        System.out.println("Evaluated expression: " + tree3.eval());

    }
}
