import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String transacao="";

        Conta contaCorrente = new ContaCorrente();
        Conta contaPoupanca = new ContaPoupanca();

        Map<String,Conta> mConta = new HashMap<>();
        mConta.put("1",contaCorrente);
        mConta.put("2",contaPoupanca);

        System.out.println("Bem vindo ao banco digital.");
        while (true){
            System.out.println("Digite o numero referente a transação que você deseja realizar.");
            System.out.println("(1) Saque. \n(2) Deposito. \n(3) Transferência.\n(4)Extrato.\n(Sair) Finalizar atendimento.");

            transacao = sc.next();
            if (transacao.equals("Sair")) {
                System.out.println("Obrigado por utilizar nossos serviços. :)");
                System.exit(0);
            }
            System.out.println("Deseja realizar a transação de qual conta? \n(1) Conta Corrente.\n(2) Conta Poupança.");
            String conta = sc.next();

            switch (transacao){
                case "1":
                    System.out.println("Digite o valor a ser sacado:");
                    mConta.get(conta).sacar(sc.nextDouble());
                    break;
                case "2":
                    System.out.println("Digite o valor a ser depositado:");
                    mConta.get(conta).depositar(sc.nextDouble());
                    break;
                case "3":
                    System.out.println("Digite o valor a ser transferido:");
                    double valorTransferido = sc.nextDouble();
                    System.out.println("Para qual conta?");
                    mConta.get(conta).transferir(sc.nextDouble(),contaPoupanca);
                case "4":
                    mConta.get(conta).imprimirExtrato();
                case "Sair":
                    System.out.println("Obrigado por utilizar nossos serviços. :)");
                    System.exit(0);
                default:
                    System.out.println("Por favor insira uma opção valida!");
            }
        }
    }
}
