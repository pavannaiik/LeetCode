class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int>stack;
        for(string s:tokens){
            if(s=="*"){
                int n1=stack.top();
                stack.pop();
                int n2=stack.top();
                stack.pop();

                stack.push(n1*n2);
            }else if(s=="-"){
                int n1=stack.top();
                stack.pop();
                int n2=stack.top();
                stack.pop();

                stack.push(n2-n1);
            }else if(s=="+"){
                int n1=stack.top();
                stack.pop();
                int n2=stack.top();
                stack.pop();

                stack.push(n1+n2);
            }else if(s=="/"){
                int n1=stack.top();
                stack.pop();
                int n2=stack.top();
                stack.pop();

                stack.push(n2/n1);
            }else{
                stack.push(stoi(s));
            }
        }
        return stack.top();
    }
};