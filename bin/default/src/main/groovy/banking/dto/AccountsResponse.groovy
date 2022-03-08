package banking.dto

import grails.validation.Validateable

class AccountsResponse implements Validateable {

    Long id
    BigInteger accountNumber
    String accountName
    String description
}
