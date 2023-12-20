class Solution {
    val MOD = 1234567
    
    //메모이제이션
    //RES[x]: x칸을 이동하는 방법의 수
    var RES = Array<Long>(2001){-1L}
    
    fun move(n:Int):Long{
        if(n == 0) return 0L //이동할 수 없음
        if(n == 1) return 1L //1칸
        if(n == 2) return 2L //1칸 1칸, 2칸
        
        //이미 계산한 적 있는 경우,
        if(RES[n] != -1L) return RES[n]
        
        //계산하기
        var result = 0L
        //1칸 + (n-1)칸 이동
        result += move(n-1) % MOD
        //2칸 + (n-2)칸 이동
        result += move(n-2) % MOD
        
        RES[n] = result % MOD 
        return RES[n]
    }
    
    fun solution(n: Int): Long {
        var answer: Long = move(n)
        return answer
    }
}