/*
 * SymbolBalance Done by Ecclesiastes Gan
 * UNI: efg2123
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class SymbolBalance {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		MyStack <Character> Stack = new MyStack <Character>();//create my stack
		boolean quote = false;// setting boolean to keep track of whether I am in a quote
		boolean comment = false;//setting boolean to keep track of whether I am in a comment
		
		
	try{
		FileReader TestingProgram = new FileReader(args [0]);//get the file from the command line
		BufferedReader bufferReader = new BufferedReader(TestingProgram);;//throw the file into bufferReader
		String line = bufferReader.readLine();//assign string line to every line the buffer reads
			
		while(line != null){//checking that there's a next line
			//System.out.println(line); <-- reinstate this to see whether i go through everyline until an unbalance is found
			for(int i = 0; i <= line.length() - 1; i++)//for loop to go through every character of the line
			{
				
				char current = line.charAt(i);//assigning the variable to current
				//Start of the check for balance quotes
				if(current == '"' && comment == false){
					//while i am not in a quote or comment and my current char is a quote.
					//changes inquote to true
					if(quote == false){
						quote = true;//i am now in a quote
					}
					//if there is balance change quote back to false
					else{
						quote = false;
					}
				}
				//if quote does not have a balance by the end of the line
				if(quote == true && (i == line.length()-1)){
					System.out.println("The Quotes are imbalanced");
					System.exit(0);
				}
				//start of comments
				if(i<line.length()-1){//prevents outofbounds error
					if(current == '/' && line.charAt(i+1) == '*' && comment == false){
					//while i am not in a quote or comment and my current and next current is a /* and comment == false	
							comment = true;//change to I AM NOW IN A QUOTE
							Stack.push(current);
							Stack.peek();
					}
					//checks for ending comment signature
					else if(current == '*' && line.charAt(i+1) == '/'){
					if(!Stack.isEmpty()){
						comment = false;
							if(Stack.peek() != '/'){
								System.out.println("Unbalanced comments");
								System.exit(0);
							}
							Stack.pop();
					}
					}
				}
				//checks for brackets balances
				if( current == '(' || current == '[' || current == '{')
				{
					if(quote == false && comment == false)//THIS IS VERY KEY LINE OF CODE, BECAUSE I DON'T WANT TO SEE IMBALANCES IN COMMENTS AND QUOTES
					{
						Stack.push(current);//pushes the current char if its an opening bracket
					}
				}	
				if(current == ')' || current  == '}' || current  == ']'){ //if i see a closing bracket
					if(quote == false && comment == false)//and i am not in a quote/comment
					{
						if(Stack.isEmpty()){//if the stack is empty the closing symbol is unbalanced
							System.out.print(current + " This symbol is unbalanced");
							System.exit(0);
						}
						else if((current == ')' && Stack.peek() == '(') || (current == ']' && Stack.peek() == '[') 
								|| (current  == '}' && Stack.peek() == '{')){
								Stack.pop();//else if there's a match on the top of the stack respectively POP
						}
						//These 3 else if's checks for matching brackets if current is a closing bracket, and if it doesnt match the top stack BAM ERROR
						else if(current == ')' && Stack.peek() != '('){
							System.out.println("Imbalance Symbol: " + current);
							System.exit(0);
						}
						else if(current == '}' && Stack.peek() != '{'){
							System.out.println("Imbalance Symbol: " + current);
							System.exit(0);
						}
						else if(current == ']' && Stack.peek() != '['){
							System.out.println("Imbalance Symbol: "+ current);
							System.exit(0);
						}
					}
				}	
			}//end of THE BIG FOR LOOP THAT GETS EVERY CHARACTER PER LINE
			
			line = bufferReader.readLine();//moves the while loop to the next line 
		}//end of while
		if(!Stack.isEmpty()){//if the stack is not empty and the top comment is a /* comment you are missing a balancing comment
			if(Stack.peek() == '/'){
				System.out.println("You are missing a balancing comment: /*");
				System.exit(0);
			}//otherwise i just print the top of the stack and say that it is the unbalanced symbol pretty lazy but it solves the HOMEWORK!
			System.out.println( Stack.peek() + " This is the unbalanced symbol");
			System.exit(0);
		}//however if everything is balanced HOORAY
		System.out.println("Congrats no imbalances have been found!");
		System.out.println("Honestly, all these if statements were so hard to deal with");
			//remember to close if not ill cause some leakage i can't rmb why its important I WILL RESEARCH THIS AFTER
			bufferReader.close();
			TestingProgram.close();
	}
		catch(IOException e){
			System.out.print("FileNotFound Exception");
		}
	
	}
}

