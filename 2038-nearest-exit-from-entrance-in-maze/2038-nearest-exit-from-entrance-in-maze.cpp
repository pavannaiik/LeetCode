class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int ans = INT_MAX;
        int n = maze.size();
        int m = maze[0].size();
        vector<pair<int,int>>dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        int startR = entrance[0], startC=entrance[1];
        maze[startR][startC]='+';
        queue<pair<pair<int,int>,int>>queue;
        queue.push({{startR,startC},0});
        while(!queue.empty()){
            int curRow = queue.front().first.first;
            int curCol = queue.front().first.second;
            int curDist = queue.front().second;
            queue.pop();
            for(auto dir:dirs){
                int nextR = curRow+dir.first, nextC = curCol+dir.second;
                if(nextR>=0 && nextR<n && nextC >=0 && nextC <m && maze[nextR][nextC]=='.'){
                    if(nextR==0 || nextR==n-1 ||nextC==0 ||nextC ==m-1){
                        return curDist+1;
                    }
                    maze[nextR][nextC]='+';
                    queue.push({{nextR,nextC},curDist+1});
                }
            }
        }
        return -1;
    }
};