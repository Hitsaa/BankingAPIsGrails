package banking

import banking.dto.CreateTransactionsDto
import banking.dto.CreateTransactionsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

class CreateTransactionsController {

    CreateTransactionsService createTransactionsService
    static responseFormats = ['json']

    ResponseEntity<CreateTransactionsResponse> createTransactions(@RequestBody CreateTransactionsDto txn_dto){
        try{
            respond createTransactionsService.createTransactions(txn_dto, params.id)
        }catch(Exception e){
            respond e.stackTrace
        }
    }

    def getAllTransactions(){
        try{
            respond createTransactionsService.getAllTransactions()
        }catch(Exception e){
            respond e.stackTrace
        }
    }

    def getTransactionsById(){
        try{
            respond createTransactionsService.getTransactionsById(params.id)
        }catch(Exception e){
            respond e.stackTrace
        }
    }

}
