package estrutura;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		ManageAttendance mng = new ManageAttendance(5);
		int input = 0;
		while(true) {
			
			// Finalizar programa
			if (input == 5) {
				if(mng.showNext() == null)
					break;
				System.out.println("Você ainda possui clientes para atender!");
			}
				
			
			System.out.println("1 - Chegada de cliente na agência");
			System.out.println("2 - Verificar quem é o próximo a ser atendido");
			System.out.println("3 - Atender um cliente");
			System.out.println("4 - Exibir as filas");
			System.out.println("5 - Finalizar o programa");
			
			input = scn.nextInt();
			
			switch(input) {
				case 1:
					System.out.println("Insira o nome do cliente: ");
					String nome = scn.next();
					System.out.println("Insira a idade do cliente: ");
					int idade = scn.nextInt();
					Client cli = new Client(nome, idade);
					mng.addClient(cli);
					break;
				case 2:
					if (mng.showNext() == null) {
						System.out.println("Não tem mais ninguém nas filas!");
						break;
					}
					System.out.println("Nome: " + mng.showNext().getName() + "; Idade " + mng.showNext().getAge());
					break;
				case 3:
					if (mng.showNext() == null) {
						System.out.println("Não tem mais ninguém nas filas!");
						break;
					}
					System.out.println("Nome: " + mng.showNext().getName() + "; Idade " + mng.showNext().getAge());
					mng.getNext();
					break;
				case 4:
					System.out.println(mng.showQueues());
					break;
				case 5:
					break;
				default:
					System.out.println("Numero inválido!");
					break;
			}
		}
		
		scn.close();
	}

}
