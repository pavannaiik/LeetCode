class Solution {
    public String[] reorderLogFiles(String[] logs) {
       Arrays.sort(logs, new Comparator<String>() {
        @Override
         public int compare(String X, String Y){
            if(Character.isAlphabetic(X.charAt(X.length()-1)) && Character.isAlphabetic(Y.charAt(Y.length()-1))){
                String newX= X.substring(X.indexOf(' '));
                String newY = Y.substring(Y.indexOf(' '));
                if(newX.equals(newY)){
                    return X.substring(0,X.indexOf(' ')).compareTo(Y.substring(0,Y.indexOf(' ')));
                }
                return newX.compareTo(newY);
            }else if(Character.isDigit(X.charAt(X.length()-1)) && Character.isAlphabetic(Y.charAt(Y.length()-1))){
                return 1;
            }else if(Character.isAlphabetic(X.charAt(X.length()-1)) && Character.isDigit(Y.charAt(Y.length()-1))){
                return -1;
            }
            return 0;
         }
       });
       return logs;
    }
}