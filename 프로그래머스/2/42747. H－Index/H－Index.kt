import kotlin.math.*
import java.util.*

class Solution {
    fun solution(citations: IntArray): Int {
        
        var answer = 0
        
        val maxH = citations.toList().maxOrNull() ?: 1000
        val minH = 0
        for(h in maxH downTo minH){
            //h번 이상 인용된 논문의 수
            var hCnt = citations.toList().filter{it >= h}.size
            
            if(hCnt >= h){
                answer = h
                break
            }
        }
        return answer
    }
}