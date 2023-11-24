class Solution {
    
    fun solution(s: String): String {
        var answer = ""
        
        var w_start = false //단어가 시작되기 전/후 
        var w_index = -1 //단어 인덱스, 단어가 시작되면 0부터 시작
        for(ch in s){
            //공백인 경우: 단어가 시작되기 전 상태
            if(ch == ' '){
                w_start = false
                w_index = -1
                answer += " "
                continue
            }
            //단어 시작 지점인 경우:
            if(w_start == false){
                w_start = true
                w_index = 0
            }
                
            //단어 인덱스 짝수라면 대문자로 변환
            if(w_index % 2 == 0) answer += ch.toUpperCase().toString()
            //단어 인덱스 홀수라면 소문자로 변환
            else answer += ch.toLowerCase().toString()
                
            w_index+=1
        }
        return answer
    }
}