package banking

import banking.dto.CreateTransactionsDto
import banking.dto.CreateTransactionsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

import javax.servlet.http.HttpServletResponse

class AccountTransactionsController {

    AccountTransactionsService accountTransactionsService
    static responseFormats = ['json']

    ResponseEntity<CreateTransactionsResponse> createTransactions(@RequestBody CreateTransactionsDto txn_dto){
        try{
            def res = accountTransactionsService.createTransactions(txn_dto, params.id)
            if(res != null){
                respond res
            }
            else{
                render(status: HttpServletResponse.SC_NOT_FOUND)
            }
        }catch(Exception e){
            respond ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.stackTrace)
        }
    }

    def getAllTransactions(){
        try{
            respond accountTransactionsService.getAllTransactions()
        }catch(Exception e){
            respond e.stackTrace
        }
    }

    def getTransactionsById(){
        try{
            def res = accountTransactionsService.getTransactionsById(params.id)
            if(res != null){
                respond res
            }
            else{
                render(status:HttpServletResponse.SC_NOT_FOUND)
            }
        }catch(Exception e){
            respond e.stackTrace
        }
    }

}
