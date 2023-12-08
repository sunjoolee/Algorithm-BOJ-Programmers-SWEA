import kotlin.math.*

class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        
        //minPress[X.code - 'A'.code]: X를 입력하기 위해 키를 눌러야하는 횟수의 최솟값
        var minPress = Array(26, {it -> 200})
        for(kmap in keymap){
            for(i in 0 until kmap.length){
                val k = kmap[i]
                minPress[k.code - 'A'.code] = min(minPress[k.code - 'A'.code], i+1)
            }
        }
        
        var answer: IntArray = intArrayOf()
        for(t in targets){
            var pressSum = 0
            for(i in 0 until t.length){
                val k = t[i]
                if(minPress[k.code - 'A'.code] == 200){
                    pressSum = -1
                    break
                }
                pressSum +=  minPress[k.code - 'A'.code]
            }
            answer += pressSum
        }
        return answer
    }
}