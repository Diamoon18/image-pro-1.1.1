# image-pro-1.1.1
Update image pro 1.1.0\
```10 new filters```\
New features in "Other":
1. Sharpen filters (6 filters)
2. Min and max filters
3. Mediana filtr
## Screenshots 
![image](https://user-images.githubusercontent.com/72127610/117660640-b3d51480-b19d-11eb-8861-85c40c9c3c75.png)
![image](https://user-images.githubusercontent.com/72127610/117660668-b9caf580-b19d-11eb-8c0d-e68aae4255ff.png)
## Code explanation
### New code in Model
Board class - new buttons have been added for the ```Other```.
```java
...
if(e.equals(oth.otherButtons[3])) {
				e.color1 = color_change;
				if (otherView.click_o) {
					if(!otherModel.picturePathIsEmpty()) {
						questionFormSharp.filtrSharp();// sharp wybor z 4
					}
					otherView.click_o = false;
				}
			}
			if(e.equals(oth.otherButtons[4])) {
				e.color1 = color_change;
				if (otherView.click_o) {
					if(!otherModel.picturePathIsEmpty()) {
						otherModel.maxFiltr();
					}
					otherView.click_o = false;
				}
			}
			if(e.equals(oth.otherButtons[5])) {
				e.color1 = color_change;
				if (otherView.click_o) {
					if(!otherModel.picturePathIsEmpty()) {
						otherModel.medianaFiltr();
					}
					otherView.click_o = false;
				}
			}
			if(e.equals(oth.otherButtons[6])) {
				e.color1 = color_change;
				if (otherView.click_o) {
					if(!otherModel.picturePathIsEmpty()) {
						otherModel.minFiltr();
					}
					otherView.click_o = false;
				}
			}
    ...
```
New class ```questionFormSharp``` - this class is for sharpening filters (selection list)\
```filtrSharp()``` - this method with a window to choose one of the 6 filters in array ```choices```\
Main logic is in ```otherModel.sharpen(double[][] maska, String filtr)```
```java
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
       ...
```
Then, depending on the user's choice, we use the method ```maskInit(String choose)``` to fill the mask with values.\
```java
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
          ....
```
class otherModel have new metod ```sharpen(double[][] maska, String filtr)``` - the main logic of sharpening filters.\
As in the Box filter we use the same algorithm, but with the difference that we have to give the absolute value here, because we have negative values in the mask.
```java
...
             x = Math.abs(x);
						 y = Math.abs(y);
						 z = Math.abs(z);
...
```
Also stores RGB values in two-dimensional arrays.
```java
         int[][] R = new int[width][height];
				 int[][] G = new int[width][height];
				 int[][] B = new int[width][height];
         ...
```
Depending on the filter value, name the image accordingly.
```java
switch(filtr){
				 	case "robH":
			 			 output = new File(picturePath.replace(".jpg", "_robertsH_filtr.jpg"));
						 ImageIO.write(image, "jpg", output);
						 break;
			 		case "preH":
			 			 output = new File(picturePath.replace(".jpg", "_prewitH_filtr.jpg"));
						 ImageIO.write(image, "jpg", output);
						 break;
```
