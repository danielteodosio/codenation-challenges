package challenge;
import java.util.LinkedList;
import java.util.Queue;

public class Estacionamento {
	
	final Integer LIMITE_CARROS = 10;
	final Integer IDADE_SENIOR = 55;
	final Integer MIN_IDADE = 18;
	final Integer MAX_PONTOS = 20;

	private Queue<Carro> carrosEstacionados = new LinkedList<Carro>();

    public void estacionar(Carro carro) {
    	
    	if(carro.getMotorista() == null || 
    	   carro.getMotorista().getIdade() < MIN_IDADE || 
    	   carro.getMotorista().getPontos() > MAX_PONTOS) throw new EstacionamentoException("Carro inadequado");
    	
    	if(carrosEstacionados.size() >= LIMITE_CARROS) {
    		carrosEstacionados = tiraAlguemDaFila(carrosEstacionados);
    		if(carrosEstacionados.size() < LIMITE_CARROS) {
    			carrosEstacionados.add(carro);
    		}else {
    			throw new EstacionamentoException("Sem vagas");
    		}
    	}else {
    		carrosEstacionados.add(carro);
    	}
    }

    public int carrosEstacionados() {
        return this.carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return this.carrosEstacionados.contains(carro);
    }
    
    private Queue<Carro> tiraAlguemDaFila(Queue<Carro> fila) {
    	Queue<Carro> carrosEstacionados = fila;
    	Queue<Carro> carrosAindaNaFila = new LinkedList<Carro>();
    	Integer tamanhoFila = fila.size();
    	Carro newCarro;
    	
    	for(int i = 0; i < tamanhoFila; i++) {
    		newCarro = carrosEstacionados.remove();
    		if(newCarro.getMotorista().getIdade() >= IDADE_SENIOR) {
    			carrosAindaNaFila.add(newCarro);
    		}else {
    			carrosAindaNaFila.addAll(carrosEstacionados);
    			break;
    		}
    	}
    	return carrosAindaNaFila;
    }
    
}
