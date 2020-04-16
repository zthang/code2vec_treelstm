private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        int n = in.nextInt();
        String[] pw = new String[n];
        for (int i = 0; i < n; i++) {
            pw[i] = in.next();
        }
        Set<String> unique = new HashSet<>();
        List<String> uniqueList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!unique.contains(pw[i])) {
                unique.add(pw[i]);
                uniqueList.add(pw[i]);
            }
        }
        for (int i = 0; i < uniqueList.size(); i++) {
            for (int j = 0; j < uniqueList.get(i).length(); j++) {
                if (!map.containsKey(uniqueList.get(i).charAt(j))) {
                    map.put(uniqueList.get(i).charAt(j), new HashSet<>());
                }
                map.get(uniqueList.get(i).charAt(j)).add(i);
            }
        }
        Uf uf = new Uf(uniqueList.size());
        for (char c : map.keySet()) {
            Set<Integer> ss = map.get(c);
            Iterator<Integer> iterator = ss.iterator();
            int p = iterator.next();
            while (iterator.hasNext()) {
                uf.union(p, iterator.next());
            }
        }
        out.println(uf.count);
    }
    out.close();
}