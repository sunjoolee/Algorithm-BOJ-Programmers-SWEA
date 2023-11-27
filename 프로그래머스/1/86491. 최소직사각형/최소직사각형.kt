import kotlin.math.*

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var walletWidth = 0
        var walletHeight = 0
        
        for(card in sizes){
            var width:Int
            var height:Int
            //가로 길이가 세로 길이보다 크거나 같도록 회전
            if(card[0] >= card[1]){
                width = card[0]
                height = card[1]
            }
            else{
                width = card[1]
                height = card[0]
            }
            
            walletWidth = max(walletWidth, width)
            walletHeight = max(walletHeight, height)
        }
        return walletWidth * walletHeight
    }
}