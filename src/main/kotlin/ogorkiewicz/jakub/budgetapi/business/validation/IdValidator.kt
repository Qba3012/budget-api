package ogorkiewicz.jakub.budgetapi.business.validation

import ogorkiewicz.jakub.budgetapi.business.AccountRepository
import ogorkiewicz.jakub.budgetapi.business.ExpenseRepository
import ogorkiewicz.jakub.budgetapi.business.IncomeRepository
import ogorkiewicz.jakub.budgetapi.dto.AccountDto
import ogorkiewicz.jakub.budgetapi.dto.ExpenseDto
import ogorkiewicz.jakub.budgetapi.dto.IncomeDto
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class IdValidator(
    private val expenseRepository: ExpenseRepository,
    private val accountRepository: AccountRepository,
    private val incomeRepository: IncomeRepository,
) : ConstraintValidator<UniqueId, Any> {

    override fun isValid(obj: Any?, context: ConstraintValidatorContext?): Boolean {
        if (obj is AccountDto) {
            return !accountRepository.checkIfExistById(obj.id)
        }
        if (obj is IncomeDto) {
            return !incomeRepository.checkIfExistsById(obj.id)
        }
        if (obj is ExpenseDto) {
            return !expenseRepository.checkIfExistById(obj.id)
        }
        return false;
    }
}