/**
 * @SumaGopal
Copyright (C) Suma Gopal
This class creates singly linked lists of Polynomials.  
It creates polynomials by inserting coefficients from manually-entered inputs from class MainClass. 
Exponents are created based on the size of the Polynomial.
This class allows for the polynomials to be added and/or multiplied.
*/

public class Polynomial
{
	//Beginning of linked list.
	Node head; 
	//Size of linked list initialized to empty.
	int size = 0; 
	
	/**
	 *Default constructor initializing head node to empty and size to 0.*
	 */
	public Polynomial()
	{
		head = null;
		size = 0;
	}
	
	/**
	 * Returns the size of the polynomial linked list.
	 * @return size
	 */
	int getSize()
	{
		return size;
	}	
	
	/**
	 * Returns true if the list is empty, otherwise returns false.
	 * @return true or false
	 */
	boolean isEmpty()
	{
		return(head == null);
	}
	
	/**
	 *Inserts a new node for each coefficient to the end of the list.
	 * @param c for coefficient insertion.
	 */
	public void insertCoeff(int c)
	{
		Node newNode;
		/**If the list is empty, create a new node at the head of the list and insert the coefficient into this new node.*/
		if(isEmpty())
		{
			newNode = new Node();
			newNode.setCoeff(c);
			head = newNode;
		}
		/**If the list is not empty, create a new node, initializing it to the given coefficient, and insert this node to the end of the list.*/
		else
		{
			//Create a temporary current node starting at the head.
			Node curr = head;
			//Initialize the new node with the coefficient.
			newNode = new Node();
			newNode.setCoeff(c);
			/*Traverse through the Polynomial list until the last node is reached.*/
			while(curr.getNext() != null)
			{
				curr = curr.getNext();
			}
			/*Set the last node to be the newly inserted node with the coefficient.*/
			curr.setNext(newNode);
		}
		//Update the size of the list, for each new node added to the list.
		size++;
	}
	
	/**
	 * For the purpose of the add function: Inserts a given node at the end of a given Polynomial linked list.
	 * @param n to insert new node
	 */
	public void insertNode(Node n)
	{
		//Temporary current node starting at the head of the list.
		Node curr = head;
		
		//If the polynomial list is empty, then its head points to the given node.
		if(isEmpty())
		{
			head = n;
		}
		//If the polynomial list is not empty, then insert the node at the end of the polynomial list.
		else
		{
		//Traverse the list until the last node is reached.
			while(curr.getNext() != null)
			{
				curr = curr.getNext();
			}
			//Set the last node to be n.
			curr.setNext(n);
			n.setNext(null);
		}
		size++; //Updates the size of the Polynomial list.
	}
	
	/**
	 * Inserts exponent(s) for each coefficient into the Polynomial list, using the size of the list.
	 */
	public void insertExponent()
	{
		//Create a current node starting at the head.
		Node curr = head;
		
		//If the Polynomial list is not empty, create exponents based on the size of the list.
		if( isEmpty() == false )
		{
			//Starting from the head of the list, count from 0 down to the last node of the list which would have an exponent of the list's size minus 1.
			int i = getSize()-1;
			
			//Iterates through each node of the list, inserting its respective exponent, until the end of the list.
			while(i >= 0 && curr != null)
			{
				curr.setExp(i); //Insert the exponent on the current node of the Polynomial list.
				curr = curr.getNext(); //Iterates to the next node on the list.
				i--; //The exponent gets smaller towards the end of the list.
			}	
		}
	}
	
	/**
	 * Checks to see if the sizes of both Polynomial lists are equal.
	 * @param a to insert the first Polynomial
	 * @param b to insert the second Polynomial
	 * @return true or false if sizes of both polynomials are equal
	 */
	public static boolean sizeEqual(Polynomial a, Polynomial b)
	{
		return(a.getSize() == b.getSize());
	}
	
	/**
	 * Returns the max. sized Polynomial list.
	 * @param p1 for the first Polynomial size
	 * @param p2 for the second Polynomial size
	 * @return p1 or p2 depending on whichever Polynomial has the greatest size
	 */
	public static Polynomial getMax(Polynomial p1, Polynomial p2)
	{
		if(p1.getSize() > p2.getSize())
		{
			return p1;
		}
		else
		{
			return p2;
		}
	}
	
	/**
	 * Returns the min. sized Polynomial list.
	 * @param p1 first Polynomial
	 * @param p2 second Polynomial
	 * @return p1 or p2 - whichever Polynomial has the smallest size
	 */
	public static Polynomial getMin(Polynomial p1, Polynomial p2)
	{
		if(p1.getSize() < p2.getSize())
		{
			return p1;
		}
		else
		{
			return p2; 
		}
	}
	
