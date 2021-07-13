package banking.dto

import banking.Transactions
import grails.validation.Validateable

class AccountsDto implements Validateable {
    String accountNumber
    String accountName
    String description
}
