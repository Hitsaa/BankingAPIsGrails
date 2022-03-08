package banking

import banking.dto.TransactionResponse
import banking.dto.TransactionsDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

class TransactionsController {
    TransactionService transactionService

    static responseFormats = ['json']
    def otherAccountTransaction(@RequestBody TransactionsDto transactions){
        try{
            respond transactionService.doTransaction(transactions, params.id)
        }catch(Exception e){
            respond e.stackTrace
        }
    }

    def selfAccountTransaction(TransactionsDto transactions){
        try{
            String txnType = params.txnType
            TransactionResponse transactionResponse = transactionService.doSelfTransaction(transactions,txnType)
            respond transactionResponse
        }catch(Exception e){
            respond e.stackTrace
        }
    }

}
