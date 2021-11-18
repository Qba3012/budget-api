package ogorkiewicz.jakub.budgetapi.dto

import java.math.BigDecimal

class AccountDto(
    val id: String,
    val title: String,
    val amount: BigDecimal,
)
