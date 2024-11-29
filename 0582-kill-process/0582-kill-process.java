class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer>ans = new ArrayList<>();
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<pid.size();i++){
            if(ppid.get(i)>0){
                if(!map.containsKey(ppid.get(i))){
                map.put(ppid.get(i), new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        Queue<Integer>queue = new LinkedList<>();
        queue.add(kill);
        while(!queue.isEmpty()){
            int r = queue.remove();
            ans.add(r);
            if(map.containsKey(r)){
                for(int id:map.get(r)){
                    queue.add(id);
                }
            }
        }
        return ans;
        
    }
}