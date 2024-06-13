package controller;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import view.CaixaEletronicoView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CaixaEletronico {
    private List<Conta> contas = new ArrayList<>();
    private CaixaEletronicoView view = new CaixaEletronicoView();
    private Conta contaAtual = null;

    public void init() {
        view.exibir("---Bem vindo ao Banco Digital---");
        while (true) {
            view.exibir("Escolha uma opção");
            view.exibir("1 - Entrar");
            view.exibir("2 - Criar Conta");
            view.exibir("3 - para voltar");
            view.exibir("4 - Fechar o sistema");

            int op = lerOpcao();
            if (op == 1) {
                if (login()) {
                    menuConta();
                }
            } else if (op == 2) {
                criarConta();
            } else if (op == 4) {
                break;
            }
        }
    }

    private int lerOpcao() {
        try {
            return Integer.parseInt(view.input());
        } catch (InputMismatchException | NumberFormatException e) {
            view.exibir("Opção inválida. Tente novamente.");
            return -1;
        }
    }

    private void criarConta() {
        view.exibir("Conta poupança(p) ou corrente(c)?");
        String tipo = view.input();
        view.exibir("Seu nome:");
        String nome = view.input();
        view.exibir("Digite seu CPF:");
        String cpf = view.input();
        view.exibir("Crie uma senha:");
        String senha = view.input();

        Cliente cliente = new Cliente(nome, cpf);
        Conta conta = tipo.equalsIgnoreCase("p") ? new ContaPoupanca(cliente) : new ContaCorrente(cliente);
        conta.setSenha(senha);
        contas.add(conta);

        view.exibir("Conta adicionada com sucesso!");
    }

    private boolean login() {
        if (contaAtual != null) {
            return true;
        }
        while (true) {
            view.exibir("Digite seu CPF:");
            String cpf = view.input();
            if ("0".equals(cpf)) {
                return false;
            }

            view.exibir("Digite sua senha:");
            String senha = view.input();
            if ("0".equals(senha)) {
                return false;
            }

            contaAtual = buscarConta(cpf, senha);
            if (contaAtual == null) {
                view.exibir("Conta não encontrada, tente novamente!");
                view.exibir("Digite 0 para voltar");
            } else {
                return true;
            }
        }
    }

    private Conta buscarConta(String cpf, String senha) {
        return contas.stream()
                .filter(c -> c.getCliente().getCpf().equals(cpf) && c.getSenha().equals(senha))
                .findFirst()
                .orElse(null);
    }

    private void menuConta() {
        while (true) {
            view.exibir(String.format("Olá %s, o que deseja fazer hoje?", contaAtual.getCliente().getNome()));
            view.exibir("1 - Sacar");
            view.exibir("2 - Depositar");
            view.exibir("3 - Transferir");
            view.exibir("4 - Extrato");
            view.exibir("5 - Sair");

            int op = lerOpcao();
            if (op == 1) {
                sacar();
            } else if (op == 2) {
                depositar();
            } else if (op == 3) {
                transferir();
            } else if (op == 4) {
                getExtrato();
            } else if (op == 5) {
                contaAtual = null;
                break;
            }
        }
    }

    private void sacar() {
        view.exibir("Digite o valor do saque:");
        Double valor = lerValor();
        if (valor != null) {
            view.exibir(contaAtual.sacar(valor));
        } else {
            view.exibir("Valor inválido.");
        }
    }

    private void depositar() {
        view.exibir("Digite o valor de depósito:");
        Double valor = lerValor();
        if (valor != null) {
            view.exibir(contaAtual.depositar(valor));
        } else {
            view.exibir("Valor inválido.");
        }
    }

    private void transferir() {
        view.exibir("Digite o valor da transferência:");
        Double valor = lerValor();
        if (valor != null) {
            view.exibir("Número da conta:");
            Integer numeroConta = lerNumeroConta();
            if (numeroConta != null) {
                Conta contaDestino = buscarContaPorNumero(numeroConta);
                if (contaDestino != null) {
                    view.exibir(contaAtual.transferir(valor, contaDestino));
                } else {
                    view.exibir("Conta não encontrada.");
                }
            } else {
                view.exibir("Número de conta inválido.");
            }
        } else {
            view.exibir("Valor inválido.");
        }
    }

    private Double lerValor() {
        try {
            return Double.parseDouble(view.input());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer lerNumeroConta() {
        try {
            return Integer.parseInt(view.input());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Conta buscarContaPorNumero(Integer numero) {
        return contas.stream()
                .filter(c -> c.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    private void getExtrato() {
        view.exibir(contaAtual.toString());
    }
}
