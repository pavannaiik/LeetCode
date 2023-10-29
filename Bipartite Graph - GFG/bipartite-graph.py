class Solution:
	def isBipartite(self, V, adj):
		#code here
		colored = [-1]*V
		for v in range(V):
		    if colored[v-1] == -1:
		        if self.bfs(adj, colored, v):
		            return 0
		return 1
		 
	def bfs(self,adj, colored, vertex):
	    queue =[[vertex,1]]
		while len(queue) > 0:
		    currentVertex = queue.pop()
		    vertexValue = currentVertex[0]
		    for i in adj[vertexValue]:
		        if colored[i-1] == -1:
		            colored[i-1] = 1 - currentVertex[1]
		            queue.append([i,1-currentVertex[1]])
		        elif colored[i-1] == currentVertex[1]:
		            return 1
		return 0
		        
		        
		    


#{ 
 # Driver Code Starts

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		V, E = map(int, input().strip().split())
		adj = [[] for i in range(V)]
		for i in range(E):
			u, v = map(int, input().strip().split())
			adj[u].append(v)
			adj[v].append(u)
		obj = Solution()
		ans = obj.isBipartite(V, adj)
		if(ans):
			print("1")
		else:
			print("0")

# } Driver Code Ends