import java.util.*

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        //clothesTypeCount[의상 종류] = 의상 종류에 해당하는 의상의 수
        var clothesTypeCount = mutableMapOf<String, Int>()
        
        for(cl in clothes){
            val name = cl[0]
            val type = cl[1]
            if(clothesTypeCount.containsKey(type)){
                clothesTypeCount[type] = clothesTypeCount[type]!! + 1 
            }
            else{
                clothesTypeCount[type] = 1
            }
        }
        
        var answer = 1
        for((type, count) in clothesTypeCount){
            answer *= (count+1)
        }
        answer-- //아무것도 입지 않은 경우
        return answer
    }
}