package banking.dto

import grails.validation.Validateable

class TransactionsDto {
    String receiver_acct_number
    BigDecimal amount
}
