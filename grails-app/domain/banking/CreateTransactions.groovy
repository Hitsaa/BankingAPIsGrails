package banking

class CreateTransactions {


    String txn_number
    BigDecimal amount
    String txnType

    static belongsTo = [accounts:Accounts]

    static constraints = {
        amount nullable: false
        txnType nullable: false
        txn_number nullable: false
    }
}
