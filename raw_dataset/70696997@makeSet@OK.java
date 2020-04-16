public static void makeSet(int size) {
    parent = new int[size];
    rank = new int[size];
    for (int i = 0; i < size; ++i) {
        parent[i] = i;
        rank[i] = 0;
    }
}