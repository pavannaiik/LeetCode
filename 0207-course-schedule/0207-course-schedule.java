class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>>adjList = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] prereq: prerequisites){
            adjList.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int completed=0;
        while(!queue.isEmpty()){
            int c = queue.poll();
            if(completed==numCourses) return true;
            for(int course:adjList.get(c)){
                inDegree[course]--;
                if(inDegree[course]==0){
                    queue.add(course);
                }
            }
            completed++;
        }
        return completed==numCourses;
    }
}