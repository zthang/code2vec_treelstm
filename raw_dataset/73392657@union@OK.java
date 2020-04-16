public void union(Long u, Long v) {
    Long pu = find(u);
    Long pv = find(v);
    parents.put(pu, pv);
}