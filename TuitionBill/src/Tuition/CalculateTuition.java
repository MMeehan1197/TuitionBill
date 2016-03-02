package Tuition;

import java.util.Scanner;

public class CalculateTuition {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input how much your tuition costs per year: ");
		double tuition = 4 * input.nextDouble();
		
		System.out.println("Please input the percentage increases for your university: ");
		double percentIncrease = input.nextDouble();
		
		System.out.println("Please input your repayment APR: ");
		double APR = input.nextDouble();
		
		System.out.println("Please input how long you have to pay off the costs: ");
		double term = input.nextDouble();
		
		double totalTuition = TotalTuition(tuition, percentIncrease);
		double monthlyPayment = MonthlyPayment(totalTuition, APR, term);
		
		System.out.printf("The total cost of tuition will be $%7.2f and the monthly payment will be $%4.2f", totalTuition, monthlyPayment);
		
	}
	
	private static double TotalTuition(double tuition, double percent){
		double total = tuition;
		for(int i = 0; i < 2; i++){
			tuition = tuition * percent;
			total += tuition;
		}
		return total;
	}
	
	private static double MonthlyPayment(double principle, double APR, double term){
		double APRm = APR / 12;
		double monthly = principle * (APRm/(1-Math.pow(1+APRm, term * -1)));
		return monthly;
	}
}
