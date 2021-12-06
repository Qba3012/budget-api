package ogorkiewicz.jakub.budgetapi.unit

import ogorkiewicz.jakub.budgetapi.business.BudgetRepository
import ogorkiewicz.jakub.budgetapi.business.BudgetServiceImpl
import ogorkiewicz.jakub.budgetapi.dto.HistoryDto
import ogorkiewicz.jakub.budgetapi.dto.ModelMapper
import ogorkiewicz.jakub.budgetapi.dto.MonthDto
import ogorkiewicz.jakub.budgetapi.dummies.DummyData
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verifyNoInteractions
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.inOrder
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

    @Test
    fun shouldGetBudgetBySlug() {
        // given
        given(budgetRepository.findBySlug(DummyData.BUDGET_SLUG)).willReturn(DummyData.BUDGET)
        given(modelMapper.toDto(DummyData.BUDGET)).willReturn(DummyData.BUDGET_DTO)

        // when
        val budgetDto = budgetService.findBySlug(DummyData.BUDGET_SLUG)

        // then
        assertThat(budgetDto).usingRecursiveComparison().isEqualTo(DummyData.BUDGET_DTO)
    }

    @Test
    fun shouldGetLatestBudget() {
        // given
        given(budgetRepository.findLatest()).willReturn(DummyData.BUDGET)
        given(modelMapper.toDto(DummyData.BUDGET)).willReturn(DummyData.BUDGET_DTO)

        // when
        val budgetDto = budgetService.findLatest()

        // then
        assertThat(budgetDto).usingRecursiveComparison().isEqualTo(DummyData.BUDGET_DTO)
    }

    @Test
    fun shouldGetBudgetsHistory() {
        // given
        val historyDto = HistoryDto(DummyData.BUDGET_YEAR,
            mutableListOf(MonthDto(DummyData.BUDGET_SLUG, DummyData.BUDGET_MONTH)))
        given(budgetRepository.findAll()).willReturn(listOf(DummyData.BUDGET))
        given(modelMapper.toHistoryDto(listOf(DummyData.BUDGET))).willReturn(listOf(historyDto))

        // when
        val historyResult = budgetService.getHistory()

        // then
        assertThat(historyResult).usingRecursiveComparison().isEqualTo(listOf(historyDto));
    }

    @Test
    fun shouldNotFindBudgetIfSlugDoesNotExist() {
        // given
        given(budgetRepository.findBySlug(DummyData.BUDGET_SLUG)).willReturn(null)

        // when
        val budgetDto = budgetService.findBySlug(DummyData.BUDGET_SLUG)

        // then
        val inOrder = inOrder(budgetRepository, modelMapper)

        inOrder.verify(budgetRepository).findBySlug(DummyData.BUDGET_SLUG)
        verifyNoInteractions(modelMapper)
        assertThat(budgetDto).isNull()
    }
}