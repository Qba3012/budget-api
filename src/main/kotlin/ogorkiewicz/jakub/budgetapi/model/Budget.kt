package ogorkiewicz.jakub.budgetapi.model

import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import javax.persistence.*

@Entity
class Budget(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val slug: String,
    val month: Int,
    val year: Int,
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "budget_id")
    val accounts: List<Account>,
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "budget_id")
    val incomes: List<Income>,
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "budget_id")
    val expenses: List<Expense>,
) {
    constructor(dto: BudgetDto) : this(
        null,
        dto.slug,
        dto.month,
        dto.year,
        dto.accounts.map { item -> Account(item) },
        dto.incomes.map { item -> Income(item) },
        dto.expenses.map { item -> Expense(item) }
    )
}