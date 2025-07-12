public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs ){
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String>ans = new ArrayList<>();
        int i=0;
        int n = s.length();
        while(i < n){
            int num = 0;
            while(s.charAt(i)!='#'){
                num = num*10 + s.charAt(i)-'0';
                i++;
            }
            ans.add(s.substring(i+1, i+num+1));
            i = i+num+1;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));