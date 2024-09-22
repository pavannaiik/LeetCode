class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>[][] memo = new ArrayList[expression.length()][expression.length()];
        return computeResults(expression, memo, 0, expression.length()-1);
    }
    public List<Integer> computeResults(String expression,List<Integer>[][] memo, int start, int end ){
        if(memo[start][end]!=null){
            return memo[start][end];
        }
        List<Integer>results = new ArrayList<>();
        //base case single digit
        if(start==end){
            results.add(expression.charAt(start)-'0');
            return results;
        }
        // base case two digits
        if(end-start==1 && Character.isDigit(expression.charAt(start))){
            int tens = expression.charAt(start)-'0';
            int ones = expression.charAt(end)-'0';
            results.add(10*tens+ones);
            return results;
        }
        for(int i=start;i<=end;i++){
            char curChar = expression.charAt(i);
            if(Character.isDigit(curChar)){
                continue;
            }
            List<Integer> leftResults = computeResults(
                expression,
                memo,
                start,
                i - 1
            );
            List<Integer> rightResults = computeResults(
                expression,
                memo,
                i + 1,
                end
            );
            // Combine results from left and right subexpressions
            for (int leftValue : leftResults) {
                for (int rightValue : rightResults) {
                    switch (curChar) {
                        case '+':
                            results.add(leftValue + rightValue);
                            break;
                        case '-':
                            results.add(leftValue - rightValue);
                            break;
                        case '*':
                            results.add(leftValue * rightValue);
                            break;
                    }
                }
            }

            
        }
        // Memoize the result for this subproblem
        memo[start][end] = results;

        return results;
    }
}