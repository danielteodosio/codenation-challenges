package br.com.codenation;

public class TesteChallenge {

	public static void main(String[] args) {
		int array[] = {8, 4, 3, 5, 3, 2, 3, 3}; // => {2, 3, 3, 3, 3, 4, 5, 8}
		StatisticUtil.average(array);
		StatisticUtil.mode(array);
		StatisticUtil.median(array);

	}

}
