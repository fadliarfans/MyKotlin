fun main(){
    val battlefield = Battlefield()
    var loopingstat = true
    while(loopingstat){
        print("""
        |Battle Programming
        |1. Add Hero
        |2. Attack Hero
        |3. Status Hero
        |4. Exit
        |Select :
    """.trimIndent())

        val result = readLine()

        when(result.toString().toLowerCase().trim()){
            "1" -> {
                print("\nHero Name :")
                val name = readLine()
                print("Hero Base Attack :")
                val attack :Int? = readLine()?.toInt()
                print("Hero HP :")
                val hp:Int? = readLine()?.toInt()
                val hero = Hero(name, attack , hp)
                Battlefield.listhero.add(hero)
            }
            "2" -> {
                print("\nAttacker Name : ")
                val attackername = readLine()
                print("Defender Name : ")
                val defendername = readLine()
                battlefield.attack(attackername.toString() , defendername.toString())
            }
            "3" -> {
                println("\nStatus Hero\n ${Battlefield.listhero}")

            }
            "4" -> {
                loopingstat = false
            }
            else -> {
                println("select right answer")}

        }
    }

}