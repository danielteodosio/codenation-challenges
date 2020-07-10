package challenge;

import java.util.LinkedList;
import java.util.Queue;

public class TestChallenge {
	
	

	public static void main(String[] args) {
		Queue<Carro> carrosEstacionados = new LinkedList<Carro>();
		Estacionamento estacionamento = new Estacionamento();
		
		for(int i = 0; i < 3; i++) {
			carrosEstacionados.add(Carro.builder().withCor(Cor.PRETO).withPlaca("6376736723").withMotorista(
					Motorista.builder()
	                   .withHabilitacao("87237283782")
	                   .withIdade(56)
	                   .withNome("chris")
	                   .withPontos(12)
	                   .build()).build());
		}
		
		carrosEstacionados.add(Carro.builder().withCor(Cor.COLORIDO).withPlaca("98383933873873").withMotorista(
				Motorista.builder()
                   .withHabilitacao("1923883838389")
                   .withIdade(60)
                   .withNome("ada")
                   .withPontos(12)
                   .build()).build());
		
		for(int i = 0; i < 6; i++) {
			carrosEstacionados.add(Carro.builder().withCor(Cor.COLORIDO).withPlaca("738373873873").withMotorista(
					Motorista.builder()
	                   .withHabilitacao("73873837922")
	                   .withIdade(65)
	                   .withNome("jill")
	                   .withPontos(12)
	                   .build()).build());
		}
		
		carrosEstacionados.add(Carro.builder().withCor(Cor.COLORIDO).withPlaca("98383933873873").withMotorista(
				Motorista.builder()
                   .withHabilitacao("1923883838389")
                   .withIdade(60)
                   .withNome("ada")
                   .withPontos(12)
                   .build()).build());
		
		//carrosEstacionados = estacionamento.tiraAlguemDaFila(carrosEstacionados);
		estacionamento.estacionar(Carro.builder().withCor(Cor.COLORIDO).withPlaca("98383933873873").build());


	}

}
