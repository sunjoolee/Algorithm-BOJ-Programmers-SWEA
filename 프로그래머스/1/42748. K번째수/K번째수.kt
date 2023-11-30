class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        for(cmd in commands){
            val i = cmd[0]-1
            val j = cmd[1]-1
            val k = cmd[2]-1
            
            val subArray = array.copyOfRange(i,j+1).sorted()
            answer += subArray[k]
        }
        return answer
    }
}