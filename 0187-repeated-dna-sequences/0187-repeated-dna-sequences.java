class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String>set =new HashSet<>();
        int i=0, n= s.length();
        HashSet<String>ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<n;j++){
            sb.append(s.charAt(j));
            if(j-i+1==10 && i < n ){

                if(set.contains(sb.toString()) && !ans.contains(sb.toString())){
                    ans.add(sb.toString());
                }
                set.add(sb.toString());
                sb.deleteCharAt(0);
                i++;
            }
            
        }
        return new ArrayList<>(ans);

    }
}