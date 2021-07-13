package banking

import banking.dto.AccountsDto
import banking.dto.AccountsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

import javax.servlet.http.HttpServletResponse

class AccountsController {

//    AccountImplService accountImplService
    AccountService accountService
    static responseFormats = ['json']

    def createAccount(@RequestBody AccountsDto accounts){
        try{
//            respond ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(accountService.createNewAccount(accounts))
            def res = accountService.createNewAccount(accounts)
            if(res != null)
                respond res
            else
                render(status:HttpServletResponse.SC_BAD_REQUEST)
        }catch(Exception e){
            respond ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.stackTrace)
        }
    }

    ResponseEntity<AccountsResponse> updateAccount(@RequestBody AccountsDto accounts){
        try{
//            respond ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(accountService.updateAccount(accounts,params.id))
            def res = accountService.updateAccount(accounts,params.id)
            if(res!=null){
                respond res
            }
            else{
                render(status:HttpServletResponse.SC_NOT_FOUND)
            }
        }catch(Exception e){
            respond ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.stackTrace)
        }
    }

    ResponseEntity<List<Accounts>> getAllAccounts(){
        try{
//            respond ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(accountService.list(params))
            respond accountService.list(params)

        }catch(Exception e){
            respond ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.stackTrace)
        }
    }

    ResponseEntity<Accounts> getAccount(Long id){
        try{
//            respond ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(accountService.getAccountById(id))
            def res = accountService.getAccountById(id)
            if(res !=null){
                respond res
            }
            else{
                render(status:HttpServletResponse.SC_NOT_FOUND)
            }
        }catch(Exception e){
            respond ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.stackTrace)
        }
    }

    ResponseEntity<Set<Transactions>> getTransactions(Long id){
        try{
//            respond ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(accountService.getTransactionsByAccountId(id))
            def res = accountService.getTransactionsByAccountId(id)
            if(res != null){
                respond res
            }
            else{
                render(status:HttpServletResponse.SC_NOT_FOUND)
            }
        }catch(Exception e){
            respond ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.stackTrace)
        }
    }

    def getTransactionsByAccId(){
        try {
            def res = accountService.getTransactionsByAccountId(params.id)
            if(res !=null){
                respond res
            }
            else{
                render(status:HttpServletResponse.SC_NOT_FOUND)
            }

        }catch(Exception e){
            respond ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.stackTrace)
        }
    }

}
