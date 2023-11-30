class Solution {
    fun solution(s: String): IntArray {
        //크기 26인 null으로 채워진 array
        //alphabets[0] = a가 가장 최근에 나온 인덱스
        //...
        //alphabets[25]= z가 가장 최근에 나온 인덱스
        val alphabets = arrayOfNulls<Int>(26)
        
        var answer: IntArray = intArrayOf()
        for(i in 0 until s.length){
            var ch = s[i]
            
            //처음 나온 알파벳인 경우
            if(alphabets[ch.code-'a'.code] == null) answer += -1
            else answer += (i - alphabets[ch.code-'a'.code]!!)
            
            alphabets[ch.code-'a'.code] = i
        }
        return answer
    }
}