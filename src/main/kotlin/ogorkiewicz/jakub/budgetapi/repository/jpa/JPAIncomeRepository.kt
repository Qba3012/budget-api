package ogorkiewicz.jakub.budgetapi.repository.jpa

import ogorkiewicz.jakub.budgetapi.model.Income
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JPAIncomeRepository:JpaRepository<Income, String> {
}