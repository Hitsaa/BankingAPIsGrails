package banking.dto

import grails.validation.Validateable

class TransactionResponse implements Validateable {
    String sender_acct_number
    String receiver_acct_number
    String transaction_number
    BigDecimal Amount
}
