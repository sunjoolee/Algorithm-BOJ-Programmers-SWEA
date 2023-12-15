#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    map<char, int> scoreMap = map<char, int>();
    scoreMap['R'] = 0; scoreMap['T'] = 0;
    scoreMap['C'] = 0; scoreMap['F'] = 0;
    scoreMap['J'] = 0; scoreMap['M'] = 0;
    scoreMap['A'] = 0; scoreMap['N'] = 0;
    
    for(int i = 0; i<survey.size(); ++i){
        char id1 = survey[i][0];
        char id2 = survey[i][1];
        switch(choices[i]){
            case 1: scoreMap[id1] += 3; break;
            case 2: scoreMap[id1] += 2; break;
            case 3: scoreMap[id1] += 1; break;
            case 4: break;
            case 5: scoreMap[id2] += 1; break;
            case 6: scoreMap[id2] += 2; break;
            case 7: scoreMap[id2] += 3; break;
        }
    }
    
    string answer = "";
    if(scoreMap['R'] > scoreMap['T']) answer += 'R';
    else if(scoreMap['R'] < scoreMap['T']) answer += 'T';
    else answer += 'R';
    
    if(scoreMap['C'] > scoreMap['F']) answer += 'C';
    else if(scoreMap['C'] < scoreMap['F']) answer += 'F';
    else answer += 'C';
    
    if(scoreMap['J'] > scoreMap['M']) answer += 'J';
    else if(scoreMap['J'] < scoreMap['M']) answer += 'M';
    else answer += 'J';
    
    if(scoreMap['A'] > scoreMap['N']) answer += 'A';
    else if(scoreMap['A'] < scoreMap['N']) answer += 'N';
    else answer += 'A';
        
    return answer;
}