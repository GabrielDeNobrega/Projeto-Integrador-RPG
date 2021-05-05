package Models;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RPG {
	private List<Pergunta> perguntas;
	private List<Capitulo> capitulos;
	private List<Personagem> inimigos;
	private ConfiguracaoJogo configuracaoJogo;
	
	public ConfiguracaoJogo getConfiguracaoJogo() {return configuracaoJogo;}
	public void setConfiguracaoJogo(ConfiguracaoJogo configuracaoJogo) {this.configuracaoJogo = configuracaoJogo;}
	
	public List<Personagem> getInimigos() { return inimigos; }
	public void setInimigos(List<Personagem> inimigos) { this.inimigos = inimigos; }
	
	public List<Capitulo> getCapitulos() { return capitulos; }
	public void setCapitulos(List<Capitulo> capitulos) { this.capitulos = capitulos; }
	
	public List<Pergunta> getPerguntas() { return perguntas; }
	public void setPerguntas(List<Pergunta> perguntas) { this.perguntas = perguntas; } 
	
	
	
		public static void IniciaJogo() throws IOException {
			//Cria um objeto do tipo Configuracao que ser� usado para gerenciar todo o jogo
			RPG base = new RPG();
			int vida = ConfiguracaoJogo.GeraNumeroAleatorioPorIntervalo(90, 120), 
				poderAtaque = ConfiguracaoJogo.GeraNumeroAleatorioPorIntervalo(10, 25);
			
			//Chama o m�todo que preenche o objeto com os dados do json
			base = ConfiguracaoJogo.ConfiguraJogo();
			System.out.println("Caro jogador, insira seu Nome: ");
			
			//Cria um novo personagem para o jogador
			Personagem jogador = new Personagem(new Scanner(System.in).next(), vida, poderAtaque);	
			System.out.println("Seu personagem foi Criado:\nNome:"
								+jogador.getNome()+"\nVida:"
					            +vida+"\nPoder de Ataque: "+poderAtaque);
			
			/*Pega as perguntas que tiverem o mesmo n�vel de 
			dificuldade da propriedade de dificuldade do Json*/
			List<Pergunta> perguntas =  Pergunta.BuscaPerguntasComBaseDificuldadeGeral(base);
			
			List<Personagem> inimigos = Personagem.BuscaInimigosComBaseDificuldadeGeral(base);
			
			for(Capitulo capitulo: base.getCapitulos()) {
				
					if(perguntas.isEmpty() || inimigos.isEmpty()) {
						System.out.println("Parece que as perguntas ou os inimigos acabaram.");
						break;
					}
					System.out.println(capitulo.getTexto());
					
					jogador.Batalhar(inimigos,perguntas);
					if(jogador.getVida() <= 0 || jogador.getVida() < inimigos.get(0).getVida()) 
					{
						System.out.println("Voc� perdeu!");
						break;
				    }else if(jogador.getVida() > inimigos.get(0).getVida()){
						System.out.println("Voc� ganhou esse turno parab�ns");
				    }
			}	
	}
}


