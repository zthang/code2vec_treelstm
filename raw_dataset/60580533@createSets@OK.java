public void createSets(Set[] sets) {
    for (int i = 0; i < sets.length; i++) {
        sets[i] = new Set();
        sets[i].parent = i;
        sets[i].size = 1;
    }
}