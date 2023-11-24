class Solution {
    fun solution(n: Int): Int {
        var str = "" //n 3진법 표현의 반전
        var N = n
        while(N > 0){
            str += N%3
            N = N/3
        }
        print(str)
        
        var answer: Int = 0 //str 10진법으로 표현
        var digit = 1
        for(i in str.length-1 downTo 0){
            answer += (str[i].toInt() - '0'.toInt()) * digit
            digit *= 3
        }
        return answer
    }
}