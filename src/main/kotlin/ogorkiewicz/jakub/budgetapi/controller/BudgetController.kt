package ogorkiewicz.jakub.budgetapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/budgets")
class BudgetController {

    @GetMapping
    fun sayHello(): String = "Hello"

}