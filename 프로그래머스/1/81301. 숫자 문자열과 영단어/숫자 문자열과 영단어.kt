class Solution {
    fun solution(s: String): Int {
        val mp = mapOf<String,Char>(
            "zero" to '0',
            "one" to '1',
            "two" to '2',
            "three" to '3',
            "four" to '4',
            "five" to '5',
            "six" to '6',
            "seven" to '7',
            "eight" to '8',
            "nine" to '9')
        
        var answer: String = ""
        var number: String = ""
        for(ch in s){
            if('0'<=ch && ch <= '9'){
                answer += ch
                continue
            }
            number += ch
            if(mp.contains(number)){
                answer += mp[number]
                number = ""
            }
        }
        if(mp.contains(number)){
            answer += mp[number]
        }
        
        return answer.toInt()
    }
}