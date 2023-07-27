package ChallengeConversor;
import javax.swing.JOptionPane;

public class ConversorDistancia {
	public static void distanceConverter(String[] args) {

		double distance = 0;
		String[] options = {"Centímetros", "Metros", "Kilómetros"};
		
		boolean validInput = false; 
		while (!validInput) {
			String inputDistance = JOptionPane.showInputDialog(null, "Ingrese el valor de la distancia que desea convertir", "Conversor de Distancia", JOptionPane.PLAIN_MESSAGE);
			if (inputDistance == null) {
				return;
		} try {
       	 distance = Double.parseDouble(inputDistance);
       	 validInput = true;
        } catch (NumberFormatException e) {
       	 JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
		
		int choiceFrom = JOptionPane.showOptionDialog(null, "Seleccione la distancia de origen:", "Conversor de Distancia", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    int choiceTo = JOptionPane.showOptionDialog(null, "Seleccione la distancia a la que desea convertir:", "Conversor de Distancia", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		
	    double cmToM = distance / 100;
		double cmToKm = distance / 100000;
		double mToCm = distance * 100;
		double mToKm = distance / 1000;
		double kmToCm = distance * 100000;
		double kmToM = distance * 1000; 
		
		double result = 0.0;
		String fromDistance = "";
	     String toDistance = "";

	     switch (choiceFrom) {
	         case 0:
	        	 fromDistance = "Centímetros";
	        	 if (choiceTo == 1) {
	        		 result = cmToM;	        		
	        	 } else if (choiceTo == 2) {
	        		 result = cmToKm;
	        	 } break;
	         case 1:
	        	 fromDistance = "Metros";
	        	 if (choiceTo == 0) {
	        		 result = mToCm;	        		
	        	 } else if (choiceTo == 2) {
	        		 result = mToKm;
	        	 } break;
	         case 2:
	        	 fromDistance = "Kilómetros";
	        	 if (choiceTo == 0) {
	        		 result = kmToCm;	        		
	        	 } else if (choiceTo == 2) {
	        		 result = kmToM;
	        	 } break;
	        	 
	         default:
	             JOptionPane.showMessageDialog(null, "Distancia de origen no válida", "Error", JOptionPane.ERROR_MESSAGE);
	             System.exit(0); 
	}
	
	     switch (choiceTo) {
	     	case 0:
	     		toDistance = "Centímetros";
	     		if (choiceFrom == 1) {
	     			result = mToCm;
	      		} else if (choiceFrom == 2) {
	      			result = kmToCm;
	      		} break;
	     	case 1: 
	     		toDistance = "Metros";
	     		if (choiceFrom == 0) {
	     			result = cmToM;
	     		} else if (choiceFrom == 2) {
	     			result = kmToM;
	     		} break;
	     	case 2:
	     		toDistance = "Kilómetros";
	     		if (choiceFrom == 0) {
	     			result = cmToKm;
	     		} else if (choiceFrom == 1) {
	     			result = mToKm;
	     		} break; 
	     	
	     }
	     String message = String.format("%.2f %s equivale(n) a %.3f %s", distance, fromDistance, result, toDistance);
	     JOptionPane.showMessageDialog(null, message, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	     
	     int response = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Conversor de Distancia", JOptionPane.YES_NO_OPTION);
	     boolean shouldExit = (response == JOptionPane.NO_OPTION);
	}

	}
}

