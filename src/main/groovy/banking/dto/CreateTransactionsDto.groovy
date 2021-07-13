package banking.dto

import grails.validation.Validateable

class CreateTransactionsDto implements Validateable {
    BigDecimal amount
    String txnType
}
