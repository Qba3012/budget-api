package ogorkiewicz.jakub.budgetapi.controller

import ogorkiewicz.jakub.budgetapi.business.BudgetService
import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/budgets")
class BudgetController(val budgetService: BudgetService) {

    @PostMapping
    fun addNewBudget(@RequestBody budgetDto: BudgetDto): ResponseEntity<BudgetDto> = ResponseEntity.ok(
        budgetService
            .save
                (budgetDto)
    )

}