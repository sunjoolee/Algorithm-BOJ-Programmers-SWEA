import java.util.*

class Solution {
    //Char 확장함수, 여는 괄호일 경우 true 반환
    fun Char.isOpen():Boolean{
        if((this == '(')||(this == '{')||(this == '['))return true
        return false
    }
    
    fun isCorrect(s:String):Boolean{
        var stack = Stack<Char>()
        for(ch in s){
            //여는 괄호일 경우
            if(ch.isOpen()) stack.push(ch)
            //닫는 괄호일 경우
            else{
                if(stack.isNotEmpty()){
                    val peekCh = stack.peek()
                    if((ch == ')')  && (peekCh == '(')) stack.pop()
                    else if((ch == '}')  && (peekCh == '{')) stack.pop()
                    else if((ch == ']')  && (peekCh == '[')) stack.pop()
                    else return false;
                }
                else return false;
            }
        }
        if(stack.isNotEmpty()) return false
        return true;
    }
    
    fun solution(s: String): Int {
        var answer: Int = 0
        
        for(i in 0 .. s.length-1){
            val newS = s.substring(i, s.length)+s.substring(0, i)
            if(isCorrect(newS)) answer++
        }
        return answer
    }
}