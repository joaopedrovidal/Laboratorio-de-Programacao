package exBanco;

public class Banco {
    private int numero;
    private int ag_numero;
    private String ag_nome;
    private int tipo;
    private double saldo;


    public Banco(int numero, int ag_numero, String ag_nome, int tipo, double saldo) {
        this.numero = numero;
        this.ag_numero = ag_numero;
        this.ag_nome = ag_nome;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Banco(int numero, int ag_numero, String ag_nome, int tipo) {
        this(numero, ag_numero, ag_nome, tipo, 0);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getAg_nome() {
        return ag_nome;
    }

    public void setAg_nome(String ag_nome) {
        this.ag_nome = ag_nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAg_numero() {
        return ag_numero;
    }

    public void setAg_numero(int ag_numero) {
        this.ag_numero = ag_numero;
    }

    public double creditarConta(double saldoCreditado){
        if(getTipo() == 4){
            System.out.println("\nOps! parece que essa conta foi encerrada!");
            return getSaldo();
        }

        this.saldo = getSaldo() + saldoCreditado;
        return getSaldo();
    }

    public double debitarSaldo(double saldoDebitado){
        if(getTipo() == 4){
            System.out.println("\nOps! parece que essa conta foi encerrada!");
            return getSaldo();
        }

        this.saldo = getSaldo() - saldoDebitado;
        return getSaldo();
    }

    public double consultarSaldo(){
        System.out.println("\nA conta " + getNumero() + " possui o saldo de R$ " + getSaldo());
        return getSaldo();
    }

    public double encerrarConta(){
        if(getSaldo() < 0){
            System.out.println("\nSua conta nao pode ser encerrada porque o saldo e negativo! Regularize seu saldo antes de encerrar a conta");
            return getSaldo();
        }

        this.tipo = 4;
        double saldoEncerrado = getSaldo();
        setSaldo(0);

        return saldoEncerrado;
    }

    public void textoEncerrar(double saldoEncerrado){
        System.out.println("A conta " + getNumero() + " com o tipo " + getTipo() + " foi encerrada com o saldo R$ " + saldoEncerrado);
    }
}
