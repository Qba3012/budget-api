package ogorkiewicz.jakub.budgetapi.repository.jpa

import ogorkiewicz.jakub.budgetapi.model.ExpenseCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JPAExpenseCategoryRepository : JpaRepository<ExpenseCategory,Long>{

    fun findByName(name: String): ExpenseCategory?
}