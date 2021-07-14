package banking

import banking.dto.CreateTransactionsDto
import banking.dto.CreateTransactionsResponse
import grails.gorm.transactions.Transactional

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Transactional
class AccountTransactionsService {

    CreateTransactionsResponse createTransactions(CreateTransactionsDto txn_dto, Serializable id){
        Accounts user_acc = Accounts.get(id)
        if(user_acc == null){
            return null
        }
        LocalDateTime time = LocalDateTime.now()
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String txn_number = time.format(format)

        AccountTransactions txn_obj = new AccountTransactions()
        txn_obj.setAmount(txn_dto.amount)
        txn_obj.setTxnType(txn_dto.txnType)
        txn_obj.setTxnNumber(txn_number)
        txn_obj.setCreatedOn(time.toString())
        txn_obj.save()

        user_acc.addToTxns(txn_obj)
        user_acc.save(flush:true)

        CreateTransactionsResponse txn_response = new CreateTransactionsResponse()
        txn_response = setTxnResponse(txn_response,txn_obj)
        return txn_response
    }

    CreateTransactionsResponse setTxnResponse(CreateTransactionsResponse txn_response, AccountTransactions txn_obj){
        txn_response.setId(txn_obj.id)
        txn_response.setTxnNumber(txn_obj.txnNumber)
        txn_response.setTxnType(txn_obj.txnType)
        txn_response.setAmount(txn_obj.amount)
        txn_response.setCreatedOn(txn_obj.createdOn)
        return txn_response
    }

    List<AccountTransactions> getAllTransactions(){
        return AccountTransactions.findAll()
    }

    AccountTransactions getTransactionsById(Serializable id){
        return AccountTransactions.get(id)
    }
}
