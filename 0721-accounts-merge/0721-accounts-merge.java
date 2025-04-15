class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        // Step 1: Initialize parent and email-name map
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);
                union(parent, account.get(1), email); // connect all emails in same account
            }
        }

        // Step 2: Group emails by root parent
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        // Step 3: Build the result
        List<List<String>> result = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> group = new ArrayList<>();
            group.add(emailToName.get(root)); // name
            group.addAll(unions.get(root));   // sorted emails
            result.add(group);
        }

        return result;
    }

    private String find(Map<String, String> parent, String s) {
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent, parent.get(s))); // path compression
        }
        return parent.get(s);
    }

    private void union(Map<String, String> parent, String a, String b) {
        String rootA = find(parent, a);
        String rootB = find(parent, b);
        if (!rootA.equals(rootB)) {
            parent.put(rootB, rootA);
        }
    }
}
