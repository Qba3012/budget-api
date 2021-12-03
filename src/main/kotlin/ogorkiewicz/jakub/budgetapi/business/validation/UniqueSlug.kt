package ogorkiewicz.jakub.budgetapi.business.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [SlugValidator::class])
@MustBeDocumented
annotation class UniqueSlug(
    val message: String = "Budget slug must be unique",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Payload>> = []
)