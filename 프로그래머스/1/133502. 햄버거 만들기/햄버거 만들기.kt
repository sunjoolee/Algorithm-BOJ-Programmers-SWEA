import java.util.*

class Solution {
    fun solution(ingredient: IntArray): Int {
        //1: 빵, 2: 야채, 3: 고기, 4: 빵
        val st = Stack<Int>()
    
        var answer: Int = 0
        for(ing in ingredient){
            st.push(ing)
            
            //빵 야채 고기 빵 확인
            if(st.size >= 4){
                val peek1 = st.peek()
                st.pop()
                val peek2 = st.peek()
                st.pop()
                val peek3 = st.peek()
                st.pop()
                val peek4 = st.peek()
                st.pop()
                
                if((peek4 == 1) && (peek3 == 2) && (peek2 == 3) && (peek1 == 1)) answer++;
                else{
                    //원상복구
                    st.push(peek4)
                    st.push(peek3)
                    st.push(peek2)
                    st.push(peek1)
                }
            }
        }
        return answer
    }
}