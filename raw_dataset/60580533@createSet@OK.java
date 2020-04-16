public void createSet(int i) {
    Set set = new Set();
    set.parent = i;
    set.size = 1;
    dSets.put(i, set);
}