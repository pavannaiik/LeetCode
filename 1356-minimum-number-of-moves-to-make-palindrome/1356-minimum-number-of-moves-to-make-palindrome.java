class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int left=0, right=n-1;
        int res=0;
        while(left < right){
            if(ch[left]==ch[right]){
                left++;
                right--;
            }else{
                int tmp = right;
                while(tmp > left && ch[tmp]!=ch[left]){
                    tmp--;
                }
                if(tmp==left){
                    swap(ch, left, left+1);
                    res++;
                }else{
                    while(tmp< right){
                        swap(ch, tmp, tmp+1);
                        res++;
                        tmp++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
    public void swap(char[] ch, int i, int j){
       char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}