package ogorkiewicz.jakub.budgetapi.unit

import ogorkiewicz.jakub.budgetapi.business.ExpenseCategoryRepository
import ogorkiewicz.jakub.budgetapi.business.ExpenseTypeRepository
import ogorkiewicz.jakub.budgetapi.dto.ModelMapper
import ogorkiewicz.jakub.budgetapi.dummies.DummyData
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class ModelMapperTest{

    @InjectMocks
    private lateinit var modelMapper: ModelMapper

    @Mock
    private lateinit var expenseTypeRepository: ExpenseTypeRepository

    @Mock
    private lateinit var expenseCategoryRepository: ExpenseCategoryRepository

    @Test
    fun shouldConvertToDto() {
        // given
        // when
        val budgetDto = modelMapper.toDto(DummyData.BUDGET)

        // then
        assertThat(budgetDto).usingRecursiveComparison().isEqualTo(DummyData.BUDGET_DTO)
    }

    @Test
    fun shouldConvertToEntity() {
        // given
        BDDMockito.given(expenseCategoryRepository.getByName(ArgumentMatchers.anyString())).willReturn(DummyData.EXPENSE_CATEGORY)
        BDDMockito.given(expenseTypeRepository.getByName(ArgumentMatchers.anyString())).willReturn(DummyData.EXPENSE_TYPE)

        // when
        val budget = modelMapper.toEntity(DummyData.BUDGET_DTO)

        // then
        assertThat(budget).usingRecursiveComparison().ignoringFields("id").isEqualTo(DummyData.BUDGET)
        assertThat(budget.id).isNull()
    }

}