class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        for(ch in s){
            //공백
            if (ch == ' '){
                answer += ' '
                continue
            }
            
            var code = ch.code //char -> ascii code
            var newCode = code + n //n 만큼 알파벳 밀기
            
            //소문자인 경우
            if('a'.code <= code && code <= 'z'.code){
                if(newCode > 'z'.code) newCode -= 26
            }
            //대문자인 경우
            else if('A'.code <= code && code <= 'Z'.code){
                if(newCode > 'Z'.code) newCode -= 26
            }
            
            answer += newCode.toChar() //asciicode -> char
        }
        return answer
    }
}