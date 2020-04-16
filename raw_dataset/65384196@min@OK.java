static int min(Queue<Integer> q) {
    int min = 10000;
    for (Integer var : q) {
        min = Math.min(min, var);
    }
    return min;
}