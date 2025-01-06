class Element{
    public String web;
    public int time;
    public Element(String websit, int timestamp) {
        this.web = websit;
        this.time = timestamp;
    }
}
class Solution {
    private String s = "";
    private int max = 0;
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        if(website == null || website.length < 3) return new ArrayList<>();
        Map<String, List<Element>> group = new HashMap<>();
        int len = username.length;
        for(int i = 0; i < len; i++) {
            group.putIfAbsent(username[i], new ArrayList<>());
            group.get(username[i]).add(new Element(website[i], timestamp[i]));
        }
        Map<String, Integer> count = new HashMap<>();
        for(String name : group.keySet()) {
            List<Element> list = group.get(name);
            Collections.sort(list, (a, b) -> (a.time - b.time));
            helper(list, 0, new StringBuilder(), 0, new HashSet<>(), count);
        }
        return Arrays.asList(s.split(" "));
    }
    private void helper(List<Element> list, int start, StringBuilder sb, int count, Set<String> seen, Map<String, Integer> map) {
        if(count == 3) {
            String curr = sb.toString();
            if(seen.contains(curr)) return;
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if(map.get(curr) >= max) {
                if(map.get(curr) > max || s.compareTo(curr) > 0) {
                    s = curr;
                }
                max = map.get(curr);
            }
            seen.add(curr);
            return;
        }else if(count > 3) return;
        int len = sb.length();
        for(int i = start; i < list.size(); i++) {
            if(len > 0) sb.append(" ");
            sb.append(list.get(i).web);
            helper(list, i + 1, sb, count + 1, seen, map);
            sb.setLength(len);
        }
        return;
    }
}