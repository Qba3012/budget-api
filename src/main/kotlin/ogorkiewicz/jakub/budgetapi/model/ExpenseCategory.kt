package ogorkiewicz.jakub.budgetapi.model

import javax.persistence.*

@Entity
class ExpenseCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @field:Column(unique=true) val name: String,
)
