public List<Integer> nextLInt(int n) {
    List<Integer> l = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
        l.add(sc.nextInt());
    }
    return l;
}