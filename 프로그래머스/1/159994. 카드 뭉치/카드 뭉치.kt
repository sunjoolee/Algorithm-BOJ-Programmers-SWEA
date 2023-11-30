class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = ""
        
        //cards1의 인덱스
        //cards1의 끝까지 사용한 경우, index1 = -1
        var index1 = 0 
        //cards2의 인덱스
        //cards2의 끝까지 사용한 경우, index2 = -1
        var index2 = 0 
        
        //cards1과 cards2에는 서로 다른 단어만 존재!
        for(word in goal){
            if((index1 != -1) &&(cards1[index1] == word)){
                index1++
                if(index1 >= cards1.size) index1 = -1
                continue
            }
            if((index2 != -1) &&(cards2[index2] == word)){
                index2++
                if(index2 >= cards2.size) index2 = -1
                continue
            }
            return "No"
        }
        return "Yes"
    }
}