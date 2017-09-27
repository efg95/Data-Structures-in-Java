README by ECCLESIASTES FORREST GAN SHENGGUANG
UNI:EFG2123
Files Submitted 4 (.java) files, 2 (.txt) files, 1 pdf file.
4 (.java) files
Rectangle.java -- has methods for the rectangle object, its essentially describes a rectangle object, has a compareTo object
Problem1.java -- solves findmax rectangle in array of rectangles
Problem2.java -- solves BinarySearchRecursion for a specific target in the array of sorted elements
Problem3.java -- runtimes of 3 code fragments
pdf file -- contains written assignment answers

HOW TO COMPILE **I USE MOBXTERM** to test cunix -- i compile 3 files tgt 
log on to cunix --> make sure you are in the directory where the files are located --> type "javac Problem1.java Problem2.java Rectangle.java"
technically you could compile all of them tgt, but idk what compiler you are using, so do these 3 tgt, and type "javac Problem3.java" separately.
to find the results for Problem1, type "java Problem1"
to find results for Problem2, type "java Problem2"
to find results for Problem3, type "java -Xint Problem3"
**Do not run Rectangle class as there is no main method --> its just an object class.
The results will pop up in the console.

Rectangle Class implements Comparable:
Really, simple, 2 instance variables: length and width
followed by 5 methods{getWidth, getPerimeter, getLength, toString, (overriden)compareTo}
method explanations
getWidth: returns width of the rectangle
getLength: returns length of the rectangle
getPerimeter: returns perimeter(the perimeter formula)
toString sets a preset string reply
**Most Important** compareTo method: compares rectangles by perimeter basis of Problem1 and Problem2 classes

Problem1 Class: **Find Max Rectangle**
I created an array of type rectangles and allowed a total of SIX yes SIX rectangles not FIVE, SIX, I AM BADASS!
Anyway I then used a for loop to fill the rectangle array with random widths and random lengths.
I double confirm whether this is working by printing out the array of rectangles. (thank god it works)
I then print out the largest rectangle of the array. Since I can't change the findMax method given in the HW,
if there are two of the same max perimeter's it will just return the max perimeter even though it has 2 max perimeters, 
which works fine.

Problem2 Class: **Binary Search Recursively**
Created a rectangle array with 7 rectangles, filled them up randomly again.

**CREATED A SPECIAL RECTANGLE OUTSIDE OF THE ARRAY** for testing purposes
Sorted the ARRAY
Checked whether it was sorted(phobia)

2 methods, the first one copied from the code posted on ASSIGNMENTS
the second method is a helper method, that does binary search recursively, the method works and thought process
are similar to the code Professor Blaer let us see during lecture. Credits to him i guess?

finally, I print out all the perimeters of the rectangle array, filled with random perimeters of rectangles.
I then randomize Rectangle B, and search the rectangle array with the binary recursive search for similar perimeters within the array.
if none is found -1, is returned.
if perimeter is found it returns the index of the array the perimeter similar to rectangle B is found at.
if more than one is found it matches the results with the first found in the array.

Problem 3: **Abnormally Encountered Professor Blaer said not to stress out over it** IDK!!
Created an int arr[] of tester variables {1, 1, 100, 1000, 10000}
inserted code fragments A, B, foo into code **changed them into static methods so i could test them through method calling.
So this is where it gets really funky for me, Code fragments A and B work fine, they both return on the consolve O(n) and O(n^2) results respectively.
and I followed instructions by placing System.nanoTime(); at the start of the code fragment and end of the fragment.

But for foo() fragment, when I did it, my first variables test result is SIGNIFICANTLY higher than the rest of my variables, yes it works like O(log n)
after that first SIGNIFICANT variable. Let's call it the abnormally, idk what I am doing wrong maybe its the positioning of my long start = System.nanoTime();? 
I honestly don't know, Professor Blaer said not to stress over it, I mean I got the run times right.
Oh yea i used for loops to kinda slot in my tester variables, but this works fine for fragments A and B just foo is kinda making me look like a fool. 
It could be that Java does some unnecessary constant time calculation before it calls the method, or that before it runs the "if else" it does something behind the scenes.
Possible Solution: The textbook says for an O(log N) algorithm it take Ω(N)**Omega(N)** to read the input, thus O(log N) algorithms input are assumed to be pre-read. So the constant time, is this "reading of input"
