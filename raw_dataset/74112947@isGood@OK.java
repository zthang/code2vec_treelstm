boolean isGood(ArrayList<Integer> cycle, int[] col, int num) {
    for (int i = 0; i < num; i++) {
        int color = col[cycle.get(i)];
        boolean flag = true;
        for (int j = i; j < cycle.size(); j += num) {
            if (color != col[cycle.get(j)]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
    }
    return false;
}