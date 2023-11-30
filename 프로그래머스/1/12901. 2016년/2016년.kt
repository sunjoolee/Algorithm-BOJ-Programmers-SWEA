class Solution {
    fun solution(a: Int, b: Int): String {
        
        //(1)
        //daysOfMonth[i]: i번째 달에 포함된 날의 수 (윤년)
        val daysOfMonth = arrayOf(31,29,31,30,31,30,31,31,30,31,30,31)
        
        //dist: 1월 1일부터 지난 날의 수
        var dist = 0
        for(m in 1 .. a-1){
            dist += daysOfMonth[m-1]
        }
        dist += (b-1)
        
        //(2)
        //dayFromFri[i]: 금요일과 i만큼 떨어져있는 요일
        val dayFromFri = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")
        
        var answer = dayFromFri[dist%7]
        return answer
    }
}