package model;
import java.util.*;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private String senha;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public String sacar(double valor) {
		if(saldo < valor){return "Ocorreu um erro!";}
		saldo -= valor;
		return "Saque efetuado!";
	}

	@Override
	public String depositar(double valor) {
		if (valor < 1){return "Ocorreu um erro!";}
		saldo += valor;
		return "Deposito realizado!";
	}

	@Override
	public String transferir(double valor, Conta contaDestino) {
		if(contaDestino == null){
			return "Ocorreu um erro!";
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
		return "Transferencia efetuada!";
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "Conta{" +
				"agencia=" + agencia +
				", numero=" + numero +
				", saldo=" + saldo +
				", cliente=" + cliente +
				'}';
	}
}
