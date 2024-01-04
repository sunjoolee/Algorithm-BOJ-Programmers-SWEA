class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        
        //행렬 A 크기 m*n
        //행렬 B 크기 n*p
        //A와 B의 곱행렬 크기 m*p
        
        val M = arr1.size //행렬 A의 행의 개수
        val N = arr2.size //행렬 A의 열의 개수 = 행렬 B의 행의 개수
        val P = arr2[0].size //행렬 B의 열의 개수
        
        
        for(i in 0 until M){
            var row = arrayOf<Int>()
            for(j in 0 until P){
                var sum = 0 // A,B의 곱행렬의 (i,j)
                for(k in 0 until N){
                    sum += (arr1[i][k] * arr2[k][j])
                }
                row += sum
            }
            answer += row.toIntArray()
        }
        
        return answer
    }
}