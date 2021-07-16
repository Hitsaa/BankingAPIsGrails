package banking

import java.time.LocalDateTime

class AccountTransactions {


    String txnNumber
    BigDecimal amount
    String txnType
    String createdOn

    static belongsTo = [accounts:Accounts]

    static constraints = {
        amount nullable: false, blank:false
        txnType nullable: false, blank: false, inList: ["Cr", "Dr"]
        txnNumber nullable: false, blank: false
    }
}
