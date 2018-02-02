
_____________________________________________

nothing really amazing I instantiate two BufferedReader called DictionaryReader
and TextReader which takes in args[0] and args[1] respectively

created a HashSet called DictionaryTable to store all the Dictionary words that i lowercase upon adding to the hashset

i then read in the TextFile, change all the text in the file to lowercase

i then split each word by the regex white spaces and then add the words to an array
i then replace all leading and trailing punctuations with regex i learned in the API
word.replaceAll("^\\p{Punct}+|\\p{Punct}+$","")

i then check if the word is contained in the dictionary if it is not i print out
the misspelled word

i then create 4 methods to assist me in generating the suggested corrected words
the first
______________
i create a method that returns an arraylist, called OneAdditionalChar
i create a char arraylist of all the alphabets and '  i then use two for loops to insert all
possible combinations of alphabets and ' into the word length, to check whether by adding any of the 27 possibilities
if any one of the combinations is inside the dictionary i add that combination to an arraylist called wordSuggestions
and return wordSuggestions

the second
______
i create a method that returns an arraylist called oneCharMissing which uses one for loop
that deletes one character at different positions of the misspelled word and checks whether
any of the combinations can be found in the dicitonary
if it can, i add it to the arrayList and return it.

the third
_________
i create a method that returns an arraylist called AdjacentChar
which uses one for loop to swap all possible adjacent characters and test the combinations against the dictionary
if it matches add to the arraylist and return the arraylist

the fourth method
__________
I read in piazza that you guys prefer if we return all possible suggestions in one line
so the fourth method returns a hashset that calls all the 3 methods above and combines them into one HashSet<String> called
AllSuggestions that contains all the possible word suggestions from the 3 respective methods
and returns it

This is the method i print after every Misspelled word.

That ends SpellChecker.java

the filetospellcheck.txt is me drawing a story from online, and creating spelling errors in it
i cite it in the file itself

