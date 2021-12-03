package ogorkiewicz.jakub.budgetapi.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
class Income(
    id: String,
    title: String,
    amount: BigDecimal,
    date: LocalDateTime,
) : BudgetItem(id, title, amount, date)