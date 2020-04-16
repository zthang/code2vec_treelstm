private void search(int start, int cur, long fromStart, long fromCur, int hasIn, int hasOut, List<Entry> sol, Entry[][] cycleSol) {
    for (int i = 0; i < n; i++) {
        if ((hasIn & (1 << i)) > 0) {
            continue;
        }
        if ((hasOut & (1 << cur)) > 0) {
            continue;
        }
        long fromI = sums[i] + fromCur - neededSum;
        Integer w = where.get(fromI);
        if (w == null || w != i) {
            continue;
        }
        sol.add(new Entry(cur, i, (int) fromCur));
        int nHasIn = hasIn | (1 << i);
        int nHasOut = hasOut | (1 << cur);
        if (i == start && fromI == fromStart) {
            cycleSol[nHasOut] = sol.toArray(new Entry[0]);
        }
        search(start, i, fromStart, fromI, nHasIn, nHasOut, sol, cycleSol);
        sol.remove(sol.size() - 1);
    }
}