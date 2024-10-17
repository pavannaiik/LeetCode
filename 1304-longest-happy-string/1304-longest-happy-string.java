class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->y.count-x.count);
        if(a>0) pq.add(new Pair(a,'a'));
        if(b>0) pq.add(new Pair(b,'b'));
        if(c>0) pq.add(new Pair(c,'c'));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int count = p.count;
            char ch=p.ch;
            int n =sb.length();
            if(n>=2 && sb.charAt(n-1)==ch && sb.charAt(n-2)==ch){
                if (pq.isEmpty()) break;
                Pair temp = pq.poll();
                sb.append(temp.ch);
                if(temp.count-1>0){
                    pq.add(new Pair(temp.count-1, temp.ch));
                }
            }else{
                count--;
                sb.append(ch);
            }
            if(count > 0){
                pq.add(new Pair(count, ch));
            }
        }
        return sb.toString();
       
    }
}
class Pair{
    int count;
    char ch;
    Pair(int count, char ch){
        this.count=count;
        this.ch=ch;
    }
}