package banking

import banking.dto.AccountsDto
import banking.dto.AccountsResponse
import grails.gorm.transactions.Transactional
import org.springframework.validation.Errors

@Transactional
class AccountService {

    AccountsResponse createNewAccount(AccountsDto accounts){
        if(getAccountByAcctNumber(accounts.account_number)!=null){   // account already exist
            return null
        }
        Accounts acc = new Accounts()
        acc = setAccountsDataInDB(acc,accounts)
        AccountsResponse response = new AccountsResponse()
        response = setResponse(response, acc)
        return response
    }

    AccountsResponse updateAccount(AccountsDto accountsDto, Serializable id){
        Accounts acc = Accounts.get(id)
        acc = setAccountsDataInDB(acc,accountsDto)
        AccountsResponse response = new AccountsResponse()
        response = setResponse(response, acc)
        return response
    }

    Accounts setAccountsDataInDB(Accounts accounts, AccountsDto dto){
        accounts.setAccount_name(dto.getAccount_name())
        accounts.setAccount_number(dto.getAccount_number())
        accounts.setDescription(dto.getDescription())
        accounts.save()
        return accounts
    }

    AccountsResponse setResponse(AccountsResponse res, Accounts accounts){
        res.setDescription(accounts.description)
        res.setAccount_number(accounts.account_number)
        res.setAccount_name(accounts.account_name)
        res.setId(accounts.id)
        return res
    }

    List<Accounts> list(Map args){
        return Accounts.findAll()
    }

    Accounts getAccountById(Serializable id){
        return Accounts.get(id)
    }

    Accounts getAccountByAcctNumber(String acct_number){
        Accounts acc = Accounts.findByAccount_number(acct_number)
        return acc
    }

    def getTransactionsByAccountId(Serializable id){
        return Accounts.get(id).getTransactions()
    }

}
