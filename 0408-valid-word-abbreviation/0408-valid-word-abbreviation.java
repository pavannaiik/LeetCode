class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder sb = new StringBuilder();
        int abbrLen = abbr.length();
        int i=0;
        int wordLen = word.length();
        while(i < abbrLen){
            if(abbr.charAt(i) == '0') return false;
            if(Character.isAlphabetic(abbr.charAt(i))){
                sb.append(abbr.charAt(i));
                i++;
            }else{
                int subStringLen = 0;
                while(i < abbrLen && Character.isDigit(abbr.charAt(i)) ){
                    subStringLen = subStringLen*10 + (int)(abbr.charAt(i)-'0');
                    i++;
                }
                System.out.println(subStringLen);
                if(sb.length() + subStringLen > wordLen) return false;
                sb.append(word.substring(sb.length(), sb.length() + subStringLen));

            }
        }
        return word.equals(sb.toString());
    }
}