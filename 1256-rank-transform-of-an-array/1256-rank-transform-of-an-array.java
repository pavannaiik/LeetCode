class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] newarr = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            newarr[i] = arr[i];
        }
        Arrays.sort(newarr);
        HashMap<Integer,Integer>map = new HashMap<>();
        int[] res = new int[arr.length];
        int j=0;
        int rank =1;
        for( int i =0;i<newarr.length;i++){
            if(map.containsKey(newarr[i])){
                continue;
            }else{
                map.put(newarr[i],rank++);
            }
        }
        for(int n : arr){
            res[j++] = map.get(n);
        }
        return res;
        
    }
}