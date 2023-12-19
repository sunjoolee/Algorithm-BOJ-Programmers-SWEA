class Solution {
    //date로 부터 dur(1~100달) 후의 날짜를 나타내는 문자열 반환 
    fun dateAfterDur(date: String, dur:Int):String{
        val dateList = date.split('.')
        var y = dateList[0].toInt()
        var m = dateList[1].toInt()
        var d = dateList[2].toInt()
        
        //모든 달은 28일까지 있다고 가정!
        d += (dur*28 - 1)
        while(d>28){
            d-=28
            m++
        }
        while(m > 12){
            m -= 12
            y++
        }
        
        return y.toString() + "." + m.toString() + "." + d.toString()
    }
    
    //날짜 비교 함수, date1 < date2인 경우 true 반환
    fun dateCompare(date1:String, date2:String):Boolean{
        var dateList1 = date1.split('.')
        var dateList2 = date2.split('.')
        
        val y1 = dateList1[0].toInt()
        val m1 = dateList1[1].toInt()
        val d1 = dateList1[2].toInt()
        
        val y2 = dateList2[0].toInt()
        val m2 = dateList2[1].toInt()
        val d2 = dateList2[2].toInt()
        
        if(y1 < y2) return true
        if(y1 > y2) return false
        
        if(m1 < m2) return true
        if(m1 > m2) return false
        
        return d1 < d2
    }
    
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        //termDuration[X.code - 'A'.code] = 약관 X의 유효기간
        var termDuration = Array<Int>(26){0}
        
        for(term in terms){
            var t = term[0]
            var dur = term.substring(2).toInt()
            termDuration[t.code - 'A'.code] = dur.toInt()
        }
        
        var answer: IntArray = intArrayOf()
        for((i, privacy) in privacies.withIndex()){
            var privacyDate = privacy.substring(0,10)
            var privacyTerm = privacy[11]
            
            val privacyDateAfterDur = dateAfterDur(
                                            privacyDate, 
                                            termDuration[privacyTerm.code - 'A'.code]
                                            )
            
            if(dateCompare(privacyDateAfterDur, today)) answer += (i+1)
            //println("$i : $privacyDateAfterDur , $today")
        }
        return answer
    }
}