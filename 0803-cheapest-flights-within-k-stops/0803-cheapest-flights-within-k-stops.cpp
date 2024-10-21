class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        //distance from source to all other
        vector<int>dist(n,INT_MAX);
        dist[src]=0;
        //run only K=1 times since we want shortest distance in K hops
        for(int i=0;i<=k;i++){
            //create a copy of dist vector
            vector<int>temp(dist);
            // Iterate over all flights
            for (auto& flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];  // u = source, v = destination, w = cost
                
                // If the current distance to 'u' is not INT_MAX, update distance to 'v'
                if (dist[u] != INT_MAX) {
                    temp[v] = min(temp[v], dist[u] + w);
                }
            }
            dist=temp;
        }
        return dist[dst]==INT_MAX?-1:dist[dst];
    }
};