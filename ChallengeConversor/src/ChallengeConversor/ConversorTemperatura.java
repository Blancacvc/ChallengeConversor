package ChallengeConversor;
import javax.swing.JOptionPane;

public class ConversorTemperatura {
	public static void tempConverter(String[] args) {
		
		double value = 0;
		String[] options = {"Grados Celsius", "Grados Fahrenheit", "Kelvin"};
		
		boolean validInput = false;
		while (!validInput) {
	String inputValue = JOptionPane.showInputDialog(null, "Ingrese el valor de la temperatura que desea convertir", "Conversor de Temperatura", JOptionPane.PLAIN_MESSAGE);
		if (inputValue == null) {
			return;
		}
         try {
        	 value = Double.parseDouble(inputValue);
        	 validInput = true;
         } catch (NumberFormatException e) {
        	 JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
         }
		}
        
     int choiceFrom = JOptionPane.showOptionDialog(null, "Seleccione la temperatura de origen:", "Conversor de Temperatura", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
     int choiceTo = JOptionPane.showOptionDialog(null, "Seleccione la temperatura a la que desea convertir:", "Conversor de Temperatura", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
     
     	double celsiusToFahr = (value * 9/5) + 32;
		double celsiusToKelv = (value + 273.15);
		double fahrToCelsius = (value - 32) * 5/9;
		double fahrToKelv = (value - 32) * 5/9 + 273.15;
		double kelvToCelsius = (value - 273.15);
		double kelvToFahr = (value - 273.15) * 1.8 + 32;
         
	double result = 0.0;
	String fromTemp = "";
     String toTemp = "";

     switch (choiceFrom) {
         case 0:
             fromTemp = "Grados Celsius";
             if (choiceTo == 1){
            	 result = celsiusToFahr;
             } else if (choiceTo == 2) {
             result = celsiusToKelv;
             }
             break;
         case 1:
             fromTemp = "Grados Fahrenheit";
             if (choiceTo == 0){
             result = fahrToCelsius;
             } else if (choiceTo == 2) {
            	 result = fahrToKelv; 
             }
             break;
         case 2:
             fromTemp = "Kelvin";
             if (choiceTo == 0){
             result = kelvToCelsius;
             } else if (choiceTo == 1) {
             result = kelvToFahr;
             }
             break;
         default:
             JOptionPane.showMessageDialog(null, "Temperatura de origen no válida", "Error", JOptionPane.ERROR_MESSAGE);
             System.exit(0);
     }

     switch (choiceTo) {
         case 0:
             toTemp = "Grados Celsius";
             if (choiceFrom == 1){
             result = fahrToCelsius;
             } else if (choiceFrom == 2) {
              result = kelvToCelsius;
             }
             break;
         case 1:
             toTemp = "Grados Fahrenheit";
             if (choiceFrom == 0){
            	 result = celsiusToFahr;
             } else if (choiceFrom == 2) {
             result = kelvToFahr;
             }            
             break;
         case 2:
             toTemp = "Kelvin";
             if (choiceFrom == 0){
             result = celsiusToKelv;
             } else if (choiceFrom == 1) {
             result = fahrToKelv;
             }
             break;
       
         default:
             JOptionPane.showMessageDialog(null, "Temperatura de destino no válida", "Error", JOptionPane.ERROR_MESSAGE);
             System.exit(0);
     }

     String message = String.format("%.2f %s equivale(n) a %.2f %s", value, fromTemp, result, toTemp);
     JOptionPane.showMessageDialog(null, message, "Resultado", JOptionPane.INFORMATION_MESSAGE);
     
     int response = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Conversor de Divisas", JOptionPane.YES_NO_OPTION);
     boolean shouldExit = (response == JOptionPane.NO_OPTION);
     
	}


	
}
