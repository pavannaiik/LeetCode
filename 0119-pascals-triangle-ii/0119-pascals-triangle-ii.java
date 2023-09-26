class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>list = new ArrayList<>();
        List<Integer>completeList;
        List<List<Integer>> res= new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            completeList = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    completeList.add(1);
                else{
                    completeList.add(list.get(j-1)+list.get(j));
                }
            }
            list = completeList;
            res.add(list);
        }
        return res.get(rowIndex);
    }
}