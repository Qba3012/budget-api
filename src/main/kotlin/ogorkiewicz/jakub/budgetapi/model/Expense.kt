package ogorkiewicz.jakub.budgetapi.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Expense(
    id: String,
    title: String,
    amount: BigDecimal,
    date: LocalDateTime,
    @ManyToOne(cascade = [CascadeType.ALL])
    val expenseType: ExpenseType,
    @ManyToOne(cascade = [CascadeType.ALL])
    val expenseCategory: ExpenseCategory
) : BudgetItem(id, title, amount, date)

