import kotlin.math.round

fun main(){
    println(nbMonths(2000, 8000, 1000, 1.5))
    println(nbMonths(12000, 8000, 1000, 1.5))

}

fun nbMonths(
        startPriceOld: Int,
        startPriceNew: Int,
        savingperMonth: Int,
        percentLossByMonth: Double
): Pair<Int, Int> {
    var myCarPrice:Double = startPriceOld.toDouble()
    var newCarPrice:Double = startPriceNew.toDouble()
    var percent = percentLossByMonth
    var total = myCarPrice
    var count = 1
    while (total < newCarPrice){
        if(count%2==0)
            percent += 0.5
        total = 0.0
        total += (savingperMonth * count)
        myCarPrice =(100-percent) * myCarPrice/ 100
        newCarPrice = (100-percent) * newCarPrice/ 100
        total += myCarPrice
        count++
    }
    val hasil = round((total-newCarPrice)).toInt()
    return Pair(--count,hasil)
}
