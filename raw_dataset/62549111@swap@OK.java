static void swap(int[] dm) {
    dm[1] ^= dm[2];
    dm[2] ^= dm[1];
    dm[1] ^= dm[2];
}