# Caixa Eletrônico - Banco Digital

Um sistema simples de caixa eletrônico para um banco digital, permitindo criação de contas, login, saques, depósitos, transferências e extrato.

## Funcionalidades

### Menu Principal
- **1 - Entrar**: Login no sistema.
- **2 - Criar Conta**: Criação de conta (corrente ou poupança).
- **3 - para voltar**: voltar.
- **4 - Fechar o sistema**: Encerra o programa.

### Menu da Conta
- **1 - Sacar**: Realiza um saque.
- **2 - Depositar**: Realiza um depósito.
- **3 - Transferir**: Realiza uma transferência.
- **4 - Extrato**: Exibe o extrato da conta.
- **5 - Sair**: Encerra a sessão.

## Como Usar

1. Inicialize o sistema executando o método `init` da classe `CaixaEletronico`.

```java
public class Main {
    public static void main(String[] args) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        caixaEletronico.init();
    }
}
