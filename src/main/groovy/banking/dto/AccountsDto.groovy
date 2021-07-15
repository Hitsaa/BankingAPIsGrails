package banking.dto

import banking.Transactions
import grails.validation.Validateable

class AccountsDto implements Validateable {
    BigInteger accountNumber
    String accountName
    String description
    static constraints = {
        accountNumber nullable: false, blank: false, unique: true
        accountName nullable: false, blank: false, matches: "[a-zA-Z]+"
        description nullable: true
    }
}
