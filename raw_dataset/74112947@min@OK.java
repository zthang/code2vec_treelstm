int min(ArrayList<Integer> cycle, int[] col) {
    int res = cycle.size();
    for (int i = 1; i <= (int) Math.sqrt(cycle.size()); i++) {
        if (cycle.size() % i == 0) {
            if (isGood(cycle, col, i)) {
                res = Math.min(i, res);
            } else if (isGood(cycle, col, cycle.size() / i)) {
                res = Math.min(cycle.size() / i, res);
            }
        }
    }
    return res;
}