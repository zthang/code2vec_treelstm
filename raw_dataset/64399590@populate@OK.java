public void populate(int mask) {
    if (mask2Key[mask] != notExist) {
        LongList list = sequence.get(mask2Key[mask]);
        int m = list.size();
        for (int i = 0; i < m; i++) {
            long v = list.get(i);
            long last = list.get(DigitUtils.mod(i - 1, m));
            Node which = map.get(v);
            Node to = map.get(last);
            which.out = v;
            which.to = to.id;
        }
        return;
    }
    sg.setSet(mask);
    while (sg.hasNext()) {
        int next = sg.next();
        if (next == 0 || next == mask) {
            continue;
        }
        if (dp[next] && dp[mask - next]) {
            populate(next);
            populate(mask - next);
            return;
        }
    }
}