static boolean check(int x, ArrayList<Pair> list, int[] suff_max) {
    for (int i = 0; i < list.size(); ++i) {
        Pair p = list.get(i);
        int a = x - p.y, b = x - p.x;
        int idx = getIdx(list, a);
        if (idx != -1) {
            int begin_at = max(idx, i + 1);
            if (begin_at < list.size() && suff_max[begin_at] >= b) {
                return true;
            }
        }
    }
    return false;
}