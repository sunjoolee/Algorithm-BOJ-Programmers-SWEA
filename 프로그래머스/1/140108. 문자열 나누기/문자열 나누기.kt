class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var x = '0'
        var xCount = 0 //글자 x가 나온 횟수
        var yCount = 0 //x가 아닌 다른 글자가 나온 횟수
        for(i in 0 until s.length){
            //첫 글자 읽기
            if(xCount == 0){
                x = s[i]
                xCount++
                continue
            }
            //문자열 왼쪽에서 오른쪽으로 읽어나가기
            if(s[i]==x) xCount++
            else yCount++
            //문자열 분리하기
            if(xCount == yCount){
                xCount = 0
                yCount = 0
                answer++ 
            }
        }
        //두 횟숙 ㅏ다른 상태에서 더 읽을 글자가 없는 경우
        if((xCount != 0) || (yCount != 0))answer++ //문자열 분리
        return answer
    }
}