package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.business.AccountRepository
import ogorkiewicz.jakub.budgetapi.repository.jpa.JPAAccountRepository
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImpl(val jpaAccountRepository: JPAAccountRepository) : AccountRepository {
    override fun checkIfExistById(id: String) = jpaAccountRepository.existsById(id);
}