class Solution {
    fun solution(n: Int): Int {
        val MOD = 1234567
        
        var N = 2
        var f1 = 0
        var f2 = 1
        var f3 = 1
        while(N < n){
            f1 = f2 % MOD
            f2 = f3 % MOD
            f3 = (f1 + f2) % MOD
            N++
        }
        return f3
    }
}