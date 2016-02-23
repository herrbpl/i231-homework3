## Abstract Data Types

Implement an abstract data type "Stack of double numbers" (LIFO) using linkedlists. String representation of a stack (provided by toString method) must be ordered from bottom to top (tos is the last element). 
List of compulsory operations: 
* Constructor for a new stack: _DoubleStack()_
* Copy of the stack: _Object clone()_ 
* Check whether the stack is empty: _boolean stEmpty()_
* Adding an element to the stack: _void push (double a)_ 
* Removing an element from the stack: _double pop()_
* Arithmetic operation s ( + - * / ) between two topmost elements of the stack (result is left on top): _void op (String s)_ 
* Reading the top without removing it: _double tos()_ 
* Check whether two stacks are equal: _boolean equals (Object o)_ 
* Conversion of the stack to string (top last): _String toString()_ 

Write a method
 
_public static double interpret (String pol)_ 

to calculate the value of an arithmetic expression pol in RPN (Reverse Polish Notation) using this stack type. Expression is a string which contains double numbers (including negative and multi-digit numbers) and arithmetic operations + - * / separated by whitespace symbols. The result must be double value of the expression or throwing a RuntimeException in case the expression is not correct. Expression is not correct if it contains illegal symbols, leaves redundant elements on top of stack or causes stack underflow.
 
Example. _DoubleStack.interpret ("2. 15. -")_ should return -13. . 

Upload results to Moodle in time.
