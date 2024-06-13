package model;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public String toString() {
		return "Conta Corrente: " +
				"agencia=" + agencia +
				", numero=" + numero +
				", saldo=" + saldo;
	}
}
