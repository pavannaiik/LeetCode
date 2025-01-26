class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> h = new HashSet(),l = new HashSet();
        if(s.length()<10 || s.length()>10000){
             return new ArrayList(l);
        }
        for(int i=0;i+9<s.length();i++){
            String r = s.substring(i,i+10);
            if(!h.add(r)){
                l.add(r);
            }
        }
        return new ArrayList<>(l);

    }
}