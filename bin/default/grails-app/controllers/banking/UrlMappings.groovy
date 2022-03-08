package banking

class UrlMappings {

    static mappings = {
//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

        group "/accounts", {
            delete "/delete/$id(.$format)?"(action: 'delete', controller: "accounts")
            get "(.$format)?"(action: 'getAllAccounts', controller: "accounts")
            get "/$id(.$format)?"(action: 'getAccount', controller: "accounts")
            post "(.$format)?"(action: 'createAccount',controller:"accounts")
            put "/update/$id(.$format)?"(action: 'updateAccount', controller: "accounts")
            patch "/patch/$id(.$format)?"(action: 'patch', controller: "accounts")
//            get "/$id/transactions(.$format)?"(action:'getTransactions', controller: 'accounts')
            post "/$id/transactions(.$format)?"(action:'createTransactions', controller: 'accountTransactions')
            get "/$id/transactions(.$format)?"(action:'getTransactionsByAccId', controller: 'accounts')
        }

        group "/transactions",{
            post "/other/$id(.$format)?"(action:'otherAccountTransaction', controller: 'transactions')
            post "/self(.$format)?"(action:'selfAccountTransaction', controller: 'transactions')
            get "(.$format)?"(action:'getAllTransactions', controller: 'accountTransactions')
            get "/$id(.$format)?"(action:'getTransactionsById', controller: 'accountTransactions')
        }

//        "/"(view:"/index")
//        "500"(view:'/error')
//        "404"(view:'/notFound')
    }
}
