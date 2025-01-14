class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        HashMap<String, List<String[]>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            String[] details = transactions[i].split(",");
            if(!map.containsKey(details[0])){
                map.put(details[0], new ArrayList<>());
            }
            map.get(details[0]).add(details);

        }
        List<String>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] details = transactions[i].split(",");
            if(Integer.parseInt(details[2])>1000){
                ans.add(transactions[i]);
            }else{
                for(String[] curr:map.get(details[0])){
                    if(Math.abs(Integer.parseInt(curr[1])-Integer.parseInt(details[1])) <= 60 && !curr[3].equals(details[3])){
                        ans.add(transactions[i]);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}