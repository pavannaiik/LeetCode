class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = arr[1]-arr[0];

        for(int i=1;i<n;i++){
            if(minDiff == arr[i]-arr[i-1]){
                result.add(List.of(arr[i-1],arr[i]));
            }else if(minDiff > arr[i]-arr[i-1]){
                result.clear();
                    minDiff = arr[i]-arr[i-1];
                    result.add(List.of(arr[i-1],arr[i]));
                
            }
        }
        return result;
    }
}