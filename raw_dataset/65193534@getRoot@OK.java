public int getRoot(int index) {
    if (parents[index] == index) {
        return index;
    } else {
        parents[index] = getRoot(parents[index]);
        return parents[index];
    }
}