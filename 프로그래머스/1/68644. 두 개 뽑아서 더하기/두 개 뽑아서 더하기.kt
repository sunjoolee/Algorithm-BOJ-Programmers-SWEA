class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answerSet = mutableSetOf<Int>()
        for(i in 0 until numbers.size){
            for(j in i+1 until numbers.size){
                val a = numbers[i]+numbers[j]
                answerSet.add(a)
            }
        }
       var answer = answerSet.toList().sorted().toIntArray()
       return answer
    }
}