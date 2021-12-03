package ogorkiewicz.jakub.budgetapi.dto

import ogorkiewicz.jakub.budgetapi.business.validation.UniqueId
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank

@UniqueId
class IncomeDto(
    @field:NotBlank val id: String,
    @field:NotBlank val title: String,
    val amount: BigDecimal,
    val date: LocalDateTime,
) {
    @AssertTrue(message = "Amount cannot be zero")
    private fun isAmountNotZero() = this.amount != BigDecimal.ZERO;
}