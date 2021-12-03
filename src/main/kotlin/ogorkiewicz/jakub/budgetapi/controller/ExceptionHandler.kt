package ogorkiewicz.jakub.budgetapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.validation.ConstraintViolationException

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun handleException(exception: ConstraintViolationException): ResponseEntity<Set<ValidationResponse>> {
        return ResponseEntity.badRequest().body(
            exception.constraintViolations.map { constraintViolation -> ValidationResponse(constraintViolation) }
                .toSet()
        )
    }
}