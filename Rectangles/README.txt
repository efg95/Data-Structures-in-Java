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


