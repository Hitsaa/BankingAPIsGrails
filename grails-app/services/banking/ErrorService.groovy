package banking

import banking.dto.ErrorResponse
import grails.gorm.transactions.Transactional
import org.springframework.validation.Errors
import org.springframework.validation.FieldError

@Transactional
class ErrorService {
    def setErrorResponse(Errors errors){

        List<ErrorResponse> res = new ArrayList<ErrorResponse>()

        errors.each {Errors it ->
            it.fieldErrors.each { FieldError f ->
                ErrorResponse response = new ErrorResponse()
                response.setField(f.field)
                response.setMessage(f.defaultMessage)
                res.add(response)
            }
        }
        return res
    }
}
