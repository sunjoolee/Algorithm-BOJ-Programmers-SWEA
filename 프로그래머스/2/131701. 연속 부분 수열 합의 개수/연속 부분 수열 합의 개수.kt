import java.util.*

class Solution {
    fun solution(elements: IntArray): Int {
        //elements의 원형 수열을 나타낸 array
        var elementsCircle = arrayOf<Int>()
        for(e in elements) elementsCircle += e
        for(e in elements) elementsCircle += e
         
        //연속 부분 수열의 합을 담은 set
        val sumNum = mutableSetOf<Int>()
        
        var sum = 0 //길이가 elements.size인 연속 부분 수열의 합
        for(e in elements) sum += e
        sumNum.add(sum)
        
        for(len in 1 until elements.size){
            for(start in 0 until elements.size){
                var sum = 0 //길이가 len인 연속 부분 수열의 합
                
                sum += elementsCircle[start]
                for(next in start+1 until start+len) sum += elementsCircle[next]
                
                sumNum.add(sum)
            }
        }

        var answer: Int = sumNum.size
        return answer
    }
}