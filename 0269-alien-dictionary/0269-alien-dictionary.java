class Solution {
    public String alienOrder(String[] words) {
        //initialize graph
        HashMap<Character,Set<Character>>graph = new HashMap<>();
        for(String word: words){
            for(char c: word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        //build graph
        for(int i=0;i<words.length-1;i++){
            String s1 = words[i], s2 = words[i+1];
            if(s1.length() > s2.length() && s1.startsWith(s2)) return "";
            for(int j=0;j<Math.min(s1.length(), s2.length());j++){
                char c1 = s1.charAt(j), c2 = s2.charAt(j);
                if(c1 != c2){
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }
        Set<Character>visited = new HashSet<>();
        Set<Character>visiting = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c: graph.keySet()){
            if(!visited.contains(c)){
                if(!dfs(c, graph, visited, visiting, sb)){
                    return ""; // cycle found
                }
            }
        }
        return sb.reverse().toString();
    }
    public boolean dfs(char c, HashMap<Character, Set<Character>>graph, 
        Set<Character>visited, Set<Character>visiting, StringBuilder sb){
            if(visiting.contains(c)) return false;
            if(visited.contains(c)) return true;
            visiting.add(c);
            for(char nei: graph.get(c)){
                 if(!dfs(nei, graph, visited, visiting, sb)){
                    return false;
                }
            }
            visited.add(c);
            visiting.remove(c);
            sb.append(c);
            
        return true;
    }
}