package banking

import java.text.SimpleDateFormat
import java.time.LocalDateTime

class Transactions {

//    String pattern = "yyyy-MM-ddThh:mm:ss:SSS";
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//    transaction_number = simpleDateFormat.format(new Date());
    String transaction_number
    BigDecimal amount
    String txnType
    String sender_acct_number
    String receiver_acct_number

//    static belongsTo = [accounts:Accounts]

    static constraints = {
        amount nullable: false
        txnType nullable: false
    }
}
