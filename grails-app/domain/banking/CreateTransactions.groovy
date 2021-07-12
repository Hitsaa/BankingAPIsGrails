package banking

class CreateTransactions {


    String txnNumber
    BigDecimal amount
    String txnType

    static belongsTo = [accounts:Accounts]

    static constraints = {
        amount nullable: false
        txnType nullable: false
        txnNumber nullable: false
    }
}
