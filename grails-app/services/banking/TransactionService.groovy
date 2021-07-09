package banking

import banking.dto.TransactionResponse
import banking.dto.TransactionsDto
import grails.gorm.transactions.Transactional

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Transactional
class TransactionService {
    AccountService accountService
    TransactionResponse doTransaction(TransactionsDto transactions, Serializable id){
        Accounts senders_acc = Accounts.get(id)
        String sender_acct_number = senders_acc.account_number
        String receiver_acct_number = transactions.getReceiver_acct_number()
        Accounts receivers_acc = accountService.getAccountByAcctNumber(receiver_acct_number)
        LocalDateTime time = LocalDateTime.now()
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String transaction_number = time.format(format)
        if(senders_acc.account_balance < transactions.amount ){
            return setTransactionResponse(BigDecimal.ZERO, sender_acct_number, receiver_acct_number, transaction_number)
        }
        else{
            BigDecimal receiver_acct_balance = receivers_acc.getAccount_balance();
            BigDecimal sender_acct_balance = senders_acc.getAccount_balance()
            receivers_acc.setAccount_balance(receiver_acct_balance.add(transactions.amount))
            senders_acc.setAccount_balance(sender_acct_balance.subtract(transactions.amount))
        }

        Transactions setTransactions = addTransactionsInDb(transaction_number, transactions.amount, "Db",sender_acct_number,receiver_acct_number)
        senders_acc.addToTransactions(setTransactions)
        setTransactions = addTransactionsInDb(transaction_number, transactions.amount, "Cr",sender_acct_number,receiver_acct_number)
        receivers_acc.addToTransactions(setTransactions)

        senders_acc.save()
        receivers_acc.save()

        TransactionResponse transactionResponse = setTransactionResponse(transactions.amount,sender_acct_number, receiver_acct_number, transaction_number)
        return transactionResponse
    }

    Transactions addTransactionsInDb(String txn_number, BigDecimal amount, String txnType, String sender_acct_number, String receiver_acct_number){
        Transactions transact = new Transactions()
        transact.setTransaction_number(txn_number)
        transact.setAmount(amount)
        transact.setTxnType(txnType)
        transact.setSender_acct_number(sender_acct_number)
        transact.setReceiver_acct_number(receiver_acct_number)
        return transact
    }

    TransactionResponse setTransactionResponse(BigDecimal amount, String sender_acct_number, String receiver_acct_number, String txn_number){

        TransactionResponse transactionResponse = new TransactionResponse()
        transactionResponse.setAmount(amount)
        transactionResponse.setReceiver_acct_number(receiver_acct_number)
        transactionResponse.setSender_acct_number(sender_acct_number)
        transactionResponse.setTransaction_number(txn_number)

        return transactionResponse
    }

    TransactionResponse doSelfTransaction(TransactionsDto transactions, String txnType){
        String beneficiary_acct_number = transactions.getReceiver_acct_number()
        Accounts beneficiary_acc = accountService.getAccountByAcctNumber(beneficiary_acct_number)
        LocalDateTime time = LocalDateTime.now()
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String transaction_number = time.format(format)

        BigDecimal beneficiary_acct_balance = beneficiary_acc.getAccount_balance();
        if(txnType == "Db" && beneficiary_acct_balance < transactions.amount){
            return setTransactionResponse(BigDecimal.ZERO, beneficiary_acct_number, beneficiary_acct_number, transaction_number)
        }
        if(txnType == "Cr"){
            beneficiary_acc.setAccount_balance(beneficiary_acct_balance.add(transactions.amount))
        }
        else if(txnType == "Db"){
            beneficiary_acc.setAccount_balance(beneficiary_acct_balance.subtract(transactions.amount))
        }

        Transactions setTransactions = addTransactionsInDb(transaction_number, transactions.amount, txnType,beneficiary_acct_number,beneficiary_acct_number)

        beneficiary_acc.addToTransactions(setTransactions)
        beneficiary_acc.save()

        TransactionResponse transactionResponse = setTransactionResponse(transactions.amount, beneficiary_acct_number, beneficiary_acct_number, transaction_number)
        return transactionResponse
    }

}
