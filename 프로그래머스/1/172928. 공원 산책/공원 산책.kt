class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val parkR = park.size
        val parkC = park[0].length
        
        var curR = -1
        var curC = -1
        //시작 지점 찾기
        for(r in 0 until parkR){
            for(c in 0 until parkC){
                if(park[r][c] == 'S'){
                    curR = r
                    curC = c
                }
            }
        }
        //산책 시작
        for(route in routes){
            val op = route[0]
            val n = route[2].toInt() - '0'.toInt()
            //println("$op $n")
            
            var canMove = true
            //(1) 공원을 벗어나는지 확인
            when(op){
                'N' -> if(curR - n < 0) canMove = false
                'S' -> if(curR + n >= parkR) canMove = false
                'W' -> if(curC - n < 0) canMove = false
                'E' -> if(curC + n >= parkC) canMove = false
                else -> false
            }
            if(!canMove) continue
            
            //(2) 장애물을 만나는지 확인
            when(op){
                'N' -> {
                    for(i in 1..n){
                        if(park[curR - i][curC] == 'X'){
                            canMove = false
                            break
                        }
                    }
                }
                'S' -> {
                    for(i in 1..n){
                        if(park[curR + i][curC] == 'X'){
                            canMove = false
                            break
                        }
                    }
                }
                'W' -> {
                    for(i in 1..n){
                        if(park[curR][curC -i] == 'X'){
                            canMove = false
                            break
                        }
                    }
                }
                'E' -> {
                    for(i in 1..n){
                        if(park[curR][curC + i] == 'X'){
                            canMove = false
                            break
                        }
                    }
                }
                else -> false
            }
            if(!canMove) continue
            
            //이동
            when(op){
                'N' -> curR -= n
                'S' -> curR += n
                'W' -> curC -= n
                'E' -> curC += n
            }
            //println("$curR $curC")
        }
        var answer: IntArray = intArrayOf(curR, curC)
        return answer
    }
}