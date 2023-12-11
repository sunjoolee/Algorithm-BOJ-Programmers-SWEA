class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        //resultMap[X] = X보다 index만큼의 뒤의 알파벳
        var resultMap = mutableMapOf<Char, Char>()
        
        for(i in 'a'.code .. 'z'.code){
            var result = i
            var curIndex = 0
            while(curIndex < index){
                //다음 알파벳으로 넘어가기
                if(result == 'z'.code) result = 'a'.code    
                else result++
                
                //건너뛰기 제외 알파벳인 경우
                if(skip.contains(result.toChar())) continue
                curIndex++
                
            }
            resultMap[i.toChar()] = result.toChar()
        }
        
        var answer: String = ""
        for(ch in s){
            answer += resultMap[ch]
        }
        return answer
    }
}