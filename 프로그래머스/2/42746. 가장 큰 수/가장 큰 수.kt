import kotlin.math.*

class Solution {
    
    val comparator = object: Comparator<String> {    
        override fun compare(str1:String, str2:String):Int{
            if(str1 == str2) return 0
            return (str1+str2).compareTo(str2+str1)
        }
    }
    
    fun solution(numbers: IntArray):String{
        val answer = numbers
        .map{ it.toString() }
        .sortedWith(comparator)
        .reversed()
        .joinToString(separator="")    
        
        if(answer[0] == '0') return "0"
        return answer
    }
}
