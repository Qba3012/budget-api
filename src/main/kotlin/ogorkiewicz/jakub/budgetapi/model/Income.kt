package ogorkiewicz.jakub.budgetapi.model

import ogorkiewicz.jakub.budgetapi.dto.IncomeDto
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
class Income(
    id: String,
    title: String,
    amount: BigDecimal,
    date: LocalDateTime,
): BudgetItem(id, title, amount, date){
    constructor(dto: IncomeDto) : this(dto.id, dto.title, dto.amount, dto.date)
}