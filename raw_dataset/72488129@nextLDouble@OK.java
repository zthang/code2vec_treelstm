public List<Double> nextLDouble(int n) {
    List<Double> l = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
        l.add(sc.nextDouble());
    }
    return l;
}