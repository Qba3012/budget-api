package ogorkiewicz.jakub.budgetapi.controller

import ogorkiewicz.jakub.budgetapi.business.BudgetService
import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/budgets")
class BudgetController(val budgetService: BudgetService) {

    @PostMapping
    fun addNewBudget(@RequestBody budgetDto: BudgetDto): ResponseEntity<BudgetDto> = ResponseEntity.ok(
        budgetService
            .save
                (budgetDto)
    )

    @GetMapping("/{slug}")
    fun getBudgetBySlug(@PathVariable slug: String): ResponseEntity<BudgetDto> {
        val budgetDto = budgetService.findBySlug(slug)
        return if(null == budgetDto) ResponseEntity.notFound().build() else ResponseEntity.ok(budgetDto)
    }

}