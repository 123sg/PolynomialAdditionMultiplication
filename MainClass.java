/**
 * @author SumaGopal
Copyright (C) Suma Gopal
*/
public class MainClass
{
	public static void main(String [] args )
	{
		// Two polynomials to be added or multiplied.
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		 // Polynomial sum.
		Polynomial p3 = new Polynomial();
		// Polynomial product.
		Polynomial p4 = new Polynomial(); 
		
		int [] arrayP1 = {1, 2, 8};  // Holds coefficients for p1.
		int [] arrayP2 = {3, 4, 5, 6}; // Holds coefficients for p2.
		
		// Inserts coefficients from arrayP1 into p1.
		for(int i = 0; i < arrayP1.length; i++)
		{
			p1.insertCoeff(arrayP1[i]);
		}
		
		// Inserts coefficients from arrayP2 into p2.
		for(int j = 0; j < arrayP2.length; j++)
		{
			p2.insertCoeff(arrayP2[j]);
		}
		
		// Outputs the two polynomials that will be added or multiplied.
		System.out.println();
		System.out.print("Polynomial 1: ");
		p1.printPolynomial();
		System.out.println();
		System.out.print("Polynomial 2: ");
		p2.printPolynomial();
		
		// Outputs the sum polynomial of p1 and p2.
		System.out.println('\n');
		System.out.print("Sum: ");
		p3 = p3.add(p1, p2);
		p3.printPolynomial();
		System.out.println();
		System.out.println();
		
		// Outputs the product polynomial of p1 and p2.
		System.out.print("Product: ");
		p4 = p4.multiply(p1, p2);
		p4.printPolynomial();
		System.out.println();
	}
}