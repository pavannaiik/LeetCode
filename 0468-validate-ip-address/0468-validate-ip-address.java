class Solution {
    public String validIPAddress(String queryIP) {

        if(isIPv4(queryIP)) return "IPv4";
        else if(isIPv6(queryIP)) return "IPv6";
        else return "Neither";
    }
    private boolean isIPv4(String ip){
             String[] strArr4 = ip.split("\\.",-1);
             if(strArr4.length!=4) return false;
             for(String s:strArr4){
                try{
                    if((s.length()>1 && s.charAt(0) == '0' ) || Integer.parseInt(s)>255){
                        return false;
                    }
                }catch(NumberFormatException e){
                    return false;
                }
            }
            return true;
        }
        private boolean isIPv6(String ip){
             String[] strArr6 = ip.split(":",-1);
             if(strArr6.length!=8) return false;
             for(String s:strArr6){
                try{
                    if (s.length() == 0 || s.length() > 4) return false;
                    for (char c : s.toCharArray()) {
                        if (!isHexCharacter(c)) return false;
                    }
                }catch(NumberFormatException e){
                    return false;
                }
            }
            return true;
        }

        private boolean isHexCharacter(char c) {
            return (c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'f') ||
                (c >= 'A' && c <= 'F');
        }
}