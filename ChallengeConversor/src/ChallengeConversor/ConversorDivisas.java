package ChallengeConversor;
import javax.swing.JOptionPane;

public class ConversorDivisas {
		
	public static void currencyConverter(String[] args) {
		
		//(response == JOptionPane.NO_OPTION);
    	//la moneda nacional de Panama es el Balboa la cual tiene una tasa de cambio fija de B/.1.00 = USD$1.00
	
	double balboaToUSD = 1.0;
    double balboaToEUR = 0.90;
    double balboaToGBP = 0.78;
    double balboaToJPY = 141.38;
    double balboaToKRW = 1143.98;

    String[] options = {"USD", "EUR", "GBP", "JPY", "KRW" };
  
    	double amount = 0;
     	boolean validInput = false;
    	  while (!validInput) {
    	            String inputAmount = JOptionPane.showInputDialog(null, "Ingrese la cantidad a convertir:", "Conversor de Divisas", JOptionPane.PLAIN_MESSAGE);
    	            if (inputAmount == null) {
    	                return; 
    	            }

    	            try {
    	            	amount = Double.parseDouble(inputAmount);
    	                validInput = true;
    	            } catch (NumberFormatException e) {
    	                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
    	            }
    	        }
    	int choiceFrom = JOptionPane.showOptionDialog(null, "Seleccione la moneda de origen:", "Conversor de Divisas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      	int choiceTo = JOptionPane.showOptionDialog(null, "Seleccione la moneda a la que desea convertir:", "Conversor de Divisas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        double result = 0.0;
   String fromCurrency = "";
        String toCurrency = "";

    switch (choiceFrom) {
            case 0:
                fromCurrency = "Dólares";
                result = amount / balboaToUSD;
                break;
            case 1:
                fromCurrency = "Euros";
                result = amount / balboaToEUR;
                break;
            case 2:
                fromCurrency = "Libras Esterlinas";
                result = amount / balboaToGBP;
                break;
            case 3:
                fromCurrency = "Yen Japones";
                result = amount / balboaToJPY;
                break;
            case 4:
                fromCurrency = "Won surcoreano";
                result = amount / balboaToKRW;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Moneda de origen no valida", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
        }

        switch (choiceTo) {
            case 0:
                toCurrency = "Dólares";
                result *= balboaToUSD;
                break;
            case 1:
                toCurrency = "Euros";
                result *= balboaToEUR;
                break;
            case 2:
                toCurrency = "Libras Esterlinas";
                result *= balboaToGBP;
                break;
            case 3:
                toCurrency = "Yen Japones";
                result *= balboaToJPY;
                break;
            case 4:
                toCurrency = "Won surcoreano";
                result *= balboaToKRW;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Moneda de destino no válida", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
        }

        String message = String.format("%.2f %s equivale(n) a %.2f %s", amount, fromCurrency, result, toCurrency);
        JOptionPane.showMessageDialog(null, message, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        
       JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Conversor de Divisas", JOptionPane.YES_NO_OPTION);
    	   
       
             
	
	
    }
}

