package banking.dto

import grails.validation.Validateable

import java.time.LocalDateTime

class TransactionResponse implements Validateable {
    String sender_acct_number
    String receiver_acct_number
    String transaction_number
    BigDecimal Amount
}
