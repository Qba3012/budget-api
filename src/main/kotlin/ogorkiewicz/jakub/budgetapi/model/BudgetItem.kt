package ogorkiewicz.jakub.budgetapi.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BudgetItem(
    @Id
    val id: String,
    val title: String,
    val amount: BigDecimal,
    val date: LocalDateTime,
)