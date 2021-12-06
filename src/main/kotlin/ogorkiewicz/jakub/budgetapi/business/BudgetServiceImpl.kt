package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import ogorkiewicz.jakub.budgetapi.dto.HistoryDto
import ogorkiewicz.jakub.budgetapi.dto.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Validated
@Service
class BudgetServiceImpl(val budgetRepository: BudgetRepository, val modelMapper: ModelMapper) :
    BudgetService {

    override fun save(@Valid budgetDto: BudgetDto): BudgetDto {
        val newEntity = budgetRepository.save(modelMapper.toEntity(budgetDto))
        return modelMapper.toDto(newEntity)
    }

    override fun findBySlug(slug: String): BudgetDto? {
        val entity = budgetRepository.findBySlug(slug)
        return if (null == entity) null else modelMapper.toDto(entity)
    }

    override fun findLatest(): BudgetDto? {
        val entity = budgetRepository.findLatest()
        return if (null == entity) null else modelMapper.toDto(entity)
    }

    override fun getHistory(): List<HistoryDto>? {
        val budgets = budgetRepository.findAll();
        return modelMapper.toHistoryDto(budgets)
    }
}
