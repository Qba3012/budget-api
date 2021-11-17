package ogorkiewicz.jakub.budgetapi.model

import ogorkiewicz.jakub.budgetapi.dto.ExpenseDto
import ogorkiewicz.jakub.budgetapi.business.ExpenseCategoryRepository
import ogorkiewicz.jakub.budgetapi.business.ExpenseTypeRepository
import ogorkiewicz.jakub.budgetapi.utils.BeanUtil
import org.springframework.beans.factory.annotation.Configurable
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
@Configurable(preConstruction = true)
class Expense : BudgetItem {
    @ManyToOne(cascade = [CascadeType.ALL])
    val expenseType: ExpenseType

    @ManyToOne(cascade = [CascadeType.ALL])
    val expenseCategory: ExpenseCategory

    constructor(
        id: String, title: String, amount: BigDecimal, date: LocalDateTime, expenseType: ExpenseType,
        expenseCategory: ExpenseCategory
    ) : super(id, title, amount, date) {
        this.expenseCategory = expenseCategory
        this.expenseType = expenseType
    }

    constructor(dto: ExpenseDto) : super(dto.id, dto.title, dto.amount, dto.date) {
        val expenseCategoryRepository = BeanUtil.getBean(ExpenseCategoryRepository::class.java)
        val expenseTypeRepository = BeanUtil.getBean(ExpenseTypeRepository::class.java)
        val category = expenseCategoryRepository.getByName(dto.expenseCategory);
        val type = expenseTypeRepository.getByName(dto.expenseType);
        this.expenseCategory = category ?: ExpenseCategory(null,dto.expenseCategory);
        this.expenseType = type ?: ExpenseType(null, dto.expenseType);
    }

}
