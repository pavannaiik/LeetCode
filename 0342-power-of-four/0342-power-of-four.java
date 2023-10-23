class Power{
    private int num =15;
    ArrayList<Integer>list = new ArrayList<>();
    Power(){
        int lastNum = 1;
        list.add(lastNum);
        for(int i=1;i<=num;i++){
            lastNum = 4*lastNum;
            list.add(lastNum);
        }
    }
}

class Solution {
    public static Power p = new Power();
    public boolean isPowerOfFour(int n) {
        return p.list.contains(n);
    }
}