package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if(salarioBase < 1039.00) return (long) 0.00;
		double salaryDiscountedINSS = calculateINSSDeduction(salarioBase);
		double netSalary = calculateIRPFDeduction(salaryDiscountedINSS);
	
		return Math.round(netSalary);
	}
	
	
	
	private double calculateINSSDeduction(double salaryBase) {
		double salaryDiscountedINSS = 0;
	    if (salaryBase <= 1500.00) {
			salaryDiscountedINSS = salaryBase - salaryBase*0.08;
		}else if(salaryBase > 1500.00 && salaryBase <= 4000.00) {
			salaryDiscountedINSS = salaryBase - salaryBase*0.09;
		}else if(salaryBase > 4000.00){
			salaryDiscountedINSS = salaryBase - salaryBase*0.11;
		}

		return salaryDiscountedINSS;
	}
	
	private double calculateIRPFDeduction(double salaryDiscountedINSS) {
		double salaryDiscountedIRPF = 0;
        if(salaryDiscountedINSS <= 3000.00) {
			salaryDiscountedIRPF = salaryDiscountedINSS - salaryDiscountedINSS*0.0; 
		}else if(salaryDiscountedINSS > 3000.00 && salaryDiscountedINSS <= 6000.00) {
			salaryDiscountedIRPF = salaryDiscountedINSS - salaryDiscountedINSS*0.075; 
		}else if(salaryDiscountedINSS > 6000.00) {
			salaryDiscountedIRPF = salaryDiscountedINSS - salaryDiscountedINSS*0.15; 
		}

		return salaryDiscountedIRPF;
		
	}

}
