package collectionapi;
/**
 * = stacks and queus =
 * 
 * - In this section, we describe 2 containers: the stack and queue.
 * - In principle, both have very simple interfaces.(but not in the Collection API)
 *   and very efficient implementations.
 *   
 *   
 *   = stacks =
 *   
 *   - A stack is a data structure in which access is restricted to the most recently inserted item.
 *   - It behaves very much like the common stack of bills, stack of plates, or stack of newspapers.
 *   - The last item added to the stack is placed on the top and is easily accessible,
 *     whereas items that have been in the stack for a while
 *     are more difficult to access.
 *     -> Thus the stack is appropriate if we except to access only the top item;
 *        all other items are inaccessible.
 *        
 *    - In a stack, the 3 natural operations of insert, remove, and find are renamed push, pop, and top.
 *      input    -> push
 *      output   -> top
 *      deletion -> pop 
 *      
 *    - The interface shown below illustrates the typical protocal.
 *    - It is similar to the protocol of collection interface.
 *    - By pushing items and then popping them, we can use the stack to reverse the order of things.
 *    
 *    - Each stack operation should take a constant amount of time,
 *      independent of the number of items in the stack.
 *    - By analogy, finding today's newspaper in a stack of newspapers is fast,
 *      no matter how deep the stack is.
 *    - However, arbitrary access in a stack is nor efficiently supported,
 *      so we do not list it as an option in the protocol.
 *      
 *       
 *    - What makes the stack useful are the many application for which 
 *      we need to access only the most recently inserted item.   
 *    - An important use of stacks is in compiler design.
 *    
 *  = stacks and computer language =
 *  
 *  Stack application:
 *  
 *  1. Compilers
 *  
 *  - Compilers check your programs for syntax error.
 *  - Often, however, a lack of one symbol(e.g., a missing comment-ender }, )
 *    causes the compiler to spill out a hundred lines of diagnostics without identifying the real error;
 *    this is especially true when using anonymous classes.
 *    
 *     algorithm:
 *       1. make an empty stack.
 *       2. Read symbols until the end of the file.
 *          a. If the token is an opening symbol, push it onto the stack.
 *          b. If it is a closing symbol and if the stack is empty, report an error.
 *          c. Otherwise, pop the stack.
 *             If the symbol popped is not the corresponding opening symbol, report an error.
 *       3. At the end of the file, if the stack is not empty, report an error.
 *     
 *   - We will develop this algorithm to work for(almost) all Java programs.
 *   - Details include error reporting, and processing of comments, strings, and character constants,
 *     as well as escape sequences.
 *     
 *   2. method calls  
 *   
 *   - The algorithm to check balanced symbols suggests a way to implement methods calls.
 *   - The problem is that, when a call is made to a new method,
 *     all the variables local to the calling method need to be saved by the system;
 *     otherwise, the new method would overwrite the calling routine's variables.
 *   - Furthermore, the current location in the calling routine must be saved so that
 *     the new method knows where to go after it is done.
 *   
 *   -> The reason that this problem is similar to balancing symbols is because
 *      a method call and a method return are essentially the same as as
 *      open parenthesis and a closed parenthesis,
 *      so the same ideas should apply.
 *   - The stack is used to implement method calls in most progtamming languages.
 *   
 *   
 *   3. evaluation of expressions
 *   
 *   - A final import application of the stack is the evaluation of expressions in computer languages.
 *   - In the expression 1+2*3, we see that at the point that the * is encountered,
 *     we have already read the operator + and the operands 1 and 2.
 *   - Does * operate on 2, or 1+2?
 *   - Precedence rules tell us that * operates on 2, which is the most recently seen operand.          
 *   - After the 3 is seen, we can evaluate 2*3 as 6 and then apply the + operator.
 *   - This process suggests that operands and intermediate results should be saved on a stack.
 *     (since the + is held until the higher precedence * is evaluated).
 *   - An algorithm that uses this strategy is operator precedence parsing.           
 *  
 *
 */
// Stack protocol
public interface Stack<AnyType> {
	
	void push(AnyType x); // insert
	void pop(); // remove
	AnyType top(); // find
	AnyType topAndPop(); // find + remove
	
	boolean isEmpty();
	void makeEmpty();
	

}
