class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>res = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char operator = expression.charAt(i);
            if(operator == '+' || operator == '-' || operator == '*' ){
                List<Integer>leftList = diffWaysToCompute(expression.substring(0,i));
                List<Integer>rightList = diffWaysToCompute(expression.substring(i+1));
                for(int a:leftList){
                    for(int b : rightList){
                        if(operator == '+') res.add(a+b);
                        else if(operator == '-') res.add(a-b);
                        else if(operator == '*') res.add(a*b);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
   
}