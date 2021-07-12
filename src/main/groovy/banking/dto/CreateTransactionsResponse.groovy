package banking.dto

import grails.validation.Validateable

class CreateTransactionsResponse {
    Long id
    String txn_number
    BigDecimal amount
    String txnType
}
