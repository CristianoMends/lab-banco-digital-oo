package model;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}


	@Override
	public String toString() {
		return "Conta Poupanca: " +
				"agencia=" + agencia +
				", numero=" + numero +
				", saldo=" + saldo;
	}
}
