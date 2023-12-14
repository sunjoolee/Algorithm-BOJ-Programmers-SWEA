import kotlin.math.*

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var minLx = 100
        var minLy = 100
        var maxRx = -100
        var maxRy = -100
        
        for(y in 0 until wallpaper.size){
            for(x in 0 until wallpaper[y].length){
                if(wallpaper[y][x] == '#'){
                    minLx = min(minLx, x)
                    minLy = min(minLy, y)
                    maxRx = max(maxRx, x+1)
                    maxRy = max(maxRy, y+1)
                }
            }
        }
        
        return intArrayOf( minLy,minLx, maxRy, maxRx)
    }
}