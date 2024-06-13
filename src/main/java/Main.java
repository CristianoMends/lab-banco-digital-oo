import controller.CaixaEletronico;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		CaixaEletronico banco = new CaixaEletronico();
		banco.init();
	}

}
