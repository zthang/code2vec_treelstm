public static boolean dfs(int curr, int prev, boolean[] done, boolean[] ok, long[] w, long[] sumNotOk, ArrayList<Integer>[] g) {
    // System.out.println(curr + " " + prev);
    done[curr] = true;
    for (int next : g[curr]) {
        // System.out.println(curr + " -> " + next + " " + done[next]);
        if (next == prev)
            continue;
        ok[curr] |= done[next];
        if (done[next])
            continue;
        ok[curr] |= dfs(next, curr, done, ok, w, sumNotOk, g);
    }
    if (!ok[curr]) {
        sumNotOk[curr] = w[curr];
        for (int next : g[curr]) if (next != prev)
            sumNotOk[curr] = max(sumNotOk[curr], w[curr] + sumNotOk[next]);
    }
    return ok[curr];
}