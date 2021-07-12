package banking

import banking.dto.AccountsDto
import banking.dto.AccountsResponse
import grails.gorm.transactions.Transactional

@Transactional
class AccountService {

    AccountsResponse createNewAccount(AccountsDto accounts){
        if(getAccountByAcctNumber(accounts.accountNumber)!=null){   // account already exist
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
        if(acc == null){
            return null
        }
        acc = setAccountsDataInDB(acc,accountsDto)
        AccountsResponse response = new AccountsResponse()
        response = setResponse(response, acc)
        return response
    }

    Accounts setAccountsDataInDB(Accounts accounts, AccountsDto dto){
        accounts.setAccount_name(dto.getAccountName())
        accounts.setAccount_number(dto.getAccountNumber())
        accounts.setDescription(dto.getDescription())
        accounts.save()
        return accounts
    }

    AccountsResponse setResponse(AccountsResponse res, Accounts accounts){
        res.setDescription(accounts.description)
        res.setAccountNumber(accounts.account_number)
        res.setAccountName(accounts.account_name)
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
//        return Accounts.get(id).getTransactions()
        Accounts acc = Accounts.get(id)
        if(acc == null){
            return null
        }
        return acc.getTxns()
    }

}
