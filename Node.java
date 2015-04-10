/**
 * @SumaGopal
Copyright (C) Suma Gopal
This Node class contains the following:
-Next node pointer for creation of a singly linked list of Polynomials.
-Polynomial data printed to the user: coefficient and exponent.
-A "visited" boolean variable to indicate which node has been visited when multiplying polynomials.
*/

public class Node
{
	private Node next; // Pointer to the next node.
	private int coeff; // Coefficient in front of the x, e.g.: 2x, 2 is the coeff.
	private int exp; // Exponent of the x, e.g.: 2x^3, 3 is the exp.
	private boolean visited; // Lets the "multiply" function in Polynomial class know if a node has been visited or not, for when adding like terms.
	
	/**Default constructor initializing an empty node.*/
	public Node()
	{
		next = null;
		coeff = exp = 0;
		visited = false;
	}
	/**Constructor initializing the coefficient.*/
	public Node(int c)
	{
		next = null;
		coeff = c;
		exp = 0;
		visited = false;
	}
	/**Constructor initializing coefficient and exponent.*/
	public Node(int c, int e)
	{
		next = null;
		coeff = c;
		exp = e;
		visited = false;
	}
	
	/**Returns the next pointer to the node.*/
	public Node getNext()
	{
		return next;
	}
	/**Sets equal to a given next node pointer n.*/
	public void setNext(Node n)
	{
		next = n;
	}
	
	/**Returns the coefficient.*/
	public int getCoeff()
	{
		return coeff;
	}
	/**Sets the coefficient equal to a given coefficient */
	public void setCoeff(int c)
	{
		coeff = c;
	}
	
	/**Returns the exponent.*/
	public int getExp()
	{
		return exp;
	}
	/**Sets the exponent equal to a given exponent.*/
	public void setExp(int e)
	{
		exp = e;
	}
	/**Sets the visited variable to a given true/false value*/
	public void setVisited(boolean v)
	{
		visited = v;
	}
	/**Returns if a visit ed node is true or false.*/
	public boolean getVisited()
	{
		return visited;
	}
}