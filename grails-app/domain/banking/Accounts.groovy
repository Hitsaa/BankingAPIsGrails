package banking

class Accounts {
    String account_number
    String account_name
    String description
    BigDecimal account_balance = BigDecimal.ZERO
    static hasMany =  [transactions:Transactions]

    static constraints = {
        account_number nullable: false, unique: true
        account_name nullable: false
        description nullable: true
    }
}
