import kotlin.reflect.KProperty

fun main(){
}

class Persegi{
    private var sisi:Int by DelegateNilai()
}

class DelegateNilai{
    private var value:Int = 0
    operator fun getValue(classRef:Any?, property : KProperty<*>):Int{
        return value
    }

    operator fun setValue(classRef: Any?, property: KProperty<*>,newValue:Int){
        value = newValue
    }
}