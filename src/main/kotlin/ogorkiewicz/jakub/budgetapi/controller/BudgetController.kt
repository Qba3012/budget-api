package ogorkiewicz.jakub.budgetapi.controller

import lombok.AllArgsConstructor
import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import ogorkiewicz.jakub.budgetapi.business.BudgetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@AllArgsConstructor
@RequestMapping("/budgets")
class BudgetController(val budgetService: BudgetService) {

    @PostMapping
    fun addNewBudget(@RequestBody budgetDto: BudgetDto): ResponseEntity<BudgetDto> = ResponseEntity.ok(
        budgetService
            .save
                (budgetDto)
    )

}