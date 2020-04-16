int total() {
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < n; i++) {
        int x = find(i);
        hs.add(x);
    }
    return hs.size();
}