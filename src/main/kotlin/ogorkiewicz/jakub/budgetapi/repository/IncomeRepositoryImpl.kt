package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.business.IncomeRepository
import ogorkiewicz.jakub.budgetapi.repository.jpa.JPAIncomeRepository
import org.springframework.stereotype.Repository

@Repository
class IncomeRepositoryImpl(val jpaIncomeRepository: JPAIncomeRepository) : IncomeRepository {
    override fun checkIfExistsById(id: String) = jpaIncomeRepository.existsById(id)
}
