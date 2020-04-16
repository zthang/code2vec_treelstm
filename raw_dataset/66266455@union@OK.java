void union(String s1, String s2) {
    Node n1 = mp.get(s1);
    Node n2 = mp.get(s2);
    Node parent1 = find(n1);
    Node parent2 = find(n2);
    if (parent1.rank >= parent2.rank) {
        parent1.rank = (parent1.rank == parent2.rank) ? (parent1.rank + 1) : (parent1.rank);
        parent2.parent = parent1;
    } else
        parent1.parent = parent2;
}