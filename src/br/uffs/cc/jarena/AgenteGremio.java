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
		enviaMensagem("seguir" + "," + this.getX() + "," + this.getY() + "," + this.getId());
	}

	public void tomouDano(int energiaRestanteInimigo) {
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).

		if (this.getEnergia() > energiaRestanteInimigo) {
			enviaMensagem("seguir" + "," + this.getX() + "," + this.getY() + "," + this.getId());
		} else if (this.getEnergia() < energiaRestanteInimigo || this.getEnergia() > energiaRestanteInimigo / 2) {
			para(); // se mexer gasta o dobro que ficar parado
		}

	}

	public void ganhouCombate() {
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}

	public void recebeuMensagem(String msg) {
		String[] mensagemrecebida = msg.split(",");

		if (mensagemrecebida[0].equals("seguir")) {

			int x = Integer.parseInt(mensagemrecebida[1]);
			int y = Integer.parseInt(mensagemrecebida[2]);
			double id = Double.parseDouble(mensagemrecebida[3]);

			// faz o cara seguir

			// calcula a distancia
			int deltaX = this.getX() - x;
			int deltaY = this.getY() - y;

			// calcula o modulo
			int distanciaX = Math.abs(deltaX);
			int distanciaY = Math.abs(deltaY);

			if (distanciaX > distanciaY) {

				// delta negativo = alvo à direita
				// delta positivo = alvo à esquerda
				if (deltaX < 0) {
					setDirecao(1);
				} else if (deltaX > 0) {
					setDirecao(2);
				}

			} else if (distanciaY > distanciaX) {
				// delta negativo = alvo acima
				// delta positivo = alvo abaixo
				if (deltaY > 0) {
					setDirecao(4);
				} else if (deltaY < 0) {
					setDirecao(3);
				}

			}

		}
	}

	public String getEquipe() {
		// Definimos que o nome da equipe do agente é "Grêmio".
		return "Grêmio";
	}
}
