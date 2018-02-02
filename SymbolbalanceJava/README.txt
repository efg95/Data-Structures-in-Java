____________________________________________________________________________________________________________________________
_________________________________________________________________________________________________________________________________

Programming Problem 1:

I created my own Stack interface, and implemented it in the java file called MyStack.java I have attached the interface as well as without it it would throw an error.
This is actually just for my convenience as I can always refer to my OWN edited collections of interfaces and pull them up and use them!

Interface called Stack.java (own edited stack)
______________________________
MyStack.java

I did not use LinkedList as an instance variable instead i have inner private class called private class Node, I used the textbook example, to sort of invent my own ways of pushing and popping!

for push methods i set previousHead to TopOfStack, made a new node assign the data pushed on to topOfStack, and topOfStack.next = previousHead. so e.g. the first head == null, then i push 10, null goes further to 
the right of the list [null] --> [10][null], if i push 5 --> [5][10][null]

popping i check if the stack is empty, if it is stackunderflow
if not i assign a variable top = topOfStack, move topOfStack down the list, decrement size, and return the data. So using the above list as an example [5] = top, topOfStack = [10], return 5.

size, empty and peek are kinda obvious based on my creation of what they do.

_________________________________________

SymbolBalance.java

My SymbolBalance.java has the main method embedded inside.
it uses a fileReader to read the file and a BufferedReader to read line by line of the file.
and while the BufferReader does not equal null, i will enter a for loop to count the characters of the line being read
THE MOST IMPORTANT PART IS ACCOUNTING FOR QUOTES AND COMMENTS THAT WAS THE HARD PART.
so i have two boolean variables
comment
quote
which set to false at the start.
The logic is that if i see a quote i change the boolean to true, and the bracket checker is not used. And quote will change to false if i see another quote before the end of the line. 
As quote do not go on to the next line, and unbalance of quote is found if no closing quote is found by the end of the line.
and Quote Unbalanced is returned and the system end

The Comments part is kinda the same logic except i make use of the stack. i check for current == '/' and line.charAt(i+1) == '*' comment boolean == true. 
same logic applies it ignores everything in the comment. if by the end of the comment a '*' and '/' are not seen the comments are imbalanced, even if its the other way my quote will work e.g. there is a closing comment, but
no openning comment.

the brackets are easy basically use the stack, if current == any of the 3 ')','}'.']' and the top of the stack is the respective opening bracket it is balanced otherwise IMBALANCED. it works for if the opening is imbalanced or the closing is imbalanced.

____________________________________________________

Test.java

i created a test file, but i couldn't think of any interesting ways to break my code unfortunately.

____________________________________________________

MyQueue.java is basically taken from Homework Supplementary files

____________________________________________________
TwoStackQueue.java

I implement MyQueue.java and use myStack i created (the one withe private node class)

3 instance variables 2 stacks, a variable int size (keeps track of size)

enqueue method basically pushes the data onto stackone and increments the QUEUE size

dequeue method checks that stackTwo is empty and while stackOne is not empty it pushes stackOne.pops data into Stack2 so its accomplishes the method of flipping stackOnes data
into stackTwo to fulfill the Queue LAW (FIRST IN FIRST OUT) maybe reverse is the right word not flip? but whatever.

oh yah it only dequeues or pop when Stack2 is not empty. and size is decremented upon a dequeue.

method boolean and size are obvious.

______________________________________________________________________

Program2.java this is basically the tester of the 

i used it mainly to test what happens if i dequeue an empty queue. i return null! even if stack1 is null too, i return null.

and i use it to test the time complexity of my queue implementation the answer to that can be found in Program2.txt
