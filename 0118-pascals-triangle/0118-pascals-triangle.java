class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer>list = new ArrayList<>();
        List<Integer>completeList;
        List<List<Integer>> res= new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            completeList = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1)
                    completeList.add(1);
                else{
                    completeList.add(list.get(j-1)+list.get(j));
                }
            }
            list = completeList;
            res.add(list);
        }
        return res;
    }
}