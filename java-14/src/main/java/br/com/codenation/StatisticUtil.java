package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		Integer sum = 0;
		for(int num : elements) {
			sum += num;
		}
		return sum/elements.length;  
	}

	public static int mode(int[] elements) {
		int indexMode = 0;
		int greatestFrequency = 0;
		int ocurrences[] = new int[elements.length];
		
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length; j++) {
				if(elements[i] == elements[j]) {
					ocurrences[i]++;
				}
			}
		}
		for(int i = 0; i < ocurrences.length; i++) {
			if(ocurrences[i] > greatestFrequency) {
				indexMode = i;
				greatestFrequency = ocurrences[i];
			}
		}
		return elements[indexMode];
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		if(elements.length % 2 != 0) {
			return elements[(int)Math.floor(elements.length/2)];
		}else {
			return Math.round((elements[elements.length/2] + elements[elements.length/2 - 1])/2);
		}
	}
}