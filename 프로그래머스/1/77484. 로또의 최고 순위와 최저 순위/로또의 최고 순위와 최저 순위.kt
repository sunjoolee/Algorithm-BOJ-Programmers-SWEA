class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        var zeros = 0 //0으로 표기한 숫자의 수
        var correct = 0 //당첨 번호와 일치하는 숫자의 수
        for(n in lottos){
            if(n == 0) zeros++
            else if(win_nums.contains(n)) correct++
        }
        
        //최고 순위: zeros + correct
        answer += when(zeros + correct){
            6-> 1
            5-> 2
            4-> 3
            3-> 4 
            2-> 5
            else -> 6
        } 
        //최저 순위: correct
        answer += when(correct){
            6-> 1
            5-> 2
            4-> 3
            3-> 4 
            2-> 5
            else -> 6
        }
        return answer
    }
}