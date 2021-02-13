fun main(){

    loopa@ for (i in 1..10){
        loopb@ for (j in 1..10){
            if (j<5){
                println(j)
            }
            else if(j>5){
                break@loopb
            }
        }
    }

}

