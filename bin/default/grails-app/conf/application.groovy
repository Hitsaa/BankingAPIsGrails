grails.plugin.springsecurity.rest.token.storage.useJwt = true
grails.plugin.springsecurity.rest.token.storage.jwt.useSignedJwt = true
grails.plugin.springsecurity.rest.token.storage.jwt.secret = 'qrD6h8K6S9503Q06Y6Rfk21TErImPYqa'
grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 90000

//grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.User'
//grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.UserRole'
//grails.plugin.springsecurity.authority.className = 'com.Role'
//grails.plugin.springsecurity.logout.postOnly=false
//grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/'


grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/login/**',       access: ['permitAll']],
        [pattern: '/logout',         access: ['permitAll']],
        [pattern: '/logout/**',      access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**',      filters: 'none'],
        [pattern: '/**/js/**',       filters: 'none'],
        [pattern: '/**/css/**',      filters: 'none'],
        [pattern: '/**/images/**',   filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**',             filters: 'JOINED_FILTERS'],
        //Stateless chain
        [
                pattern: '/api/**',
                filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],

        //Traditional, stateful chain
        [
                pattern: '/**',
                filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
        ]
]

