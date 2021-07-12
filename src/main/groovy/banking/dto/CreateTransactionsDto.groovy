package banking.dto

import grails.validation.Validateable

class CreateTransactionsDto {
    BigDecimal amount
    String txnType
}
