package banking.dto

import grails.validation.Validateable

class TransactionsDto implements Validateable {
    String receiver_acct_number
    BigDecimal amount
}
