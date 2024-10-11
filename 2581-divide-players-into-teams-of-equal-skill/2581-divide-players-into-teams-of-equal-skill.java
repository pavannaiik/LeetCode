class Solution {
    public long dividePlayers(int[] skill) {
        int sum = Arrays.stream(skill).sum();
        int n = skill.length;
        int req = (sum*2)/n;
        if(sum%2!=0 && (n/2)%2==0) return -1;
        Arrays.sort(skill);
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ski:skill){
            map.put(ski, map.getOrDefault(ski, 0)+1);
        }
        
        long ans=0;
        for(int i=0;i<n/2;i++){
            int s = skill[i];
            if(!map.containsKey(Math.abs(req-s))){
                return -1;
            }
            ans += (s * Math.abs(req-s));
            if(map.get(s)>1){
                map.put(s, map.get(s)-1);
            }else{
                map.remove(s);
            }
            if(map.get(Math.abs(req-s))>1){
                map.put(Math.abs(req-s), map.get(Math.abs(req-s))-1);
            }else{
                map.remove(Math.abs(req-s));
            }
        }
        return ans;
    }
}