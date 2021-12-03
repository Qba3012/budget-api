package ogorkiewicz.jakub.budgetapi.business.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [IdValidator::class])
@MustBeDocumented
annotation class UniqueId(
    val message: String = "Id must be unique",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Payload>> = []
)