import kotlin.math.*

class Solution {
    //체육복을 빌릴 수 있는 가장 많은 학생의 수
    fun getMaxBorrow(start:Int, state: Array<Int>):Int{
        if(start >= state.size) return 0
            
        var result = 0
        for(i in start until state.size){
            if(state[i] != 0) continue
            
            //(1)체육복을 빌리지 않는 경우
            result = max(result, 0 + getMaxBorrow(i + 1, state))
            
            //(2)자신의 앞에 있는 학생에게 체육복을 빌린 경우
            if((i > 0) &&(state[i] == 0)&&(state[i-1] == 2)){
                state[i-1] = 1
                state[i] =1
                result = max(result, 1 + getMaxBorrow(i + 1, state))
                state[i-1] = 2
                state[i] = 0
            }
            
            //(3)자신의 뒤에 있는 학생에게 체육복을 빌린 경우
            if((i < state.size - 1) &&(state[i] == 0)&&(state[i+1] == 2)){
                state[i] =1
                state[i+1] = 1
                result = max(result, 1 + getMaxBorrow(i + 1, state))
                state[i] = 0
                state[i+1] = 2
            }
            
            break
        }
        return result
    }
    
    
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        //전체 학생의 체육복 보유 현황
        //일반 학생의 경우 1, 도난당한 경우 0, 여벌이 있는 경우 2
        var state = Array(n, {it -> 1})
        for(l in lost) state[l-1]--
        for(r in reserve) state[r-1]++
        
        //체육복을 빌리지 않아도 되는 학생의 수
        var okay = 0
        state.forEach{if(it != 0) okay++}
        
        //체육복을 빌릴 수 있는 가장 많은 학생의 수
        var maxBorrow = getMaxBorrow(0, state)
        
        val answer = okay + maxBorrow
        return answer
    }
}