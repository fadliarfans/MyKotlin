fun main(){
    print(sqInRect(5,3))
    print(sqInRect(5,5))
}

fun sqInRect(lng:Int, wdth:Int):List<Int>? {
    var a = lng
    var b = wdth
    val list = mutableListOf<Int>()
    if(a!=b){
        while(a!=0 && b!=0) {
            if (a > b) {
                a -= b
                list.add(b)

            } else {
                b -= a
                list.add(a)
            }
        }
    }
    return if(list.count()==0){
        null
    }else{
        list
    }
}