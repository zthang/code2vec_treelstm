public int[] readIntArrayAndDecrementOne(int tokens) {
    int[] ret = new int[tokens];
    for (int i = 0; i < tokens; i++) {
        ret[i] = nextInt() - 1;
    }
    return ret;
}