	/**
	 * Adds coefficients of two polynomial lists and returns a new Polynomial list for the sum.
	 * @param p1 first Polynomial 
	 * @param p2 second Polynomial
	 * @return sum of the two Polynomials as a Polynomial linked list
	 */
	public Polynomial add(Polynomial p1, Polynomial p2)
	{
		//Inserts exponents for both polynomials p1 and p2.
		p1.insertExponent();
		p2.insertExponent();
		
		//Creates a new Polynomial list to be returned as the sum of Polynomials p1 and p2.
		Polynomial sum = new Polynomial();
		//Temporary current pointers to start at the beginning of each of the lists, p1, p2, and sum.
		Node curr1 = p1.head, curr2 = p2.head, currSum = sum.head;
		
		/*If both Polynomial lists have equal size, each node is added at the same time from Polynomial lists p1 and p2, by their respective exponents.*/
		if(sizeEqual(p1, p2) == true)
		{
			while(curr1 != null && curr2 != null)
			{	
				sum.insertNode(new Node(curr1.getCoeff() + curr2.getCoeff(), curr1.getExp()));
				curr1 = curr1.getNext();
				curr2 = curr2.getNext();
			}
		} 
		
		//If both polynomial lists don't have equal size
		else if(Polynomial.sizeEqual(p1, p2) == false)
		{
			Node maxCurr = getMax(p1, p2).head; // Get the Polynomial list with max. size.
			Node minCurr = getMin(p1, p2).head; // Get the Polynomial list with min. size.
			
			// While both Polynomial lists are not empty
			while(maxCurr != null && minCurr != null)
			{	
				/*While the max.-sized list's exponents are not lined up with
				 * the min.-sized list's exponents, create a new node each time in the Polynomial 
				 * sum, copying over the max.-sized list's coeff. and exponent.
				 */
				while(maxCurr.getExp() != minCurr.getExp())
				{
					/* Copy max-sized Polynomial coeff. and exp into the sum Polynomial*/
					sum.insertNode(new Node(maxCurr.getCoeff(), maxCurr.getExp())); 
					maxCurr = maxCurr.getNext(); // Iterate to next node on the max.-sized Polynomial.
				}
				
				/*Now both lists' exponents are lined up, where both lists' exponents are equal at each
				 * iteration. A new node is inserted each time into the sum Polynomial list, with the coefficient 
				 * being the sum of each polynomial.*/
				sum.insertNode(new Node(maxCurr.getCoeff() + minCurr.getCoeff(), minCurr.getExp()));
				maxCurr = maxCurr.getNext(); // Iterate to the next node in the max.-sized Polynomial.
				minCurr = minCurr.getNext(); // Iterate to the next node in the min.-sized Polynomial.
			}
			
		}
		// Returns the Polynomial sum.
		return sum; 
	}
	
	/**
	 * Multiplies two Polynomial lists p1 and p2. Returns their product Polynomial list.
	 * @param p1 first Polynomial
	 * @param p2 second Polynomial
	 * @return product of the two Polynomials as a linked list
	 */
	public Polynomial multiply(Polynomial p1, Polynomial p2)
	{
		//Inserts exponents for both polynomials p1 and p2.
		p1.insertExponent();
		p2.insertExponent();
		
		// Temporary Polynomial m, containing the product of p1*p2, where the nodes haven't yet been added.
		Polynomial m = new Polynomial();
		Polynomial product = new Polynomial(); // The final Polynomial list product to be returned.
		Node curr1 = p1.head, curr2;  // Temporary current pointers for lists p1 and p2.
		
		/*Multiplies p1 * p2. Stores the product into the temporary Polynomial list m.
		*Outer loop for multiplying one node at a time from list p1 to every node in list p2.*/
		while(curr1 != null) 
		{
			curr2 = p2.head; // Sets p2's current pointer at the head of p2's list.
			
			/*While p2's current node is not null, a new node is inserted for each time one single node's coeff. from p1 multiplies with each node's coeff. in p2.*/
			while(curr2 != null) 
			{
				m.insertNode(new Node(curr1.getCoeff() * curr2.getCoeff(), curr1.getExp() + curr2.getExp()));
				curr2 = curr2.getNext(); // Iterates to the next node of p2. 
			}
			curr1 = curr1.getNext(); // Iterates to the next node of p1.
		}
		
		/*Temporary nodes for Polynomial m.*/
		Node temp = m.head; // Node whose coeff. is to be added to.
		Node index = temp.getNext(); // Node used to search for nodes that have the same exp. as temp.
		
		/*Adds all like terms in m and store into product Polynomial.*/
		while(temp != null)
		{
			// If temp node has not yet been visited
			if(temp.getVisited() == false)
			{
				// Traverse the linked list until all like terms have been added to temp's coeff.
				while(index != null)
				{
					// If index node has not been visited and is a like term with temp node, then add its coeff. w/ temp's coeff.
					if(index.getVisited() == false && index.getExp() == temp.getExp())
					{
						temp.setCoeff(temp.getCoeff() + index.getCoeff()); // Add like terms.
						index.setVisited(true); // Makes sure not to traverse nodes whose coeff. have been already added to temp node's coeff.
					}
					index = index.getNext(); // Iterate to the next node to search for like terms.
				}
				/* Once all like terms of temp node have been added, this product gets inserted
				 * as a new node, where the sum is the new coeff. and it contains the same exp. as temp.
				 */
				product.insertNode(new Node(temp.getCoeff(), temp.getExp()));
			}
			temp = temp.getNext(); // Iterate to the next node.
			
			// Reset index node to the next node after temp, to begin adding like terms again with temp.
			if(temp != null) 
			{
				index = temp.getNext();
			}
		}
		//Returns the final product Polynomial list.
		return product;
	}
	
	/**
	 * Displays a Polynomial list to the output, in the format of for example: 2x^1 + 1.
	 * 
	 */
	public void printPolynomial()
	{
		Node curr = head; // Begin printing from the beginning of the Polynomial.
		// If the linked list is empty, print an error message.
		if(isEmpty()) 
		{
			System.out.println("Error: The polynomial is empty.");
		}
		insertExponent(); // Insert exponents in to the Polynomial linked list.
		
		/*While the second to last node of the Polynomial list has not been reached, 
		 * print out the coefficient and exponent from each node of the list.
		 */
		while(curr.getNext() != null)
		{
			System.out.print(curr.getCoeff() + "x^" + curr.getExp() + " + ");
			curr = curr.getNext();
		}
		/*Print out the the last node's coefficient by itself, without its x^0 exponent-
		 * as a preference for printing all the polynomials.
		 */
		System.out.print(curr.getCoeff());		
	}
	
}