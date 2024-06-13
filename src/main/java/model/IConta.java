package model;

public interface IConta {
	
	String sacar(double valor);
	
	String depositar(double valor);
	
	String transferir(double valor, Conta contaDestino);
	
}
