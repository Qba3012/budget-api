package ogorkiewicz.jakub.budgetapi.controller

import javax.validation.ConstraintViolation

class ValidationResponse(val message: String) {
    constructor(constraintViolation: ConstraintViolation<*>) : this(constraintViolation.message)
}