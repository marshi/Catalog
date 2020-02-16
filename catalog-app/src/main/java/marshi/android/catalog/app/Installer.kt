package marshi.android.catalog.app

import android.view.View
import kotlin.reflect.KClass

class Installer {
    companion object {
        fun install(list: KClass<out View>) {
            println(list)
        }
    }
}