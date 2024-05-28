class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>) = 
        commands.map{ it ->
            val i = it[0]-1
            val j = it[1]-1
            val k= it[2]-1
            array.slice(i..j).toList().sorted().get(k)
        }.toIntArray()
}