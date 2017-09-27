/*
 *  SpellChecker.java done by Ecclesiastes Gan
 *  UNI: efg2123
 *  date 4/7/2017
 */
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.BufferedReader;
public class SpellChecker {

	public static void main(String[] args) {
		if (args.length != 2) {       System.err.println("Usage: java Problem2 <filename>");}
		try {
			int lineNumber = 0;
			BufferedReader DictionaryReader = new BufferedReader(new FileReader(args[0]));
			BufferedReader TextReader = new BufferedReader(new FileReader(args [1]));
			HashSet <String> DictionaryTable = new HashSet<>();
			String word;
			String line;
			while((word = DictionaryReader.readLine())!=null ){
				//changes all the inputs in the dictionary to lowercase as the homework stated that words were not case sensitive
				DictionaryTable.add(word.toLowerCase() );
			}
			//reads the text file and changes it to lowercase
			while((line = TextReader.readLine()) != null){
				lineNumber++;
				line = line.toLowerCase();
				//splits each word by white space
				String [] txtWord = line.split("\\s+");
				for(int i = 0; i < txtWord.length; i++){
				
					word = txtWord[i];
					//strips all leading and trailing punctuation
					/*
					 * I did not take this from stackoverflow, I actually read and brushed up on my regex
					 * i know what "Punct" does and i know that "^" is for leading and $ is for trailing/ending
					 */
					word = word.replaceAll("^\\p{Punct}+|\\p{Punct}+$","");
					//if the word does not exist in the dictionary print out as misspelled
					if(!word.equals("") && !DictionaryTable.contains(word)){
					System.out.println("This word is misspelled: " + word + " at line number: " + lineNumber);
					
					//prints out the suggestion of what the misspelled words could be
					System.out.println("This is all the suggested words using the 3 rules represented in one line: " + combineSuggestions(word, DictionaryTable));
					}
				}
			}
			DictionaryReader.close();
			TextReader.close();
		} catch (ArrayIndexOutOfBoundsException | FileNotFoundException e) {
			System.out.println("Hi please input a 2 files, a dictionary file first, then the text file you wish to check");
			System.exit(0);
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	/*
	 * Checks whether by adding One additional Character to the misspelled word whether it can be found as a correct word
	 * in the dictionary 
	 */

	public static ArrayList<String> OneAdditionalChar(String input, HashSet<String> dictionary){
		ArrayList <String> wordSuggestions = new ArrayList<>();
		//this is the array which contains all the additionary characters to add to check for word in dictionary
		char [] alphabet = "abcdefghijklmnopqrstuvwxyz'".toCharArray();
		//two for loops that adds the characters and tries out all combinations possible 
		for(int i = 0; i < input.length()+1; i++){
			for(int j = 0; j < alphabet.length; j++){
				
				StringBuilder copyWord = new StringBuilder(input);
				String modifyWord = copyWord.insert(i, alphabet[j]).toString();
				//if the combination satisfies the dictionary's spelling add it to the recommended arrayList
				if(dictionary.contains(modifyWord) && !wordSuggestions.contains(modifyWord))
					wordSuggestions.add(modifyWord);
				
			}
		}
	return wordSuggestions;//returns the recommended spelling corrections
	}
	/*
	 * checks the word for one missing character e.g "gfood" -- could be "food, good"
	 *  
	 */
	public static ArrayList<String> OneCharMissing(String input, HashSet<String> dictionary){
		ArrayList<String> wordSuggestions = new ArrayList<>();
		//for loop that creates all combinations of deleting a character from the misspelled word
		for(int i = 0; i < input.length(); i++){

			
			StringBuilder copyWord = new StringBuilder(input);
			String modifyWord = copyWord.deleteCharAt(i).toString();
			
			//if the combination exists add to the array list of suggested words
			if(dictionary.contains(modifyWord) && !wordSuggestions.contains(modifyWord)){
				wordSuggestions.add(modifyWord);
			}
				
		}
		
		return wordSuggestions; //return the arraylist

	}
	/*
	 * Method to give possible suggestions by swapping adjacent characters like turck --> truck 
	 */
	public static ArrayList<String> AdjacentChar(String input, HashSet<String> dictionary){
		ArrayList<String> wordSuggestions = new ArrayList<>();
		//for loop that tries every possible combination of swapping characters
		for(int i = 0; i < input.length()-1; i++){
			StringBuilder modifyWord = new StringBuilder(input);
			char firstAdjacentChar = modifyWord.charAt(i);
			char secondAdjacentChar = modifyWord.charAt(i+1);
			modifyWord.setCharAt(i, secondAdjacentChar);
			modifyWord.setCharAt(i+1, firstAdjacentChar);
			//if combination exists in dictionary add it to arraylist
			if(dictionary.contains(modifyWord.toString()) && !wordSuggestions.contains(modifyWord.toString()) )
				wordSuggestions.add(modifyWord.toString());
		}
		return wordSuggestions;//return arrayList
	}
	/*
	 * helper method that combines all method suggestions into one array whereby I return JUST that array of suggestions
	 * to prevent returning 3 lines of possible suggestions
	 */
	public static HashSet<String> combineSuggestions(String input, HashSet<String> dictionary){
		ArrayList <String> allSuggestionsInOneLine = new ArrayList<>();
		
		ArrayList<String> AllAdjacentChar = AdjacentChar(input, dictionary);
		allSuggestionsInOneLine.addAll(AllAdjacentChar);
		ArrayList<String> AllOneCharMissing = OneCharMissing(input, dictionary);
		allSuggestionsInOneLine.addAll(AllOneCharMissing);
		ArrayList<String> AllOneAdditionalChar = OneAdditionalChar(input, dictionary);
		allSuggestionsInOneLine.addAll(AllOneAdditionalChar);
		HashSet <String> AllSuggestions = new HashSet<>(allSuggestionsInOneLine);
		return AllSuggestions;
		}
	
}
