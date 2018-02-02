Programming Problem 2
Run: java Problem2 frank.txt

Problem2.java
Set up error checking, if there is no file, I end the system.

I then create an AvlTree object named tree i use a scanner to scan in the file taken in using the command line argument.
i create a lineNumber that's job is to increment everytime i go down the file line by line.

i set up a while loop that while inFile.hasNextLine() will keep going.
increment the lineNumber everytime a new line is started

inner while loop that checks for hasNext in the line using a scanner.

MOST IMPORTANT PART, i assign the has next to a string word and then i make that word into lowercase and replace all punctuations with empty strings ("")
*I think i learned that to do this it's just "\\W" in 1004 java, but i forgot that i could do that so i googled i cited the stackoverflow webpage that
gave me the way to remove punctuations inside a string

i then call tree.indexWord which indexes the word scanned in with a line number

i then call printIndex(); which prints all the words in the file and with each word is a linkedlist attached which shows the line where each word is found at.

i also check whether my getLinesForWord(String word) method is working with a little check with the string "you" it works fine, it returns the line numbers where the word is found.
if it is not found in the text file at all it returns null.
____________________________________________________________________

AvlTree.java
indexWord() & LocateWords()
at first i started indexWord without any helper methods i found myself getting lost in code while doing compareTos

so i created a helper method to help me find whether word exists in the AvlTree.

the helper method is called LocateWords(String word, AvlNode nodeY)
it takes in the String word scanned in from the file, and compares the word to the root at the beginning
if the tree is completely no matches would be found and null will be returned.
this result will then be assigned to an AvlNode node i created in indexWord

thus in indexWord method if the tree is empty, node will == null, and it will hit the if statement where it inserts the node into the tree.
i then call the helper method again to retrieve the word from the tree and assign to the node its respective line number the word was found at.

however, if for example the tree is not empty, the node will then call the helper method LocateWords, which will then check whether the word exists in the tree
if it does exists in the tree i jump straight to appending the line number to the node, i retrieve the node again with the helper method, and then i append the line number to the node
HOWEVER, we do not want repeat words on the same line to show on the linked list, so i created a small if statement to check whether the linked list contains the line number if it does
i do nothing, I DO NOT append the line number to the node.
IF it doesn't repeat on the same line, i append it to the node.

public List getLinesForWord(String word)

pretty simple i take in the word, use the helper method LocateWords() to check whether it exists in the tree, if it doesn't i return null.
if it does i return the linkedlist of lineNumbers of where the word is found attached to the node.

public void printIndex()
how this method works is basically a bunch of recursive calls, first i have a private method which does all the work

public void printIndex() just calls the private method on printIndex(root);
that kicks the private printIndex()

which checks whether root is null if it is i return nothing

if it is not i print the node element and the node's attach linked list line numbers
and then i recursively call the node's left and right child, which will keep going until the tree is all printed out.

that is basically it
