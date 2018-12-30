package calculator;

public class CalculatorModel {
	private double result;
	
	public void Add(double firstNum,double secondNum) {
		result = firstNum + secondNum;
	}
	
	public void minus(double firstNum,double secondNum) {
		result = firstNum - secondNum;
	}
	
	public void multiple(double firstNum,double secondNum) {
		result = firstNum * secondNum;
	}
	
	public void divide(double firstNum,double secondNum) {
		result = firstNum / secondNum;
	}
	
	public double getResult() {
		return result;
	}
	
	public void setResult(double number) {
		result=number;
	}
}
