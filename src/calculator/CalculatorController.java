package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
	private CalculatorModel theModel;
	private JCalculator theView;

	public CalculatorController(CalculatorModel theModel,JCalculator theView) {
		this.theModel=theModel;
		this.theView=theView;
		this.theView.addResetActionListener(new resetListener());
		this.theView.addButtonsListener(new buttonsListener());
	}
	
	
	class resetListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			theView.display.setText("");		
		}
	}
	
	class buttonsListener implements ActionListener{
		boolean isFirstDigit= true;
		double number = 0.0;
		String operator= "=";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Object target = e.getSource();
			String cmd = e.getActionCommand();
			if (" 0123456789.".indexOf(cmd)>0) 
				handleNumber(cmd);
			else
				handleOperator(cmd);				
		}	
		
		public void handleNumber(String key) {
			if(isFirstDigit) 
				theView.display.setText(key);
			else if(!key.equals(".")) 
				theView.display.setText(theView.display.getText()+key);
			else if(theView.display.getText().indexOf(".")<0) 
				theView.display.setText(theView.display.getText()+".");	
			isFirstDigit=false;
		}
		
		public void handleOperator(String key) {
			double displayNum = Double.valueOf(theView.display.getText());
			switch(operator) {
			case "=":
				theModel.setResult(displayNum);
				break;
			case "+":
				theModel.Add(number,displayNum);
				break;
			case "-":
				theModel.minus(number,displayNum);
				break;
			case "*":
				theModel.multiple(number,displayNum);
				break;
			case "/":
				theModel.divide(number,displayNum);
				break;
			}
			number=theModel.getResult();
			theView.display.setText(String.valueOf(theModel.getResult()));
			operator=key;
			isFirstDigit=true;
			
		}
	}
}
