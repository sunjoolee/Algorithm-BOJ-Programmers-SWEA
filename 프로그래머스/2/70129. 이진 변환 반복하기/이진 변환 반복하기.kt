class Solution {
    
    fun removeZero(str:String):Pair<String, Int>{
        var newStr = "" 
        var zeroCnt = 0
        for(i in str){
            if(i == '0') zeroCnt++
            else newStr += i
        }
        return Pair(newStr, zeroCnt)
    }
    
    fun binaryString(num:Int):String{
        var binary = ""
        var n = num
        while(n != 1){
            binary += (n%2).toString()
            n /= 2
        }
        binary += "1"
        return binary.reversed()
    }
    
    fun solution(s: String): IntArray {
        
        var str = s
        var convertCnt = 0 //이진 변환 횟수
        var totalZeroCnt = 0 //총 제거된 0의 수
        
        while(str != "1"){
            convertCnt++

            //1. 모든 0 제거하기
            var(newStr, zeroCnt) = removeZero(str)
            str = newStr
            totalZeroCnt += zeroCnt
            
            //2. 길이를 2진법으로 표현한 문자열
            str = binaryString(str.length)
        }
        
        
        var answer: IntArray = intArrayOf(convertCnt, totalZeroCnt)
        return answer
    }
}