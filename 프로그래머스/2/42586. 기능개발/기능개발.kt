class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        
        val N = progresses.size //기능의 개수
        var released = -1 //가장 최근에 배포된 기능의 인덱스
        while(released != N-1){
            //작업 진도 나가기
            for(i in released+1 until N){
                progresses[i] += speeds[i]
            }
            //작업 배포하기
            var count = 0 //현재 배포될 기능의 수
            for(i in released+1 until N){
                if(progresses[i] >= 100){
                    count++
                    released = i
                }
                else break
            }
            if(count != 0) answer += count
        }
        
        return answer
    }
}