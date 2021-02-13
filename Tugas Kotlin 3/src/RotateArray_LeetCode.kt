
fun main(){
    val arr = intArrayOf(1,2,3,4,5,6,7)
    val banyakrotate = 3
    Solution().rotate(arr,banyakrotate)
}

class Solution{
    fun rotate(nums: IntArray, k: Int) :Unit{
        val lastindex = nums.size - 1
        var temporary:Int
        for (i in 1..k) {
            for (j in 0 until lastindex) {
                temporary = nums[lastindex - j]
                nums[lastindex - j] = nums[lastindex - j - 1]
                nums[lastindex - j - 1] = temporary
            }
        }
        print("[")
        for (i in 0..lastindex){
            print(nums[i])
            if(i!=lastindex)
                print(",")
        }
        print("]")
    }

}