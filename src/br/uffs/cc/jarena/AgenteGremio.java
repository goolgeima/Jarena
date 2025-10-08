package br.uffs.cc.jarena;

public class AgenteGremio extends Agente {
	public AgenteGremio(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(geraDirecaoAleatoria());
	}

	public void pensa() {

		if (!podeMoverPara(getDirecao())) {
			setDirecao(geraDirecaoAleatoria());
		}

	}

	public void recebeuEnergia() {
		// Invocado sempre que o agente recebe energia.
		enviaMensagem("" + this.getX() + "," + this.getY() + "," + this.getId());
	}

	public void tomouDano(int energiaRestanteInimigo) {
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).
	}

	public void ganhouCombate() {
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}

	public void recebeuMensagem(String msg) {
		// Invocado sempre que um agente aliado próximo envia uma mensagem.
		String[] mensagemrecebida = msg.split(",");

		int x = Integer.parseInt(mensagemrecebida[0]);
		int y = Integer.parseInt(mensagemrecebida[1]);
		double id = Double.parseDouble(mensagemrecebida[2]);

		// faz o cara seguir o cogumelo
		(
			if (this.getX() < x) {
			setDirecao(1);
		}
			if (this.getX() > x) {
			setDirecao(2);
		}
			if (this.getY() < y) {
			setDirecao(3);
		}
			if (this.getY() > y) {
			setDirecao(4);
		}
		)

	}

	public String getEquipe() {
		// Definimos que o nome da equipe do agente é "Grêmio".
		return "Grêmio";
	}
}
