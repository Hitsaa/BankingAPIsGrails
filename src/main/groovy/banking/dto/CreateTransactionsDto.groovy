package banking.dto

import grails.validation.Validateable

class CreateTransactionsDto implements Validateable {
    BigDecimal amount
    String txnType
    static constraints = {
        amount nullable: false, blank:false
        txnType nullable: false, blank: false, inList: ["Cr", "Dr"]
    }
}
