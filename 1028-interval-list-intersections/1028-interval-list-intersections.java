class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        List<int[]>result = new ArrayList<>();
        int i=0;
        int j =0;
        while(i < n && j < m){
            int s1 = firstList[i][0], e1 = firstList[i][1];
            int s2 = secondList[j][0], e2 = secondList[j][1];
            if(s1 <= s2 && e1 >= s2 || s2 <= s1 && e2 >= s1){
                result.add(new int[]{Math.max(s1,s2),Math.min(e1,e2)});
              //  System.out.println(result.get(result.size()-1)[0] +" "+result.get(result.size()-1)[1]);
            }
            if(e1 <= e2){
                i++;
            }else{
                j++;
            }
        }
        int[][] ans = new int[result.size()][2];
        int p=0;
        for(int[] res:result){
            ans[p][0]= res[0];
            ans[p][1]= res[1];
            p++;
        }
        return ans;
    }
}