static boolean go(ArrayList<Integer> ids, int to) {
    for (int st = 0; st < to; st++) {
        boolean good = true;
        int col = c[ids.get(st)];
        for (int i = st + to; i < ids.size(); i += to) {
            if (c[ids.get(i)] != col)
                good = false;
        }
        if (good)
            return true;
    }
    return false;
}