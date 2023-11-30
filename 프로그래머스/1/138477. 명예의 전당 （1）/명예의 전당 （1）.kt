class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        //topK: 상위 K 점수 오름차순으로 저장
        var topK = mutableListOf<Int>()
        for(sc in score){
            if(topK.size < k) topK += sc
            else if(topK[0] < sc) topK[0] = sc
            
            topK.sort()
            answer += topK[0]
        }
        
        return answer
    }
}