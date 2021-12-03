package ogorkiewicz.jakub.budgetapi.business.validation

import ogorkiewicz.jakub.budgetapi.business.BudgetRepository
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class SlugValidator(private val budgetRepository: BudgetRepository): ConstraintValidator<UniqueSlug, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return if(value ==  null) false else !budgetRepository.checkIfExistBySlug(value);
    }
}