package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {
	final static int LIMIT = 350;
	
	public static List<Integer> fibonacci() {
		ArrayList<Integer> fibonacciList = new ArrayList<Integer>();
		
		//inicializando com os dois primeiros valores
		fibonacciList.add(0);
		fibonacciList.add(1);
		
		int newResult = 0;
		int index = 2 ;
		
		while(newResult < LIMIT) {
			newResult = fibonacciList.get(index-1) + fibonacciList.get(index-2);
			fibonacciList.add(newResult);
			index++;
		}
		
		return fibonacciList;
	}

	public static Boolean isFibonacci(Integer number) {
		List<Integer> fibonacciList = fibonacci();
		return fibonacciList.contains(number);

	}
    
}