import java.util.Scanner;

public class ProjetoRPG {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("- MENU PRINCIPAL -");
		System.out.println("===================");
		System.out.println("sonho_de_dev.java");
		System.out.println("=======OP��ES=======");
		System.out.println("1: NOVO JOGO");
		System.out.println("2: REGRAS");
		System.out.println("3: CR�DITOS");
		System.out.println("4: SAIR");
		System.out.println("===================");
		System.out.println("Digite o n�mero da op��o: ");
		int opcao;
		LeTextoCompassado("OI");
		opcao = ler.nextInt();
		
		switch (opcao){
			case 1:
				System.out.println("Op��o NOVO JOGO selecionada!");
				System.out.println("Tenha um bom jogo :)");
				break;
				
			case 2:
				System.out.println("Op��o REGRAS selecionada!");
				System.out.println("=======REGRAS=======");
				System.out.println("1 - Voc� dever� acertar a resposta das perguntas para causar dano no inimigo.");
				System.out.println("2 - Caso voc� erre a resposta, sofrer� dano.");
				System.out.println("3 - Voc� dever� fazer a barra de vida do inimigo chegar a zero para ganhar a batalha.");
				System.out.println("4 - Se sua barra de vida chegar a zero primeiro, voc� perder� a batalha.");
				System.out.println("5 - Fa�a boas escolhas, pois elas determinam seu progresso no jogo.");
				System.out.println("6 - Divirta-se! :)");
				break;
				
			case 3:
				System.out.println("Op��o CR�DITOS selecionada!");
				System.out.println("=======CR�DITOS=======");
				System.out.println("Este jogo foi desenvolvido pelo grupo 4 do Projeto Integrador");
				System.out.println("=====INTEGRANTES=====");
				System.out.println("Benjamin Nicolini");
				System.out.println("Daniel Izidio");
				System.out.println("Danilo Lima");
				System.out.println("Davi Yuri");
				System.out.println("Gustavo Souza");
				System.out.println("Gustavo Vieira");
				System.out.println("=====================");
				break;
			
			case 4:
				System.out.println("Op��o SAIR selecionada!");
				System.out.println("O jogo ser� encerrado.");
				System.exit(0);
				break;
		}
		ler.close();
	}
	public static void LeTextoCompassado(String texto) {

		System.out.println(texto.chars().count()); 
	}
}
