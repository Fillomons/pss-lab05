package it.unibo.encapsulation.interfaces;

public class SimpleBankAccount implements BankAccount {

    /*
     * Aggiungere i seguenti campi:
     * - double balance: ammontare del conto
     * - int transactions: numero delle operazioni effettuate
     * - static double ATM_TRANSACTION_FEE = 1: costo delle operazioni via ATM
     */
    private double balance;
    private int transactions;
    static double ATM_TRANSACTION_FEE = 1;
    private final int id;

    /*
     * Creare un costruttore pubblico che prenda in ingresso un intero (ossia l'id
     * dell'utente) ed un double (ossia, l'ammontare iniziale del conto corrente).
     */
    public SimpleBankAccount(final int id, final double balance) {      //un costruttore è un metodo con gli stessi valori della classe perchè ha lo stesso nome
        this.id = id
        this.balance = balance;
    }

    /*
     * Si aggiungano selettori per:
     * - ottenere l'id utente del possessore del conto
     * - ottenere il numero di transazioni effettuate
     * - ottenere l'ammontare corrente del conto.
     */
    public int getid() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void deposit(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto Nota: il deposito va a buon fine solo se l'id utente
         * corrisponde
         */
        /*if(this.id = id){
            this.transactions += 1;
            this.balance = this.balance + amount;
        }*/

        this.totalOperation(id, amount);
        

    }

    public void withdraw(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount al totale del
         * conto. Note: - Il conto puo' andare in rosso (ammontare negativo) -
         * Il prelievo va a buon fine solo se l'id utente corrisponde
         */

        /*if(this.id = id){
            this.transactions += 1;
            this.balance = this.balance - amount;
        }*/

        this.totalOperation(id, -amount);
    }

    public void depositFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto detraendo le spese (costante ATM_TRANSACTION_FEE) relative
         * all'uso dell'ATM (bancomat) Nota: il deposito va a buon fine solo se
         * l'id utente corrisponde
         */

        /*if(this.id = id){
            this.transactions += 1;
            this.balance = this.balance + amount - this.ATM_TRANSACTION_FEE;
        }*/

        this.totalOperation(id, amount - this.ATM_TRANSACTION_FEE);
    }

    public void withdrawFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount + le spese
         * (costante ATM_TRANSACTION_FEE) relative all'uso dell'ATM (bancomat)
         * al totale del conto. Note: - Il conto puo' andare in rosso (ammontare
         * negativo) - Il prelievo va a buon fine solo se l'id utente
         * corrisponde
         */

        /*if(this.id = id){
            this.transactions += 1;
            this.balance = this.balance - amount - this.ATM_TRANSACTION_FEE;
        }*/

        this.totalOperation(id, -amount - this.ATM_TRANSACTION_FEE);
    }

    public void chargeManagementFees(final int id) {
        /*
         * Riduci il bilancio del conto di un ammontare pari alle spese di gestione
         */
        this.balance = this.balance - this.ATM_TRANSACTION_FEE;
    }

    private void totalOperation(final int id, final double variation){          //ho creato un nuovo metodo e nelle tonde ci ho messo le due variabili che ci servivono e ho richiamato amount con variation per non confondermi(nelle varie operazioni uso lo stesso amout)
        if(this.id = id){
            this.transactions += 1;
            this.balance = this.balance + variation;
        }
        else
            System.out.println("Error. Invalid user id.")
    }
}
