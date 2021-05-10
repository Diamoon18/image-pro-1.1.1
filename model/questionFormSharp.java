package model;

import javax.swing.JOptionPane;

public class questionFormSharp {
	    private static String filtr;
	
		public static void filtrSharp() {
			 String[] choices = { "Robertsa horizontal", "Prewitta horizontal", "Sobela horizontal",
					"Robertsa vertical", "Prewitta vertical", "Sobela vertical", "Laplace’a" };
			 String input = " ";
			 input = (String) JOptionPane.showInputDialog(null, "Choose mode",
	            "Sharpen filtr", JOptionPane.QUESTION_MESSAGE, null,
	            choices, 
	            choices[0]);
			 
			 if(input == null) {
				 input = choices[0];
			 }
			 
			 // horizontal
			 if (input.equals(choices[0])) {
				 filtr = "robH";
			     otherModel.sharpen(maskInit(filtr), filtr);
			 }
			 if (input.equals(choices[1])) {
				 filtr = "preH";
				 otherModel.sharpen(maskInit(filtr), filtr);
			 }
			 if (input.equals(choices[2])) {
				 filtr = "sobH";
				 otherModel.sharpen(maskInit(filtr), filtr);
			 }
			 // vertical
			 if (input.equals(choices[3])) {
				 filtr = "robV";
				 otherModel.sharpen(maskInit(filtr), filtr);
			 }
			 if (input.equals(choices[4])) {
				 filtr = "preV";
				 otherModel.sharpen(maskInit(filtr), filtr);
			 }
			 if (input.equals(choices[5])) {
				 filtr = "sobV";
				 otherModel.sharpen(maskInit(filtr), filtr);
			 }
			 if (input.equals(choices[6])) {
				 filtr = "lap";
				 otherModel.sharpen(maskInit(filtr), filtr);
			 }
		}
		
	 private static double[][] maskInit(String choose) {
		 double [][] mask = new double[3][3];
		 switch(choose){
		 		case "robV":
		 			mask[0][0] = 0;
		 			mask[0][1] = 0;
		 			mask[0][2] = 0;
		 			
		 			mask[1][0] = 0;
		 			mask[1][1] = 1;
		 			mask[1][2] = -1;
		 			
		 			mask[2][0] = 0;
		 			mask[2][1] = 0;
		 			mask[2][2] = 0;
		 			break;
		 		case "preV":
		 			mask[0][0] = 1;
		 			mask[0][1] = 1;
		 			mask[0][2] = 1;
		 			
		 			mask[1][0] = 0;
		 			mask[1][1] = 0;
		 			mask[1][2] = 0;
		 			
		 			mask[2][0] = -1;
		 			mask[2][1] = -1;
		 			mask[2][2] = -1;
		 			break;
		 		case "sobV":
		 			mask[0][0] = 1;
		 			mask[0][1] = 2;
		 			mask[0][2] = 1;
		 			
		 			mask[1][0] = 0;
		 			mask[1][1] = 0;
		 			mask[1][2] = 0;
		 			
		 			mask[2][0] = -1;
		 			mask[2][1] = -2;
		 			mask[2][2] = -1;
		 			break;
		 		case "robH":
		 			mask[0][0] = 0;
		 			mask[0][1] = 0;
		 			mask[0][2] = 0;
		 			
		 			mask[1][0] = 0;
		 			mask[1][1] = 1;
		 			mask[1][2] = 0;
		 			
		 			mask[2][0] = 0;
		 			mask[2][1] = -1;
		 			mask[2][2] = 0;
		 			break;
		 		case "preH":
		 			mask[0][0] = 1;
		 			mask[0][1] = 0;
		 			mask[0][2] = -1;
		 			
		 			mask[1][0] = 1;
		 			mask[1][1] = 0;
		 			mask[1][2] = -1;
		 			
		 			mask[2][0] = 1;
		 			mask[2][1] = 0;
		 			mask[2][2] = -1;
		 			break;
		 		case "sobH":
		 			mask[0][0] = 1;
		 			mask[0][1] = 0;
		 			mask[0][2] = -1;
		 			
		 			mask[1][0] = 2;
		 			mask[1][1] = 0;
		 			mask[1][2] = -2;
		 			
		 			mask[2][0] = 1;
		 			mask[2][1] = 0;
		 			mask[2][2] = -1;
		 			break;
		 		case "lap":
		 			mask[0][0] = -1;
		 			mask[0][1] = -1;
		 			mask[0][2] = -1;
		 			
		 			mask[1][0] = -1;
		 			mask[1][1] = 8;
		 			mask[1][2] = -1;
		 			
		 			mask[2][0] = -1;
		 			mask[2][1] = -1;
		 			mask[2][2] = -1;
		 			break;
		 }
		 return mask;
	 }
}
