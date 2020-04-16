public void union(String data1, String data2) {
    Node node1 = map.get(data1);
    Node node2 = map.get(data2);
    Node parent1 = findParentNode(node1);
    Node parent2 = findParentNode(node2);
    if (parent1.data == parent2.data)
        return;
    if (parent1.rank >= parent2.rank) {
        parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank = parent1.rank + 1 : parent1.rank;
        parent2.parent = parent1;
    } else {
        parent1.parent = parent2;
    }
}