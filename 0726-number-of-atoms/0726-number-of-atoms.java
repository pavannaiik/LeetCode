class Solution {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> countMap = new TreeMap<>();
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        int n = formula.length();
        
        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap<>(countMap));
                countMap.clear();
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> tempMap = countMap;
                countMap = stack.pop();
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (String key : tempMap.keySet()) {
                    countMap.put(key, countMap.getOrDefault(key, 0) + tempMap.get(key) * count);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;
                countMap.put(name, countMap.getOrDefault(name, 0) + count);
            }
        }
        
        StringBuilder str = new StringBuilder();
        for (String name : countMap.keySet()) {
            str.append(name);
            int count = countMap.get(name);
            if (count > 1) {
                str.append(count);
            }
        }
        
        return str.toString();

    }
}