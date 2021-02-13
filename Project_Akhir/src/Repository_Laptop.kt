import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RepositoryLaptop {
    val gson = Gson()
    val mutableListType = object : TypeToken<MutableList<Laptop>>() {}.type!!
    var laptopList: MutableList<Laptop> = gson.fromJson(FileReader("src/Data_Laptop"), mutableListType)

    fun addLaptop(){
        var temporary = mutableListOf<String>()
        print("Masukan Merek Laptop          : ")
        temporary.add(readLine()?:"NoName")
        print("Masukan Tipe Laptop           : ")
        temporary.add(readLine()?:"NoName")
        print("Masukan Tipe Processor Laptop : ")
        temporary.add(readLine()?:"NoName")
        print("Masukan Ukuran Ram Laptop     : ")
        temporary.add(readLine()?:"0")
        print("Masukan Ukuran Rom Laptop     : ")
        temporary.add(readLine()?:"0")
        print("Tipe VGA Laptop               : ")
        temporary.add(readLine()?:"NoName")
        print("Masukan stok Laptop           : ")
        temporary.add(readLine()?:"0")
        print("Masukan Harga Laptop          : ")
        temporary.add(readLine()?:"0")
        laptopList.add(Laptop(
                temporary[0],
                temporary[1],
                temporary[2],
                temporary[3].toInt(),
                temporary[4].toInt(),
                temporary[5],
                temporary[6].toInt(),
                temporary[7].toInt()
        ))
        temporary.clear()
    }




}