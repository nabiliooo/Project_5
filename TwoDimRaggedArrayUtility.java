/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Used to calculate statistics needed, such as row totals, column totals, highest and lowest numbers, etc.
 * Due: 07/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nabil El-Hage
*/
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility{
	public static double[][] readFile (File file) throws FileNotFoundException{
		
		int rows = 0;
		Scanner s1 = new Scanner(file);
		int rowIndex = 0;
		
		while(s1.hasNextLine()){
			rows++;
			s1.nextLine();
		}
		s1.close();
		
		double array[][] = new double[rows][];
		Scanner s2 = new Scanner(file);
		
		while(s2.hasNextLine()){
			String line = s2.nextLine();
			String col[] = line.split(" ");
			array[rowIndex] = new double[col.length];
			
			for(int i = 0; i < col.length; i++)
				array[rowIndex][i] = Double.parseDouble(col[i]);
			rowIndex++;
		}
		s2.close();
		return array;
	}
	
	public static void writeToFile(double[][] array, File outputFile) throws FileNotFoundException{
		PrintWriter result = new PrintWriter(outputFile);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				sb.append(array[i][j] + " ");
			}
			sb.append("\n");
		}
		result.print(sb.toString());
		result.close();
	}
	
	
	public static double getTotal (double[][] array){
		double total = 0;
		
		for(int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				total += array[i][j];
			}
		}
		return total;
	}
	
	public static double getAverage (double[][] array) {
		int count = 0;
		
		for(int i = 0; i < array.length; i++){
			count += array[i].length;
		}
		return getTotal(array)/count; 
	}
	
	
	public static double getRowTotal(double[][]array, int row){
		double total = 0; 
		
		for(int i = 0; i < array[row].length; i++){
			total += array[row][i];
		}
		return total;
	}
	
	
	public static double getColumnTotal (double[][]array, int col){
		double total = 0; 
		
		for(int i = 0; i < array.length; i++){
			if(col < array[i].length) {
			total += array[i][col];
			}
		}
		return total;
	}
	
	
	public static double getHighestInRow (double[][] array, int row){
		double highest = array[row][0];
		
		for (int i = 0; i < array[row].length; i++){
			if(array[row][i] > highest){
				highest = array[row][i];
			}
		}
		return highest;
	}
	
	public static double getHighestInRowIndex (double[][] array, int row){
		double highest = array[row][0];
		int index = -1;
		
		for (int i = 0; i < array[row].length; i++){
			if(array[row][i] > highest){
				highest = array[row][i];
				index = i;
			}
		}
		return index;
	}
	
	public static double getLowestInRow(double[][] array, int row){
		double lowest = array[row][0];
		
		for(int i = 0; i < array[row].length; i++){
			if(array[row][i] < lowest)
				lowest = array[row][i];
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] array, int row){
		double lowest = array[row][0];
		int index = -1;
		
		for(int i = 0; i < array[row].length; i++){
			if(array[row][i] < lowest){
				lowest = array[row][i];
				index = i;
			}
		}
		return index;
	}
	
	
	public static double getHighestInColumn (double[][] array, int col){
		double highest = -1;
		
		for (int i = 0; i < array.length; i++){
			if(array[i].length > col) {
				if (array[i][col] > highest)
					highest = array[i][col];
				}
		}
		return highest;
	}
	
	
	public static int getHighestInColumnIndex(double[][] array, int col){
		double highest = -9999;
		int index = -1;
		for (int i = 0; i < array.length; i++){
			if(array[i].length > col){
			if (array[i][col] > highest){
				highest = array[i][col];
				index = i;
				}
			}
		}
		return index;
	}
	
	
	
	public static double getLowestInColumn(double[][] array, int col){
		double lowest = 9999;
		for(int i = 0; i < array.length; i++){
			if(array[i].length > col) {
				if(array[i][col] < lowest){
					lowest = array[i][col];
					}
			}
		}
		return lowest;
	}
	
	
	public static int getLowestInColumnIndex(double[][] array, int col) {
	    double lowest = 9999;
	    int index = -1;
	    
	    for (int i = 0;i < array.length;i++) {
	      if (array[i].length > col) {
	    	  if (array[i][col] < lowest) {
	    		  lowest = array[i][col];
	    		  index = i;
	    		  }
	    	  }
	    }
	    return index;
	  }
	
	
	public static double getHighestInArray(double[][] array){
		double highest = array[0][0];
		
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				if(array[i][j] > highest) {
					highest = array[i][j];
				}
			}
		}
		return highest;
	}
	

	public static double getLowestInArray (double[][] array){
		double lowest = array[0][0];
		
		for(int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				if(array[i][j] < lowest){
					lowest = array[i][j];
				}
			}
		}
		return lowest;
	}
	

}