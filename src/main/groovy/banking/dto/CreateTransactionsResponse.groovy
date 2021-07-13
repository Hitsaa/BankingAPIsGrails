package banking.dto

import grails.validation.Validateable

import java.time.LocalDateTime

class CreateTransactionsResponse {
    Long id
    String txnNumber
    String createdOn
    BigDecimal amount
    String txnType
}
