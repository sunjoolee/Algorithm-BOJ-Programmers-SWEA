class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        for(i in 0 .. t.length - p.length){
            var cand = t.substring(i, i+p.length)
            //println(cand)
            //println(cand<=p)
            if(cand <= p) answer ++
        }
        return answer
    }
}