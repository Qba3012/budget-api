package ogorkiewicz.jakub.budgetapi.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Account(
    @Id
    val id: String,
    val title: String,
    val amount: BigDecimal,
)
