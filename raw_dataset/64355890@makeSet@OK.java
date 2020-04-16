static void makeSet(int v) {
    // add vertex v to new set
    parent[v] = v;
    // if we use size of tree as rank
    rank[v] = 1;
// rank[v]=0; // if we use depth as rank
}