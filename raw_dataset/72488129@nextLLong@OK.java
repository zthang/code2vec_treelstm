public List<Long> nextLLong(int n) {
    List<Long> l = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
        l.add(sc.nextLong());
    }
    return l;
}