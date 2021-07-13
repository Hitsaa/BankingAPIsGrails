package banking

import java.time.LocalDateTime

class CreateTransactions {


    String txnNumber
    BigDecimal amount
    String txnType
    String createdOn

    static belongsTo = [accounts:Accounts]

    static constraints = {
        amount nullable: false
        txnType nullable: false
        txnNumber nullable: false

    }
}
