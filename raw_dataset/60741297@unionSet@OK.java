public void unionSet(int i, int j) {
    if (!isSameSet(i, j)) {
        numSets--;
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank.get(x) > rank.get(y)) {
            p.set(y, x);
            setSize.set(x, setSize.get(x) + setSize.get(y));
        } else {
            p.set(x, y);
            setSize.set(y, setSize.get(y) + setSize.get(x));
            if (rank.get(x) == rank.get(y))
                rank.set(y, rank.get(y) + 1);
        }
    }
}