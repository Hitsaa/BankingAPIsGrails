package banking

import banking.dto.CreateTransactionsDto
import banking.dto.CreateTransactionsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

class CreateTransactionsController {

    CreateTransactionsService createTransactionsService
    static responseFormats = ['json']

    ResponseEntity<CreateTransactionsResponse> createTransactions(@RequestBody CreateTransactionsDto txn_dto){
        try{
            def res = createTransactionsService.createTransactions(txn_dto, params.id)
            if(res != null){
                respond res
            }
            else{
                respond (error:"Id is not valid or check body parameters")
            }
        }catch(Exception e){
            respond ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.stackTrace)
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
            def res = createTransactionsService.getTransactionsById(params.id)
            if(res != null){
                respond res
            }
            else{
                respond (error:"Id is not valid")
            }
        }catch(Exception e){
            respond e.stackTrace
        }
    }

}
