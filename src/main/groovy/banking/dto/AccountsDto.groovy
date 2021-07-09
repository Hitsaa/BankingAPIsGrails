package banking.dto

import banking.Transactions
import grails.validation.Validateable

class AccountsDto implements Validateable{
    String account_number
    String account_name
    String description
}
