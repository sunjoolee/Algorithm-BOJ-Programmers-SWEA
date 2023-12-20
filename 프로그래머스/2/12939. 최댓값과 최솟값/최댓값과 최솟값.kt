import kotlin.math.*

class Solution {
    fun solution(s: String): String {
        
        val sList = s.split(' ').map{it.toInt()}
        var min = sList[0]
        var max = sList[0]
        sList.forEach{
            if(it < min) min = it
            if(it > max) max = it
        }
    
        var answer = min.toString() + " " + max.toString()
        return answer
    }
}