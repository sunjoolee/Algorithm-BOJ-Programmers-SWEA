import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0 //실행되는 순서
        
        //priorityCnt[우선순위] = 해당 우선순위를 갖는 작업 수
        var priorityCnt = Array<Int>(10){it -> 0}
        for(priority in priorities){
            priorityCnt[priority] += 1
        }
        
        //실행 완료된 프로세스의 인덱스
        val completed = mutableSetOf<Int>()
        
        while(completed.size != priorities.size){
            for(i in 0 until priorities.size){
                //이미 실행된 프로세스의 인덱스라면 무시하기
                if(completed.contains(i)) continue
                
                //현재 프로세스보다 우선순위가 높은 작업이 있는지 확인
                val curPriority = priorities[i]
                var canRun = true
                for(j in curPriority+1 .. 9){
                    if(priorityCnt[j] > 0){
                        canRun = false
                        break
                    }
                }
                
                //프로세스 실행하기
                if(canRun){
                    completed.add(i)
                    priorityCnt[curPriority] -= 1
                    answer++
                    //println("location: $i, answer: $answer")
                    
                    if(i == location) return answer
                }
            }
        }
        return answer
    }
}