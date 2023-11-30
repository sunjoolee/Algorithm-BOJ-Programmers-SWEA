import kotlin.math.*

class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        
        //score 내림차순 정렬
        var sortedScore = score.sorted().reversed()
        
        var index = 0
        while(index + m - 1 < score.size){
            answer += (m * sortedScore[index + m - 1])
            index += m
        }
        
        return answer
    }
}