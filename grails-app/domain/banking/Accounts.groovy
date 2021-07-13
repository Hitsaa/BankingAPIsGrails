package banking

class Accounts {
    String accountNumber
    String accountName
    String description
    BigDecimal accountBalance = BigDecimal.ZERO
//    static hasMany =  [transactions:Transactions]
    static hasMany = [txns: CreateTransactions]

    static constraints = {
        accountNumber nullable: false, unique: true
        accountName nullable: false
        description nullable: true
    }
}
