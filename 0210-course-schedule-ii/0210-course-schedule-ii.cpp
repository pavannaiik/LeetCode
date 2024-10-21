class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int>indegree(numCourses);
        vector<vector<int>>adj(numCourses);
        for(auto p: prerequisites){
            adj[p[1]].push_back(p[0]);
            indegree[p[0]]++;
        }
        vector<int>ans;
        queue<int>queue;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.push(i);
            }
        }
        int coursesTaken=0;
        while(!queue.empty()){
            coursesTaken++;
            int node = queue.front();
            ans.push_back(node);
            queue.pop();
            for(int neigh:adj[node]){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    queue.push(neigh);
                }
            }
        }
        return coursesTaken==numCourses?ans:vector<int>();
    }
};