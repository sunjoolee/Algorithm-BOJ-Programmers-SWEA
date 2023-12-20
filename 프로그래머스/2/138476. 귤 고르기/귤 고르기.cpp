#include <string>
#include <vector>
#include <map>
#include <algorithm>
//#include <iostream>

using namespace std;

int solution(int k, vector<int> tangerine) {
    
    //sizeMap[x]: 크기가 x인 귤의 개수
    map<int, int> sizeMap = map<int, int>();
    
    for(int i = 0; i<tangerine.size(); ++i){
        int t = tangerine[i];
        if(sizeMap.find(t) == sizeMap.end()) sizeMap[t] = 1;
        else sizeMap[t] += 1;
    }
    
    //sizeCnt: 같은 크기인 귤의 개수
    vector<int> sizeCnt = vector<int>();
    for(auto it = sizeMap.begin(); it != sizeMap.end(); ++it){
        sizeCnt.push_back(it->second);
    }
    
    //sizeCnt 내림차순 정렬
    sort(sizeCnt.begin(), sizeCnt.end());
    reverse(sizeCnt.begin(), sizeCnt.end());
    
    //for(int i = 0; i < sizeCnt.size(); ++i){
    //    cout << sizeCnt[i] << " ";
    //}
    
    int answer = 0; //귤 크기의 개수
    int totalCnt = 0; //담은 귤의 개수
    for(int i = 0; i < sizeCnt.size(); ++i){
        if(totalCnt >= k) break;
        
        totalCnt += sizeCnt[i];
        answer++;
    }
    return answer;
}