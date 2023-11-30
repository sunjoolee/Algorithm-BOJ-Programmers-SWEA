import kotlin.math.*

class Solution {
    //발음할 수 있으면 1, 없으면 0 반환
    fun pronounce(babbling:String, before:String):Int{
        if(babbling == "") return 1
        if(babbling.length < 2) return 0
        
        var result = 0
        if(babbling.length >= 2){
            if(before != "ye" && babbling.substring(0,2) == "ye")
                result = max(result, pronounce(babbling.substring(2), "ye"))
            if(before != "ma" && babbling.substring(0,2) == "ma")
                result = max(result, pronounce(babbling.substring(2), "ma"))
        }
        if(babbling.length >= 3){
            if(before != "aya" && babbling.substring(0,3) == "aya")
                result = max(result, pronounce(babbling.substring(3), "aya"))
            if(before != "woo" && babbling.substring(0,3) == "woo")
                result = max(result, pronounce(babbling.substring(3), "woo"))
        }
        return result
    }
    
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        
        for(word in babbling){
            if(pronounce(word, "") == 1) answer++
        }
        return answer
    }
}