package ogorkiewicz.jakub.budgetapi.model

import ogorkiewicz.jakub.budgetapi.dto.AccountDto
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Account(
    @Id
    val id: String,
    val title: String,
    val amount: BigDecimal,
) {
    constructor(dto: AccountDto) : this(dto.id, dto.title, dto.amount)
}
