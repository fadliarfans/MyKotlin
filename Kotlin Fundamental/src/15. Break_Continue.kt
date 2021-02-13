fun main(){

    print("Ganjil : ")
    for(i in 0..100){
        if(i % 2 == 0) {
            continue
        }
        print(" $i")
    }
    println("")
    print("0-49   : ")
    for(i in 0..100){
        if(i == 50) {
            break
        }
        print(" $i")
    }
}