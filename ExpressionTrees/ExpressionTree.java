/*
 * ExpressionTree done by Ecclesiastes Gan
 * UNI:efg2123
 */
import java.util.Scanner;

public class ExpressionTree {

    private ExpressionNode rootNode = null;
    
    // Creates the expression tree
    private class ExpressionNode {

        public String value;
        public ExpressionNode leftChild;
        public ExpressionNode rightChild;

        // Create a node
        public ExpressionNode(String data) {
            this.value = data;
        }
    }

    // Build an expression tree based on the postfix expression
    public ExpressionTree(String postfix) {
    	if(postfix == null){
    		System.out.println("Invalid input expression, most likely null input");
    		System.exit(0);
    	}
    	if(postfix.length()==0){
    		System.out.println("the expression entered cannot be empty");
    		System.exit(0);
    	}
        MyStack<ExpressionNode> stack = new MyStack<>();//creates a new stack for the expression tree

        // Build the expression tree
        try(Scanner scanner = new Scanner(postfix); )//closes the scanner and the potential memory leak
        {
        while (scanner.hasNext()) {
            String token = scanner.next();//assigns the next equation values to token
            //System.out.println("Token: " + token);
            if (Character.isDigit(token.charAt(0))) {
            	//System.out.println("At zero: " + token.charAt(0));
                stack.push(new ExpressionNode(token));
            } 
            else if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                ExpressionNode node = new ExpressionNode(token);
                node.rightChild = stack.pop();
                node.leftChild = stack.pop();

                if (node.rightChild == null || node.leftChild == null) {
                    System.out.println("Invalid postfix expression");
                    System.exit(0);
                }

                stack.push(node);
            } else {
                System.out.println("Invalid operator/digit found");
                System.exit(0);
            }
        }//end of while
        rootNode = stack.pop();

        if (!stack.isEmpty()) {
            System.out.println("Invalid postfix expression");
            System.exit(0);
        }
    }//end of try
        
    }//end of creation of expression tree
    
    // eval the expression tree
    public int eval() {
        return eval(rootNode);
    }

    // eval the expression tree
    private int eval(ExpressionNode currentNode) {
        if (Character.isDigit(currentNode.value.charAt(0))) {
            return Integer.parseInt(currentNode.value);
        }

        int leftValue = eval(currentNode.leftChild);//recursive call on the leftchild of the rootnode
        int rightValue = eval(currentNode.rightChild);//similar to the top
        
        if(currentNode.value.charAt(0) == '*'){
        	return leftValue * rightValue;
        }
        else if(currentNode.value.charAt(0) == '/'){
        	return leftValue / rightValue;
        }
        else if(currentNode.value.charAt(0) == '+'){
        	return leftValue + rightValue;
        }
        else if(currentNode.value.charAt(0) == '-'){
        	return leftValue - rightValue;
        }
        else
        	return 0;
    }
    // Create postfix expression
    public String postfix() {
        StringBuilder sb = new StringBuilder();
        postfix(rootNode, sb);

        return sb.toString();
    }

    // Create postfix expression
    private void postfix(ExpressionNode currentNode, StringBuilder sb) {
        if (currentNode == null) {
            return;
        }

        postfix(currentNode.leftChild, sb);//recursive call on the left child of the tree
        //appends the left side of the tree of the rootNode
        postfix(currentNode.rightChild, sb);//recursive call on the right child of the tree
        //appends the right side of the tree of the rootNode
        //finally the code below appends the rootNode to the string
        
        /* i read the java api on this and piazza but
         * let me explain what's happening
         * after the currentNode/rootnode goes through the postfix calls
         * it gets attached or appended to a string/stringbuilder
         * the reason i added another .append(" ") is purely because without it my results would look like
         * 342-5* <--- its hard to differentiate that result hence the need to add a string space 
         * in between tokens, i think this is called a (delimiter?)
         */
        //System.out.println("value: " + currentNode.value);
        sb.append(currentNode.value).append(" ");
        
    }

    // Create infix expression
    public String infix() {
        StringBuilder sb = new StringBuilder();
        infix(rootNode, sb);

        return sb.toString();
    }

    // Create infix expression
    private void infix(ExpressionNode currentNode, StringBuilder sb) {
        if (currentNode == null) {
            return;
        }
        /* pretty simple, first recursively append the left side of a root
         * then append the root
         * finally append the right side
         */
        sb.append("( ");
        infix(currentNode.leftChild, sb);
        sb.append(currentNode.value).append(" ");
        infix(currentNode.rightChild, sb);
        sb.append(") ");
    }

    // Create prefix expression
    public String prefix() {
        StringBuilder sb = new StringBuilder();
        prefix(rootNode, sb);

        return sb.toString();
    }

    // Create prefix expression
    //literally a reverse of postfix does not require explanation
    private void prefix(ExpressionNode currentNode, StringBuilder sb) {
        if (currentNode == null) {
            return;
        }

        sb.append(currentNode.value).append(" ");

        prefix(currentNode.leftChild, sb);
        prefix(currentNode.rightChild, sb);
    }
}
