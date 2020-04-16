public List<Set<Integer>> getGroups() {
    int n = parent.length;
    List<Set<Integer>> groups = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
        int r = root(i);
        if (!map.containsKey(r)) {
            map.put(r, groups.size());
            groups.add(new HashSet<>());
        }
        groups.get(map.get(r)).add(i);
    }
    return groups;
}