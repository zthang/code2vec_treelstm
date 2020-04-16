public boolean union(long data1, long data2) {
    Node node1 = map.get(data1);
    Node node2 = map.get(data2);
    Node parent1 = findSet(node1);
    Node parent2 = findSet(node2);
    if (parent1.data == parent2.data) {
        return false;
    } else {
        parent2.parent = parent1;
        parent1.rank += parent2.rank;
        parent2.rank = 0;
        parent1.size += parent2.size;
        parent2.size = 0;
    }
    return true;
}