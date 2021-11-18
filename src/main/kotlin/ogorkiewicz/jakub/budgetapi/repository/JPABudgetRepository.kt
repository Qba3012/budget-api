package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.model.Budget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JPABudgetRepository : JpaRepository<Budget, Long > {
    fun findBySlug(slug: String): Budget?
}