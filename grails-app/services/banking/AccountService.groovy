package banking

import banking.dto.AccountsDto
import grails.gorm.transactions.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import javax.persistence.Id

@Transactional
class AccountService {

    AccountsDto createNewAccount(AccountsDto accounts){
        Accounts acc = new Accounts()
        acc.setAccount_name(accounts.getAccount_name())
        acc.setAccount_number(accounts.getAccount_number())
        acc.setDescription(accounts.getDescription())
        acc.save()
        return accounts
    }

    AccountsDto updateAccount(AccountsDto accounts, Serializable id){
        Accounts acc = Accounts.get(id)
        acc.setAccount_name(accounts.getAccount_name())
        acc.setAccount_number(accounts.getAccount_number())
        acc.setDescription(accounts.getDescription())
        acc.save()
        return accounts
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
