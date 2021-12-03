package ogorkiewicz.jakub.budgetapi.model

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
)