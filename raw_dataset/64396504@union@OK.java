int union(int i, int j) {
    i = id[i];
    j = id[j];
    ArrayList<Integer> small, large;
    int newId;
    if (sets[i].size() < sets[j].size()) {
        small = sets[i];
        large = sets[j];
        newId = j;
    } else {
        small = sets[j];
        large = sets[i];
        newId = i;
    }
    for (int x : small) {
        large.add(x);
        id[x] = newId;
        tree.update(x, newId);
    }
    return i;
}