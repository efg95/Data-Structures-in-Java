things to note for this problem, i am attaching my own Stack interface and MyStack, from my last program, because MyStack class implements my own Stack interface i created.
I am sorry if that is irritating, but i like to keep stuff like that in my projects helps me remember how certain DataStructures work w/o googling

Programming Problem 1
ExpressionTree.java
created an inner node class which acts as my tree, and is essential to running the tree.

i create my stack object
so after taking in the string of postfix expressions,
i use a scanner to grab the next tokens/values from the expression, i check if the token/values are equal to a digit
if it is i create a node and push the node with the element digit onto the stack (heavily relying on there being no cases like 4* and 4+ but they should have spaces like 4 * and 4 +)

if i encounter a an operator like +,-,*, /, i create a node and pop the stack and assign the first pop to be the right child of the operator node, and pop the second time and assign the second pop to be the left child.
during this time if right or left child is == null something is wrong with the postfix expression, and i print an error message and end the program.

i then push the new tree onto the stack again (with the childs attached)
*if i do not encounter a digit or operator i print an error message and end the program too.

i then pop the stack and because the pop should be the top of the stack i make it the rootNode. (if the stack is not empty after this pop i print an error and end program)

public int eval()
has a private helper method that checks whether the root node is a digit if it is, it returns that node, because the tree only has one value.

else if it is any of the operators i do leftchild + rightchild, leftchild * rightchild, leftchild - rightchild, leftchild/rightchild

for postfix()
i create a stringbuilder based on advice from a TA, i then take in the rootNode as the base case and send it to the helper method
the private helper method checks if the current node == null, if it is i return nothing
else, i recursively call the currentnodes leftchild
and then i recursively call the rightchild,
after each recursive call to the left child it gets appended to a stringbuilder
same for the rightchild
after that is done the parentnode is appended.
some stuff about stringbuilder was googled info was taken from api
for infix()
similar to postfix except the way i arrange the recursive calls are different, i append a "(" first,
then i recursively call the left child, which appends the left child to the string
then i append the parent of the child
then i recursively call the right child, and append it
finally i append a parentheses ")"
This creates a messy bunch of parentheses, but i wrote them down they evaluate correctly
for prefix()
similar to postfix except this time the parent gets appended first followed by the left and right child
AND THATS IT!
Problem1.java

so i create an ExpressionTree object here, hardcode in different types of postfix expressions and send assign it to the ExpressionTree object,
i then print out the various results for eval, postfix, infix, and prefix (thing to note my infix has a lot of parenthesis, but i wrote them out on paper, besides being slightly confusing they are correct)
I DID NOT IMPLEMENT handle for DIVIDE BY ZERO EXCEPTION, because i remember professor Blaer saying something in class that it is fine not to? i think, i could be wrong. If i am wrong just take marks off its fine.
