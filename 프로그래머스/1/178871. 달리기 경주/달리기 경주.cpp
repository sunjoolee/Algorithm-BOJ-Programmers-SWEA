#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    //playerPosMap[선수 이름] = 선수의 등수
    map<string, int> playerPosMap = map<string, int>();
    //posPlayerVec[등수] = 선수 이름
    vector<string> posPlayerVec = vector<string>();
    
    for(int i = 0; i<players.size(); ++i){
        playerPosMap[players[i]] = i;
        posPlayerVec.push_back(players[i]);
    }
    
    for(int i = 0; i<callings.size(); ++i){
        //이름 불린 선수
        string player1 = callings[i];
        //이름 불린 선수의 등수
        int pos = playerPosMap[player1];
        //이름 불린 선수 바로 앞 선수
        string player2 = posPlayerVec[pos-1];
        
        //player1과 player2 등수 바꾸기
        posPlayerVec[pos-1] = player1;
        posPlayerVec[pos] = player2;
        
        playerPosMap[player1] = pos-1;
        playerPosMap[player2] = pos;
        
    }
    
    return posPlayerVec;
}