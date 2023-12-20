class Solution {
    fun solution(s: String): String {
        var answer = ""
        
        var isStart = true
        for(ch in s){
            if(ch == ' '){
                answer += " "
                isStart = true
            }
            else{
                answer += if(isStart) ch.toUpperCase() else ch.toLowerCase()
                isStart = false
            }
        }
        return answer
    }
}