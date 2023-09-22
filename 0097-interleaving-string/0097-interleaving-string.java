class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!= s3.length()){
            return false;
        }
        int[][] cache = new int[s1.length()][s2.length()];
        for(int[] arr: cache){
            Arrays.fill(arr,-1);
        }
        return isInterleaving(s1,0,s2,0,s3,0,cache);
    }
    public boolean isInterleaving(String s1,int i, String s2,int j,String s3,int k,int[][] matrix){
       
        if(i==s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j==s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }
        if(matrix[i][j] >= 0){
            return matrix[i][j]==1?true:false;
        }
        boolean ans =false;
        if(s1.charAt(i)==s3.charAt(k) && isInterleaving(s1,i+1,s2,j,s3,k+1,matrix) || s2.charAt(j)==s3.charAt(k) && isInterleaving(s1,i,s2,j+1,s3,k+1,matrix) ){
            ans =true;
        }
        matrix[i][j]=ans?1:0;
        return ans;
    }
}