class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int ans =1;
        int n = dist.length;
        List<Double>list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add((double)dist[i]/speed[i]);
        }
        Collections.sort(list);
        for(int i=1;i<n;i++){
            if(list.get(i)<=i){
                return ans;
            }
            ans++;
        }
        return ans;
    }
}