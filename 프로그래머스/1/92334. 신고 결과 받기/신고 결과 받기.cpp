#include <string>
#include <vector>
#include <map>
#include <set>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    int N = id_list.size();
    
    //idCountMap[아이디] = 해당 아이디가 신고당한 횟수
    map<string, int> idCountMap = map<string, int>();
    
    //isReportMap[아이디] = 해당 아이디가 신고한 아이디들 집합
    map<string, set<string>> idReportMap = map<string, set<string>>();
    
    for(int i = 0; i<N; ++i){
        string id = id_list[i];
        
        idCountMap[id] = 0;
        idReportMap[id] = set<string>();
    }
    
    for(int i = 0; i<report.size(); ++i){
        string id1 = ""; //신고자
        string id2 = ""; //신고당한자
        
        //띄어쓰기 찾아서 report[i] 문자열 둘로 나누기
        for(int j = 0; j<report[i].length(); ++j){
            if(report[i][j] == ' '){
                id1 = report[i].substr(0,j);
                id2 = report[i].substr(j+1);
                break;
            }
        }
        
        //id1이 id2를 신고한 적이 없는 경우만 신고 가능!
        if(idReportMap[id1].find(id2) == idReportMap[id1].end()){
            idReportMap[id1].insert(id2);
            idCountMap[id2] += 1;   
        }
    }
    
    
    vector<int> answer = vector<int>(N);
    
    for(int i = 0; i<N; ++i){
        string id2 = id_list[i]; //신고당한자
        
        if(idCountMap[id2] >= k){
            for(int j = 0; j<N; ++j){
                if(i==j) continue;
                string id1 = id_list[j]; //신고한자
                
                if(idReportMap[id1].find(id2) != idReportMap[id1].end()) answer[j] += 1;
            }
        }
    }
    return answer;
}