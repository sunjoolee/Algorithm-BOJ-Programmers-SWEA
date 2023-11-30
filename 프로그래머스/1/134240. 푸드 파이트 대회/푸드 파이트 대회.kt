class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""
        
        for(i in 0 until food.size){
            for(j in 0 until food[i]/2){
                answer += (i + '0'.code).toChar()
            }
        }
        
        var answerReversed = answer.reversed()
    
        return answer + "0" + answerReversed
    }
}