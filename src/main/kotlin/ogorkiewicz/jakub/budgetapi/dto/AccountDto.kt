package ogorkiewicz.jakub.budgetapi.dto

import ogorkiewicz.jakub.budgetapi.model.Account
import java.math.BigDecimal

class AccountDto(
    val id: String,
    val title: String,
    val amount: BigDecimal,
) {
    constructor(account: Account) : this(account.id, account.title, account.amount)
}
