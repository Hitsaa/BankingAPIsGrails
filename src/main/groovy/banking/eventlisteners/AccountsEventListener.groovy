package banking.eventlisteners

import banking.AccountService
import banking.Accounts
import grails.events.annotation.gorm.Listener
import groovy.transform.CompileStatic
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEvent
import org.grails.datastore.mapping.engine.event.PreInsertEvent
import org.grails.datastore.mapping.engine.event.PreUpdateEvent
import org.hibernate.event.spi.PostInsertEvent
import org.springframework.beans.factory.annotation.Autowired

@CompileStatic
class AccountsEventListener {
//    @Autowired
//    AccountService accountService
//
//    @Listener(Accounts)
//    void onPreInsertEvent(PreInsertEvent event) {
//        updateAccountBalanceForEvent(event)
//    }
//
//    @Listener(Accounts)
//    void onPostInsertEvent(PostInsertEvent event){
//        updateAccountBalanceForEvent(event as AbstractPersistenceEvent)
//    }
//
//    @Listener(Accounts)
//    void onPreUpdateEvent(PreUpdateEvent event) {
//        updateAccountBalanceForEvent(event)
//    }
//
//    private void updateAccountBalanceForEvent(AbstractPersistenceEvent event) {
//        if (event.entityObject instanceof Accounts) {
//            Accounts acc = event.entityObject as Accounts
//            if (acc.account_balance==null && (event instanceof PostInsertEvent)) {
//                event.getEntityAccess().setProperty('account_balance', BigDecimal.ZERO)
//            }
//        }
//    }
}
