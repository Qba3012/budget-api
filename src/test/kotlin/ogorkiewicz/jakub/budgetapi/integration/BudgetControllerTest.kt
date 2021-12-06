package ogorkiewicz.jakub.budgetapi.integration

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import ogorkiewicz.jakub.budgetapi.controller.BUDGETS_PATH
import ogorkiewicz.jakub.budgetapi.controller.ValidationResponse
import ogorkiewicz.jakub.budgetapi.dto.AccountDto
import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import ogorkiewicz.jakub.budgetapi.dto.HistoryDto
import ogorkiewicz.jakub.budgetapi.dummies.DummyData
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.math.BigDecimal
import java.nio.charset.Charset

@SpringBootTest
@AutoConfigureMockMvc
internal class BudgetControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    private final val blankErrorMessage = "must not be blank"
    private final val invalidYearMessage = "must be greater than or equal to 1900"
    private final val invalidMonthMessage = "must be less than or equal to 12"
    private final val zeroValueMessage = "Amount cannot be zero"

    private final val blankError = ValidationResponse(blankErrorMessage)
    private final val zeroValueError = ValidationResponse(zeroValueMessage)
    private final val invalidYearError = ValidationResponse(invalidYearMessage)
    private final val invalidMonthError = ValidationResponse(invalidMonthMessage)


    @Test
    fun `should add new budget`() {
        //given
        val budgetDto = DummyData.generateBudgetDto()

        //when //then
        createBudget(budgetDto)
    }

    @Test
    fun `should get a budget by existing slug`() {
        // given
        val budgetDto = DummyData.generateBudgetDto()
        createBudget(budgetDto)

        //when //then
        mockMvc.get("$BUDGETS_PATH/${budgetDto.slug}") {
            accept = APPLICATION_JSON
        }.andExpect {
            content { contentType(APPLICATION_JSON) }
            content { match(compareBudgetResponse(budgetDto)) }
        }

    }

    @Test
    fun `should get latest budget if exists`() {
        // given
        val budgetDto = DummyData.generateBudgetDto()
        createBudget(budgetDto)

        //when //then
        mockMvc.get("$BUDGETS_PATH/latest") {
            accept = APPLICATION_JSON
        }.andExpect {
            content { contentType(APPLICATION_JSON) }
            content { match(compareBudgetResponse(budgetDto)) }
        }

    }

    @Test
    fun `should get budget history`() {
        // given
        val budgetDto = DummyData.generateBudgetDto()
        createBudget(budgetDto)

        //when //then
        mockMvc.get("$BUDGETS_PATH/history") {
            accept = APPLICATION_JSON
        }.andExpect {
            content { contentType(APPLICATION_JSON) }
            content {
                match { mvcResult ->
                    val results =
                        mapper.readValue(
                            mvcResult.response.getContentAsString(Charset.defaultCharset()),
                            object : TypeReference<List<HistoryDto>>() {}
                        )
                    val history = results.find { history -> history.year == budgetDto.year }
                    assertThat(history).isNotNull
                    val month = history?.months?.find { month -> month.month == budgetDto.month && month.slug ==
                            budgetDto.slug }
                    assertThat(month).isNotNull
                }
            }
        }

    }

    @Test
    fun `should not add new budget with wrong general data`() {
        //given
        val invalidBudgetDto = BudgetDto(
            null,
            "",
            13,
            999, listOf(DummyData.generateAccountDto()), listOf
                (DummyData.generateExpenseDto()), listOf(DummyData.generateIncomeDto())
        )

        //when //then
        doInvalidRequestTest(invalidBudgetDto, listOf(blankError, invalidMonthError, invalidYearError))
    }

    @Test
    fun `should not add new budget with wrong account data`() {
        //given
        val invalidAccountDto = AccountDto("", "", BigDecimal.ZERO)

        val invalidBudgetDto = BudgetDto(
            null,
            DummyData.BUDGET_SLUG,
            DummyData.BUDGET_MONTH,
            DummyData.BUDGET_YEAR, listOf(invalidAccountDto), listOf
                (DummyData.generateExpenseDto()), listOf(DummyData.generateIncomeDto())
        )

        //when //then
        doInvalidRequestTest(invalidBudgetDto, listOf(blankError, blankError, zeroValueError))
    }

    fun createBudget(budgetDto: BudgetDto) {
        mockMvc.post(BUDGETS_PATH) {
            content = mapper.writeValueAsString(budgetDto)
            contentType = APPLICATION_JSON
            accept = APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(APPLICATION_JSON) }
                content { match(compareBudgetResponse(budgetDto)) }
            }
    }

    fun doInvalidRequestTest(invalidBudgetDto: BudgetDto, expectedResults: List<ValidationResponse>) {
        mockMvc.post(BUDGETS_PATH) {
            content = mapper.writeValueAsString(invalidBudgetDto)
            contentType = APPLICATION_JSON
            accept = APPLICATION_JSON
        }
            .andExpect {
                status { isBadRequest() }
                content { contentType(APPLICATION_JSON) }
                content { match(compareErrorResponse(expectedResults)) }
            }
    }

    fun compareBudgetResponse(expectedResult: BudgetDto) = ResultMatcher { mvcResult ->
        val result =
            mapper.readValue(mvcResult.response.getContentAsString(Charset.defaultCharset()), BudgetDto::class.java)
        assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedResult)
        assertThat(result.id).isGreaterThan(0)
    }

    fun compareErrorResponse(expectedResults: List<ValidationResponse>) = ResultMatcher { mvcResult ->
        val results =
            mapper.readValue(mvcResult.response.getContentAsString(Charset.defaultCharset()),
                object : TypeReference<List<ValidationResponse>>() {})

        assertThat(results).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedResults)
    }

}