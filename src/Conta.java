public abstract class Conta implements Transacoes {

    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1;
    protected int agencia;
    protected int conta;
    protected double saldo = 0.00;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if (verificarsaldo(valor)){
            this.saldo -= valor;
            System.out.println(String.format("Saque no valor R$%.2f realizado com sucesso. \nSaldo em conta: R$%.2f"
                    ,valor,this.saldo));
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println(String.format("Depósito no valor R$%.2f realizado com sucesso. \nSaldo em conta: R$%.2f"
,valor,this.saldo));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (verificarsaldo(valor)) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println(String.format("Transferência no valor R$%.2f realizado com sucesso. \nSaldo em conta: R$%.2f"
                    ,valor,this.saldo));
        }
    }

    protected void imprimirInfos() {
        System.out.println(String.format("Agencia: %d",this.agencia));
        System.out.println(String.format("Conta: %d",this.conta));
        System.out.println(String.format("Saldo: R$%.2f",this.saldo));
    }

    private boolean verificarsaldo(double valor){
        return this.saldo > valor;
    }
}
