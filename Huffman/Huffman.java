/*
 * Huffman.java created by Ecclesiastes Gan
 * UNI: efg2123
 * this was fun
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Huffman {
	
	private HuffmanNode root; //instance variable of the root
	private HashMap<Character, String> HuffCodeTable; //instance variable Hashmap that assists me in printing the
	//Hash table and encode/decode methods.
	
			/*
			 *   Inner Node Class
		 	 *	 Creates the inner Node class of the Tree
		 	 */
    		private static class HuffmanNode implements Comparable<HuffmanNode> {
        
    			char ch;
    			int frequency;
    			HuffmanNode left;
    			HuffmanNode right;

    			private HuffmanNode(char ch, int frequency,  HuffmanNode left,  HuffmanNode right) {
    				this.ch = ch;
	    			this.frequency = frequency;
	    			this.left = left;
	    			this.right = right;
    			}
    			/*
    			 * shorter code for the original 0,1,-1
    			 * 
    			 * @overrides implemented compareable class
    			 */
    			@Override
    			public int compareTo(HuffmanNode other){
       	
    				return this.frequency - other.frequency;
       	
    			}
    			/*
    			 * Can be ignored made just to check whether my frequency and characters
    			 * were going in to the HashMap
    			 * 
    			 */
    			@Override
    			public String toString(){
    				return this.ch +  ": " + this.frequency;
    			}
    		}
    		/*
    		 * Constructor Huffman Class
    		 * creates the root
    		 */
    		public Huffman(HashMap<Character, Integer> FrequencyTable) {
    			this.root = buildTree(FrequencyTable);//calls the buildTree method which builds the tree
    			this.HuffCodeTable = getCode();//calls the getCode method which essentially prints the tree
    		}
    		/*
    		 * Code that builds the tree done by algorithm explained by Professor Blaer
    		 * takes in my HashMap as a parameter
    		 * uses a Priority Queue instead of a minBinary heap
    		 */
    		private static HuffmanNode buildTree(HashMap<Character, Integer> FrequencyTable){
    			PriorityQueue <HuffmanNode> q = new PriorityQueue<HuffmanNode>();
    			
    			//creates a huffman node consisting off a character and its respective frequency
    			for( char ch : FrequencyTable.keySet()){
    				q.offer(new HuffmanNode(ch, FrequencyTable.get(ch), null, null));
    			}
    			//while loops that essentially builds out the tree
    			//algorithm according to the one explained in class
    			while(q.size() > 1){
    				HuffmanNode leftChild = q.poll();
    				HuffmanNode rightChild = q.poll();
    				HuffmanNode node = new HuffmanNode( 'T' ,leftChild.frequency + rightChild.frequency , leftChild , rightChild);
    				q.add(node);
    			}
    			return q.poll();
    		}
    	   //helper method that checks whether the node is a leaf
     	   private boolean isLeaf(HuffmanNode node) {
 			    if(node == null)
			        return false;    
			    if(node.right == null && node.left == null)
			        return true;
				return false;
			}
     	   
    	    /*
    	     * need to work on decode, if the huffman code is not present i should return an error instead of 
    	     * printing out the word, if the code is DNE at all print error (SOLVED)
    	     * 
    	     * anyway this is the start of my decode method, takes in the user encoded message of 1s and 0s
    	     * creates a string goes through the tree if its a 1 go left if its a 0 go right
    	     * if its a leaf concatenate it to the string
    	     * finally I encode the decoded string and check whether the word is present in my tree, if it is not
    	     * i return an error otherwise i print the decoded message
    	     * 
    	     */
    	    public String decode(String userEncodedMessage){
    	    	String output = "";//instantiates string
    	    	HuffmanNode current = root;//assign current to be root
    	    	//checks that i do not have an empty tree
    	    	if(root == null){
    	    		System.out.println("Your Huffman Tree is empty");
    	    		System.exit(0);
    	    	}
  
    	    	for(int i = 0; i < userEncodedMessage.length(); i++){
    	    		//if user encoded message == 0 go left
    	    		if(userEncodedMessage.charAt(i) == '0'){
    	    			current = current.left;
    	    			if(isLeaf(current)){
    	    				output += current.ch;
    	    				current = root;
    	    			}
    	    		}
    	    		//if user encoded message == 1 go right
    	    		else{
    	    			current = current.right;
    	    			if(isLeaf(current)){
    	    				output += current.ch;
    	    				current = root;
    	    			}
    	    			
    	    			}
    	    	}
    	    	//finally i encode the output string and check whether it is the same as the one given by the user
    	    	//if it is not i exit the program
    	    	if(!encode(output).equals(userEncodedMessage)){
    	    		System.out.println("Faulty Encoded Message was entered, Please rethink your life choices. BYE");
    	    		System.exit(0);
    	    	}
    	 
    	    	return output;
    	   }
    	   /*
    	    * need to work on encode not printing out the encoded message after a "space"
    	    * e.g Way jab encoded message should be "1100001111110101001011111110011"
    	    * but i am getting "11000011111101" (SOLVED)
    	    * ENCODE WORKS PERFECTLY
    	    * 
    	    * I use string builder here to get used to using both concatenation and StringBuilder in general
    	    * anyway, checks whether string entered is empty throws error
    	    * 
    	    * go through the message checks whether the character is inside the HashMap
    	    * if it is i get the respective huffcode
    	    * if it the character is not inside the hashmap exit
    	    */
    	    
    	   public String encode(String userUncodedMessage){
    		   StringBuilder output = new StringBuilder();//create StringBuilder
    		   for(int i = 0; i < userUncodedMessage.length(); i++){
    			   //if the character is not in the HashMap, throw an error otherwise, attach it to the StringBuilder
    			   if(HuffCodeTable.get(userUncodedMessage.charAt(i)) != null)
    			   output.append(HuffCodeTable.get(userUncodedMessage.charAt(i)));
    			   else{
    				   System.out.println("Faulty Code, characters entered not found in Huffman Tree: Please try again!");
    				   System.exit(0);
    			   }
    		   }
   	    
    		   return output.toString();   //print the resulting encoded message
    	   }
    /*
     * 3 methods below are to traverse the huffman tree, and get the huffman code of each leaf in the tree
     * public method getCode() calls private method buildTable
     * PrintTable() prints out the table
     */
    public HashMap<Character, String> getCode(){
    	HashMap<Character, String> HuffcodeTable = new HashMap<>();
    	buildTable(root, HuffcodeTable, "");
    	return HuffcodeTable;
    }
    private void buildTable(HuffmanNode node, HashMap<Character, String> huffcodeTable, String Huffcode ){
    	if(node != null){
    		if(isLeaf(node)){
    			huffcodeTable.put(node.ch, Huffcode);
    		}
    		buildTable(node.left, huffcodeTable, Huffcode + "0");
    		buildTable(node.right, huffcodeTable, Huffcode + "1");
    	}
    }
    public void printTable(){//prints the table
    	System.out.printf("%-8s %-8s %n", "character", "Huffman Code");
    	
    	for(Character key: HuffCodeTable.keySet()){
    		System.out.printf("%-8s %-8s %n", key, " " + HuffCodeTable.get(key));
    	}
    }

	
	
	public static void main(String[] args) {
		if (args.length != 1) {       System.err.println("Usage: java Problem2 <filename>");}
		try{
			BufferedReader TextFile = new BufferedReader(new FileReader(args[0]));
			int c = 0;
			HashMap<Character, Integer> FrequencyTable = new HashMap<>();
			
			//fills up the HashMap with Characters and their respective frequencies.
			while((c = TextFile.read())  != -1 ){
				char currentCharacter = (char) c;
				if(FrequencyTable.containsKey(currentCharacter)){
					FrequencyTable.put(currentCharacter, FrequencyTable.get(currentCharacter)+1);
				}
				else{
					FrequencyTable.put(currentCharacter, 1);
				}
			
				
	
			}
			//creates a new Huffman Tree from the Hashmap
			Huffman newHuffTree = new Huffman(FrequencyTable);
			
			//prints out the tree
			System.out.println("This is the total characters in file including nextLine counters: ");
			System.out.println(newHuffTree.root + "\n");
			System.out.println("____________________________________________________");
			System.out.println("Huffman Table");
			//Print out Table of Characters
			newHuffTree.printTable();
			System.out.println("\n__________________________________________________");
			System.out.println("End of Table");
			//end of print table
			
			//start of decode uses scanner to take in user input encoded message
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter a line of 0s and 1s");
			String input = userInput.readLine();
			//FORCES THE USER TO ENTER ONLY 0s or 1s
			while(!input.matches("^[01]+$")){
				System.out.println("Please enter a line of 0s and 1s ONLY; please reenter your input");
				input = userInput.readLine();
			}
			System.out.println("Decoded message: "+newHuffTree.decode(input));
			System.out.println("Please enter a message an I will encode it for you");
			
			//start of encode
			String input2;
			input2 = userInput.readLine();
			//if the input is empty force the user to keep repeating the input, till not empty
			while(input2.isEmpty()){
				System.out.println("You have entered an empty string, i do not allow that, please retype your input now");
				input2 = userInput.readLine();
			}
			System.out.println("Encoded  message: " + newHuffTree.encode(input2));
		
			TextFile.close();
		
		//catch file input errors	
		}catch (ArrayIndexOutOfBoundsException | FileNotFoundException e) {
			System.out.println("Hi please input a file for me to build a tree from");
			System.exit(0);
		} catch(IOException e){
			e.printStackTrace();
		}

	}
	

}
