public void sort() {
    if (size <= 1) {
        return;
    }
    Randomized.shuffle(data, 0, size);
    Arrays.sort(data, 0, size);
}