fun main(){
    println(2.sliceNullable)

    val a:Int? = 20
    println(a.slice3)
}

val Int?.sliceNullable:Int get() = this?.div(2) ?:0

val Int?.slice3:Int get() = if(this==null) 0 else this.div(2)




