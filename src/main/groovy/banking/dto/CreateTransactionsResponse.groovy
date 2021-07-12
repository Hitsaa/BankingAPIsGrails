package banking.dto

import grails.validation.Validateable

class CreateTransactionsResponse {
    Long id
    String txnNumber
    BigDecimal amount
    String txnType
}
