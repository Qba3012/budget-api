package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import ogorkiewicz.jakub.budgetapi.dto.ModelMapper
import org.springframework.stereotype.Service

@Service
class BudgetServiceImpl(val budgetRepository: BudgetRepository, val modelMapper: ModelMapper): BudgetService {
    override fun save(budgetDto: BudgetDto): BudgetDto {
        val newEntity = budgetRepository.save(modelMapper.toEntity(budgetDto))
        return modelMapper.toDto(newEntity)
    }
}
