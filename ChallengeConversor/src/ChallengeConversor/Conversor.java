package ChallengeConversor;
import javax.swing.JOptionPane;
	
	public class Conversor {

	    public static void main(String[] args) {
	    	
	    	new ConversorDivisas();
	    	new ConversorTemperatura();
	    	new ConversorDistancia();
	    	
	    	boolean shouldExit = false;

	        while (!shouldExit) {
	            Object[] options = { "Conversor de Divisas", "Conversor de Temperatura", "Conversor de Distancia", "Salir" };
	            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Conversores", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

	            switch (choice) {
	                case 0:
	                	ChallengeConversor.ConversorDivisas.currencyConverter(args);
	                    break;
	                case 1:
	                    ChallengeConversor.ConversorTemperatura.tempConverter(args);
	                    break;
	                case 2:
	                	ChallengeConversor.ConversorDistancia.distanceConverter(args);
	                	break;
	                case 3:
	                	JOptionPane.showMessageDialog(null, "Programa terminado");
	                    shouldExit = true;
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
	                    break;
	                    	
	                    
	            }
	        
	        }
            
	    }
	}
	    