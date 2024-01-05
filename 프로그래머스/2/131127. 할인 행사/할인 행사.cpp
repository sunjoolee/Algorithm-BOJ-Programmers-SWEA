#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;

bool isSignUpAppropriate(vector<int> wantNumber, vector<int> discountNumber){
    /*
    cout<<"wantNumber: ";
    for(int i = 0; i<wantNumber.size(); ++i){
        cout<<wantNumber[i]<<" ";
    }
    cout<<"\n";
    
    cout<<"discountNumber: ";
    for(int i = 0; i<wantNumber.size(); ++i){
        cout<<discountNumber[i]<<" ";
    }
    cout<<"\n";
    */
    
    for(int i = 0; i<wantNumber.size(); ++i){
        if(wantNumber[i] > discountNumber[i]) return false;
    }
    return true;
}

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    //wantIndex<원하는 제품, 원하는 제품의 Vector에서의 인덱스>
    map<string, int> wantIndex = map<string, int>();
    
    //wantNumber[원하는 제품의 인덱스] = 원하는 제품의 수량
    vector<int> wantNumber = vector<int>();
    
    //discountNumber[원하는 제품의 인덱스] = 원하는 제품을 할인받을 수 있는 수량
    vector<int> discountNumber = vector<int>();
    
    for(int i = 0; i<want.size(); ++i){
        wantIndex[want[i]] = i;
        wantNumber.push_back(number[i]);
        discountNumber.push_back(0);
    }
    
    int answer = 0;
    for(int i = 0; i<discount.size(); ++i){
        //(1) 10일 전 할인한 제품 제외하기
        if(i>=10){
            //할인하던 제품이 원하던 제품인 경우
            if(wantIndex.find(discount[i-10]) != wantIndex.end()){
                int discountIndex = wantIndex[discount[i-10]];
                discountNumber[discountIndex] -= 1; 
            }
        }
        
        
        //(2) 오늘 할인하는 제품 추가하기
        //할인하는 제품이 원하는 제품인 경우
        if(wantIndex.find(discount[i]) != wantIndex.end()){
            int discountIndex = wantIndex[discount[i]];
            discountNumber[discountIndex] += 1; 
        }
        
        //(3) 회원가입하기 적합한 날인지 확인하기
        if(isSignUpAppropriate(wantNumber, discountNumber)){
            answer++;
        }
    }
    return answer;
}