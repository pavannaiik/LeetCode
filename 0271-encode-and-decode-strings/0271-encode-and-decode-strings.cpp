class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string encoded="";
        for(auto s:strs){
            encoded += (to_string(s.size()) + "#"+s);
        }
        return encoded;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        vector<string>ans;
        int i=0;
        while(i<s.length()){
            int j=i;
            while( s[j]!='#'){
                j++;
            }
            int length = stoi(s.substr(i,j-i));
            i=j+1;
            string str=s.substr(i,length);
            ans.push_back(str);
            i=i+length;
        }
        return ans;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));