public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        int count = 0;
        StringBuilder msg = new StringBuilder();
        for(int i = 0; i<strs.size(); i++){
            msg.append(String.valueOf(strs.get(i).length()));
            msg.append("#");
            msg.append(strs.get(i));
        }
        return msg.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i<s.length()){
            int idx = s.indexOf('#',i);
            String len = s.substring(i,idx);
            Integer length = Integer.valueOf(len);
            result.add(s.substring(idx+1, idx+1 + length));
            i = idx+1+length;
        }

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));