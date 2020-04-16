static void union(int a, int b) {
    // attach 2nd tree(set with b in it) into 1st one(set with a in it)
    a = findSet(a);
    b = findSet(b);
    if (a != b) {
        if (rank[a] < rank[b]) {
            // attach lower rank tree with bigger rank
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
        // if we use size of tree as rank
        rank[a] += rank[b];
    // if (rank[a]==rank[b])rank[a]++;//if we use depth as rank
    }
}