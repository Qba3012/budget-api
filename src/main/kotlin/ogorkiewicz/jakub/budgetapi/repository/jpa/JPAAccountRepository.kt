package ogorkiewicz.jakub.budgetapi.repository.jpa

import ogorkiewicz.jakub.budgetapi.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JPAAccountRepository: JpaRepository<Account, String> {
}