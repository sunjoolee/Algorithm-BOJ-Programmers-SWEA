import kotlin.math.*

class Solution {
    // fees: 기본 시간, 기본 요금, 단위 시간, 단위 요금 
    // records: 시각(HH:MM), 차량 번호, 내역(입차/출차)
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        // <차량 번호, 입차 시간>
        val inTimeMap:MutableMap<String, Int> = mutableMapOf()
        // <차량 번호, 누적 주차시간>
        val parkTimeMap:MutableMap<String, Int> = mutableMapOf()
        // <차량 번호, 주차 요금>
        val feeMap:MutableMap<String, Int> = mutableMapOf()
        
        // (1) 누적 주차시간 계산
        // (1-1) 출차 기록이 있는 차의 누적 주차시간 계산
        records.map{it.split(" ")}.forEach{ record ->
            val time = record[0]
            val carNum = record[1]
            val history = record[2]
            
            if(history == "IN"){
                inTimeMap[carNum] = timeToInt(time)
            }
            else{
                val inTime = inTimeMap[carNum]!!
                val outTime = timeToInt(time)
                val curParkTime = outTime - inTime
                
                var prevParkTime = 0
                if(parkTimeMap.containsKey(carNum)){
                    prevParkTime = parkTimeMap[carNum]!!
                    parkTimeMap.remove(carNum)
                }
                parkTimeMap[carNum] = prevParkTime + curParkTime
                inTimeMap.remove(carNum)
            }
        }
        // (1-2) 출차 기록이 없는 차의 누적 주차시간 계산
        inTimeMap.toList().forEach{ 
            val carNum = it.first
            val inTime = it.second
            val outTime = timeToInt("23:59")
            val curParkTime = outTime - inTime
                
            var prevParkTime = 0
            if(parkTimeMap.containsKey(carNum)){
                prevParkTime = parkTimeMap[carNum]!!
                parkTimeMap.remove(carNum)
            }
            parkTimeMap[carNum] = prevParkTime + curParkTime
        }
        
        // (2) 주차 요금 계산
        parkTimeMap.toList().forEach{
            val carNum = it.first
            val totalParkTime = it.second
            
            feeMap[carNum] = calcFee(totalParkTime, fees)
        }
        
        // (3) 차량번호 작은 순으로 주차 요금 출력
        var answer = feeMap.toList().sortedBy{it.first}.map{it.second}
        return answer.toIntArray()
    }
    
    private fun timeToInt(time:String):Int{
        val h = time.substring(0,2).toInt()
        val m = time.substring(3).toInt()
        return h*60 + m
    }
    
    private fun calcFee(parkTime:Int, fees:IntArray):Int{
        val basicTime = fees[0].toInt()
        val basicFee = fees[1].toDouble()
        val unitTime = fees[2].toInt()
        val unitFee = fees[3].toDouble()
        
        var fee: Double = basicFee
        if(parkTime > basicTime)
            fee += ceil((parkTime-basicTime).toDouble()/unitTime) * unitFee
        
        println("parkTime: ${parkTime}, fee: ${fee}")
        return fee.toInt()
    }
}