class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>>adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] arr: prerequisites){
            adjList.get(arr[1]).add(arr[0]);
            inDegree[arr[0]]++;
        }
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer>ans= new ArrayList<>();
        while(!queue.isEmpty()){
            int curElement = queue.poll();
            List<Integer>curList = adjList.get(curElement);
            for(int i=0;i<curList.size();i++){
                inDegree[curList.get(i)]--;
                if(inDegree[curList.get(i)]==0){
                    queue.add(curList.get(i));
                }
            }
            ans.add(curElement);
        }
        if(ans.size()==numCourses)
        return ans.stream().mapToInt(Integer::intValue).toArray();
        else return new int[0];
    }
}