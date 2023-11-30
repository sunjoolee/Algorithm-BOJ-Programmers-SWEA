class Solution {
    //마트에 a개의 빈 병을 가져가면, b개의 콜라를 준다
    //n: 상빈이가 가지고 있는 빈 병의 개수
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        
        var before = n
        var after = 0
        while(before >= a){
            answer += (before/a) * b 
            
            after = before % a //빈 병을 마트에 가져감
            after += (before/a)*b //새 병을 받아옴
            before = after
        }
        return answer
    }
}