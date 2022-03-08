package banking

class Accounts {
    BigInteger accountNumber
    String accountName
    String description
    BigDecimal accountBalance = BigDecimal.ZERO
//    static hasMany =  [transactions:Transactions]
    static hasMany = [txns: AccountTransactions]

    static constraints = {
        accountNumber nullable: false, blank: false, unique: true
        accountName nullable: false, blank: false, matches: "[a-zA-Z]+"
        description nullable: true
    }
}
