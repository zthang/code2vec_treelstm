public void mergeSets(int x, int y) {
    int PX = findSet(x);
    int PY = findSet(y);
    if (PX == PY)
        return;
    size--;
    if (rank[PX] > rank[PY]) {
        // means py er parent ekhon px
        parent[PY] = PX;
    } else {
        parent[PX] = PY;
    }
    // 2 ta rank soman thaka means ekta tree er size barano
    if (rank[PX] == rank[PY])
        rank[PY] = rank[PY] + 1;
}