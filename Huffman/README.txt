files to compile for Huffman: Huffman.java 
Compile: javac Huffman.java
Run: java Huffman huffmantestfile.txt

Huffman.java
------------------------------
created a BufferedReader that takes in the file to build a huffman tree from
i go through the entire text character by character and add the frequency of the character to
the HashMap

I then instantiate a new tree
with private huffman nodes that form the basis of the tree
i override the compareTo method with something simpler
and add a toString method for me to error check <--- not important

I then create a method called buildTree which takes in the HashMap created as a parameter
in the method i create a priority queue to act as the binaryHeap

I then create the root of the huffman tree
and while q.size > 1 i use the algorithm explained in class to essentially
build out my tree
poll leftChild, poll  rightChild, add it to the node and add the node to the queue

i create a small method called isLeaf that returns boolean on whether the node is a leaf

I create a method to print a table of charactes and respective hashcodes, i do not print their frequencies
it contains 3 methods to print the table, first a public method that returns a hashMap, called getCode
that calls the helper method buildTable

a method called buildtable which takes in the hashMap, the HuffmanNode and a string of huffcode
it checks whether the node is a leaf, if it is, it places the node's character and respective huffcode into a new HashMap
if it is not a leaf i recursively call the leftChild and then the rightChild

finally the method printTable uses some regex to print out the characters and respective Huffcode

DECODE
____________
i only allow the user to enter 1s or 0s, if they don't it will keep repeatingly ask the user for input
i then check that the root is not null.
i then use a for loop to go through the encoded message if its a 0 i go to the left, and if the left is a leaf
i concatenate it to a string called output,
if its a 1 i do something similar
finally to check that the user has entered something i can decode and there are no extra 1s and 0s, i encode the output, and check
whether it equals the userEncodedMessage if it does i return it, if it does not i exit

ENCODE
__________
i allow everything except null input, i then use a StringBuilder for practice.
one for loop goes through the UserUncoded message, and checks whether the character is the in HashMap if it is
i get it's respective huffcode, if the character does not exist in the Hashmap i return an error

huffmantestfile.txt
___________________
file drawn from text stories online, cited it in the file, it works perfectly i think!
