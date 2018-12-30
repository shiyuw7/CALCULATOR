package calculator;

public class Main {
	public static void main(String[] args) {
		JCalculator theView =new JCalculator();
		CalculatorModel theModel = new CalculatorModel();
		CalculatorController theController = new CalculatorController(theModel,theView);
		theView.setVisible(true);
		
	}
}
