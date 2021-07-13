package banking.dto

import grails.validation.Validateable

class AccountsResponse implements Validateable {

    Long id
    String accountNumber
    String accountName
    String description
}
