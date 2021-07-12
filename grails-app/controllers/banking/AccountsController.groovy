package banking

import banking.dto.AccountsDto
import banking.dto.AccountsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

class AccountsController {

//    AccountImplService accountImplService
    AccountService accountService
    static responseFormats = ['json']

    ResponseEntity<AccountsResponse> createAccount(@RequestBody AccountsDto accounts){
        try{
//            respond ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(accountService.createNewAccount(accounts))
            respond accountService.createNewAccount(accounts)
        }catch(Exception e){
            println("Exception occurred")
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
            respond accountService.updateAccount(accounts,params.id)
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
            respond accountService.getAccountById(id)
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
            respond accountService.getTransactionsByAccountId(id)
        }catch(Exception e){
            respond ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.stackTrace)
        }
    }

    def getTransactionsByAccId(){
        respond accountService.getTransactionsByAccountId(params.id)
    }

}
