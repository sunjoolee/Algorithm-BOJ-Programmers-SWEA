class Solution {
    //수포자1이 찍은 답
    fun solve1(size:Int):Array<Int>{
        var solveArray1 = arrayOf<Int>()
        for(i in 0 until size){
            solveArray1 += (i%5 + 1)
        }
        return solveArray1
    }
    
    //수포자2가 찍은 답
    fun solve2(size:Int):Array<Int>{
        var solveArray2 = arrayOf<Int>()
        var k = arrayOf(1,3,4,5)
        var kIndex = 0
        for(i in 0 until size){
            if(i%2 == 0) solveArray2 += 2
            else solveArray2 += k[kIndex++ % 4]
        }
        return solveArray2
    }
    
    //수포자3이 찍은 답
    fun solve3(size:Int):Array<Int>{
        var solveArray3 = arrayOf<Int>()
        var k = arrayOf(3,3,1,1,2,2,4,4,5,5)
        for(i in 0 until size){
            solveArray3 += k[i%10]
        }
        return solveArray3
    }
    
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        
        val solveArray1 = solve1(answers.size)
        val solveArray2 = solve2(answers.size)
        val solveArray3 = solve3(answers.size)
        
        var cnt1 = 0 //수포자 1이 맞춘 답의 수
        var cnt2 = 0 //수포자 2가 맞춘 답의 수
        var cnt3 = 0 //수포자 3이 맞춘 답의 수
        for(i in 0 until answers.size){
            if(answers[i] == solveArray1[i]) cnt1++
            if(answers[i] == solveArray2[i]) cnt2++
            if(answers[i] == solveArray3[i]) cnt3++
        }
        
        if(cnt1 >= cnt2 && cnt1 >= cnt3) answer += 1
        if(cnt2 >= cnt1 && cnt2 >= cnt3) answer += 2
        if(cnt3 >= cnt1 && cnt3 >= cnt2) answer += 3
        
        return answer
    }
}