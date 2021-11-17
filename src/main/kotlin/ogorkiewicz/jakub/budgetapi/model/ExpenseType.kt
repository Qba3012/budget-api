package ogorkiewicz.jakub.budgetapi.model

import javax.persistence.*

@Entity
class ExpenseType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @field:Column(unique=true)
    val name: String,
)