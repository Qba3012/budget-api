package ogorkiewicz.jakub.budgetapi.utils

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Service

@Service
class BeanUtil : ApplicationContextAware {

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    companion object {
        lateinit var context: ApplicationContext

        @JvmStatic
        fun <T> getBean(beanClass: Class<T>): T = context.getBean(beanClass)
    }

}