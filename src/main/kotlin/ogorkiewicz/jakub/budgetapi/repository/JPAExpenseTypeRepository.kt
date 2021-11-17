package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.model.ExpenseType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JPAExpenseTypeRepository: JpaRepository<ExpenseType,Long> {
    fun findByName(name: String): ExpenseType?
}