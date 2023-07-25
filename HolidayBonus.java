/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Used to decide and calculate the total holiday bonus. Either adding the highest, lowest, or other bonus.
 * Due: 07/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nabil El-Hage
*/
public class HolidayBonus {
	private final static int HIGHESTBONUS = 5000;
	private final static int LOWESTBONUS = 1000;
	private final static int OTHERBONUS = 2000;
	
	public static double[] calculateHolidayBonus(double[][] array){
		double[] bonus = new double[array.length];
		int col = 0;
		
		for(int i = 0; i < array.length; i++){
			if(col < array[i].length)
				col = array[i].length;
		}
		
		for(int i = 0; i < col; i++){
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(array, i);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(array, i);
			double highest = TwoDimRaggedArrayUtility.getHighestInColumn(array, i);
			double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(array, i);
			
			if(highest > 0) {
				bonus[highIndex] += HIGHESTBONUS;
			}
			
			if(lowest > 0 && highIndex!=lowIndex) {
				bonus[lowIndex] += LOWESTBONUS;
			}
		
			for(int j = 0; j < array.length; j++){
				if(j >= array[i].length || i == highIndex || i == lowIndex || array[i][j] < 1)
					continue;
				bonus[i] += OTHERBONUS;
			}
		}
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] array){
		double total = 0;
		
		double bonus[] = HolidayBonus.calculateHolidayBonus(array);
		
		for(int i = 0; i < bonus.length; i++){
			total += bonus[i];
		}
		return total;
	}
}