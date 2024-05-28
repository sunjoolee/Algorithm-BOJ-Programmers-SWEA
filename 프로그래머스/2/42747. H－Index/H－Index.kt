class Solution {
    fun solution(citations: IntArray): Int {
        val sortedCitations = citations.toList().sorted() 
        
        val n = sortedCitations.size 
        var h = sortedCitations.last() 
        while(h >= 0){
            val moreThanHCnt = n - sortedCitations.indexOfFirst{it >= h} 
            val restCnt = n - moreThanHCnt 
            
            if((moreThanHCnt >= h) && (h >= restCnt)) return h
            h--
        }
        return -1 //not reached
    }
}