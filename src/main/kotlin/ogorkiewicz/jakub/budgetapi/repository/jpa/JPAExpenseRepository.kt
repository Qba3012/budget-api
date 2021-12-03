package ogorkiewicz.jakub.budgetapi.repository.jpa

import ogorkiewicz.jakub.budgetapi.model.Expense
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JPAExpenseRepository:JpaRepository<Expense, String> {
}