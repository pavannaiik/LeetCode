class Solution {
     public String minWindow(String A, String B) {
         if(A == null||B == null || A.length() < B.length() || A.length() == 0|| B.length() == 0){
        return "";
    }
        HashMap<Character,Integer>map1=new HashMap();
        HashMap<Character,Integer>map2=new HashMap();
        for(char ch:B.toCharArray()){
            if(map1.containsKey(ch)){
                map1.put(ch,map1.get(ch)+1);
            }else{
                map1.put(ch,1);
            }
        }
        String ans="";
        int total=0,length=B.length();
        int i=0,j=0;
        while(true){
           boolean f1=false,f2=false;
           while(i<A.length()&& total<length){
               char ch=A.charAt(i);
               map2.put(ch,map2.getOrDefault(ch,0)+1);
               if(map2.getOrDefault(ch,0)<=map1.getOrDefault(ch,0)){
                   total++;
               }
               i++;
               f1=true;
           }
           while(j<i && total==length){
               String temp=A.substring(j,i);
               if(ans.length()==0 || temp.length()<ans.length()){
                   ans=temp;
               }
               char ch= A.charAt(j);
               if(map2.get(ch)==1){
                   map2.remove(ch);
               }else{
                   map2.put(ch,map2.get(ch)-1);
               }
               if(map2.getOrDefault(ch,0)<map1.getOrDefault(ch,0)){
                   total--;
               }
               f2=true;
               j++;
           }
           if(f1==false && f2==false){
               break;
           }
        }
        return ans;
    }
//     public String minWindow(String s, String t) {
//          if(s == null||t == null || s.length() < t.length() || s.length() == 0|| t.length() == 0){
//         return "";
//     }
//         HashMap<Character,Integer> tMap=new HashMap();
//         HashMap<Character,Integer> sMap=new HashMap();
//         String str="";
//         int flag=0;
//         for(char ch : t.toCharArray())
//             tMap.put(ch,tMap.getOrDefault(ch,0)+1);
//         int matchCount=0;
//         int left=0,right=0;
//         int f1=0,f2=0; // to break while true loop
//         while(true){
//             while(right<s.length() && matchCount<t.length()){
//                 char ch = s.charAt(right);
//                 sMap.put(ch,sMap.getOrDefault(ch,0)+1);
//                 if(sMap.getOrDefault(ch,0)<=tMap.getOrDefault(ch,0))
//                     matchCount++;
//                 right++;
//                 f1=1;
//             }
//             //collect and release 
//             while(left<right && matchCount==t.length() ){
//                 String temp = s.substring(left,right);
//                 if(str.length()==0 || str.length() < temp.length()){
//                     str =temp;
//                 }
//                 char c = s.charAt(left);
//                 if(sMap.get(c)==1) sMap.remove(c);
//                 else sMap.put(c,sMap.get(c)-1);
//                 if(sMap.getOrDefault(c,0)< tMap.getOrDefault(c,0))
//                     matchCount--;
//                 f2=1;
//                 left++;
               
//             }
//             if(f1 ==0 && f2 ==0) break;
//         }
//         return str;
//     }
}