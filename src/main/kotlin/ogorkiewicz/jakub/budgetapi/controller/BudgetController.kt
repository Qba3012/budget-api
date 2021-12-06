package ogorkiewicz.jakub.budgetapi.controller

import ogorkiewicz.jakub.budgetapi.business.BudgetService
import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import ogorkiewicz.jakub.budgetapi.dto.HistoryDto
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

const val BUDGETS_PATH = "/budgets"

@RestController
@RequestMapping(BUDGETS_PATH)
class BudgetController(val budgetService: BudgetService) {

    @PostMapping(consumes = [APPLICATION_JSON_VALUE],produces = [APPLICATION_JSON_VALUE])
    fun addNewBudget(@RequestBody budgetDto: BudgetDto): ResponseEntity<BudgetDto> = ResponseEntity.ok(
        budgetService
            .save
                (budgetDto)
    )

    @GetMapping("/{slug}", produces = [APPLICATION_JSON_VALUE])
    fun getBudgetBySlug(@PathVariable slug: String): ResponseEntity<BudgetDto> {
        val budgetDto = budgetService.findBySlug(slug)
        return if(null == budgetDto) ResponseEntity.notFound().build() else ResponseEntity.ok(budgetDto)
    }

    @GetMapping("/latest", produces = [APPLICATION_JSON_VALUE])
    fun getLatestBudget(): ResponseEntity<BudgetDto> {
        val budgetDto = budgetService.findLatest()
        return if(null == budgetDto) ResponseEntity.notFound().build() else ResponseEntity.ok(budgetDto)
    }

    @GetMapping("/history", produces = [APPLICATION_JSON_VALUE])
    fun getBudgetsHistory(): ResponseEntity<List<HistoryDto>> = ResponseEntity.ok(budgetService.getHistory());

}