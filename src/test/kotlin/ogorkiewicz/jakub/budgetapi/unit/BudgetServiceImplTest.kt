package ogorkiewicz.jakub.budgetapi.unit

import ogorkiewicz.jakub.budgetapi.business.BudgetRepository
import ogorkiewicz.jakub.budgetapi.business.BudgetServiceImpl
import ogorkiewicz.jakub.budgetapi.dto.ModelMapper
import ogorkiewicz.jakub.budgetapi.dummies.DummyData
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class BudgetServiceImplTest {

    @InjectMocks
    private lateinit var budgetService: BudgetServiceImpl

    @Mock
    private lateinit var budgetRepository: BudgetRepository

    @Mock
    private lateinit var modelMapper: ModelMapper

    @Test
    fun shouldSaveBudget() {
         // given
        given(modelMapper.toDto(DummyData.BUDGET)).willReturn(DummyData.BUDGET_DTO)
        given(modelMapper.toEntity(DummyData.BUDGET_DTO)).willReturn(DummyData.BUDGET)
        given(budgetRepository.save(DummyData.BUDGET)).willReturn(DummyData.BUDGET)

        // when
        val newBudgetDto = budgetService.save(DummyData.BUDGET_DTO)

        // then
        assertThat(newBudgetDto).usingRecursiveComparison().isEqualTo(DummyData.BUDGET_DTO)
    }
}