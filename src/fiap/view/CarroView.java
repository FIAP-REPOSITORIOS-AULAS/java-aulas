package fiap.view;

import javax.swing.JOptionPane;

import fiap.controller.CarroController;

public class CarroView {

	public static void main(String[] args) {
		String aux, escolha = "sim", placa, cor, descricao;
		int opcao;
		CarroController carroCon = new CarroController();
		
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha: \n(1) - Inserir \n(2) - Alterar \n(3) - Excluir");
				opcao = Integer.parseInt(aux);
				placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
				
				switch (opcao) {
				case 1:
					cor = JOptionPane.showInputDialog("Cor do carro: ");
					descricao = JOptionPane.showInputDialog("Descricao: ");
					System.out.println(carroCon.insereCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, carroCon.listaCarro());
					
					
					break;
				case 2:
					cor = JOptionPane.showInputDialog("Cor do carro: ");
					descricao = JOptionPane.showInputDialog("Descricao: ");
					System.out.println(carroCon.alteraCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, carroCon.listaCarro());
					break;
					
				case 3:
					System.out.println(carroCon.exclui(placa));
					JOptionPane.showMessageDialog(null, carroCon.listaCarro());
					break;

				default:
					System.out.println("Escolha incoreta!");
					break;
				}
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
		

	}

}
