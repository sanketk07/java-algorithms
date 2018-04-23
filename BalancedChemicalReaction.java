/**
 * 
 */
package com.leetcode.easy.testing;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

/**
 * @author sanketkumar
 * 
 * For a chemical reaction represented by a string, verify that the chemical reaction is a balanced reaction 
 * (i.e. that we didn't somehow lose or gain an atom during reaction). If the reaction is balanced return true, 
 * otherwise return false.

   For example, for the hydrogen combustion reaction:

    '2 H2 + O2 -> 2 H2O'

   would output true because the number of atoms in the reactants match up with the number of atoms in the product. However, for the precipitation of silver-chloride:

    'NaCl + AgNO3 -> NaNO3 + Ag'

	the output should be false because we're missing the chlorine atom in the products.

	The reactancts and products will always be separated by a right pointing arrow "->" and the individual molecules within the
	reactants/products are always separated by a "+" sign. Multiple molecules are represented by a number and space prefacing the
	molecule (e.g., "2 H20").
 */

public class BalancedChemicalReaction {
	
	Map<String, Integer> LHSMap = new HashMap<String, Integer>();
	Map<String, Integer> RHSMap = new HashMap<String, Integer>();

	public int returnElementCount() {
		
		return 0;
	}
	
	public void parseElementLHS(String LHS) {
		System.out.println(LHS);
		String LHSElements[] = LHS.split("\\+");
		
		System.out.println("Test :"+extractNumber(LHSElements[0]));
		 
		for(int i=0; i<LHSElements.length; i++) {
			LHSMap.put(LHSElements[i], extractNumber(LHSElements[i]));
		}
		
		
		
		
		
	}
	
	public void parseElementRHS(String s) {
		
	}
	
	public boolean compareElementCount() {
		
		boolean countMatches = false;
		
		
		return countMatches;
	}
	
	public int extractNumber(String str) {                
		int count = 1;
	    if(str == null || str.isEmpty()) return 0;

	    StringBuilder sb = new StringBuilder();
	    
	    for(char c : str.toCharArray()){
	        if(Character.isDigit(c)){
	        count *= c;
	        	return count;
	            
	        }
	    }

	   // count 
	    
	    //return sb.toString();
	    return count;
	}
	
	public static void main(String args[]) {
		String equation = "2 H2 + O2 -> 2 H2O";
		
		String[] parts = equation.split("\\->"); // String array, each element is text between dots

		String LHS = parts[0];
		String RHS = parts[1];
		
		System.out.println("Equation is: "+ LHS + "->"+RHS);
		
		BalancedChemicalReaction b = new BalancedChemicalReaction();
		b.parseElementLHS(LHS);
		
	}
}
