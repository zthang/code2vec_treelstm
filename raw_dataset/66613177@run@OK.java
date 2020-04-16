public void run() {
    FastScanner fs = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    System.err.println("");
    valToNode = new HashMap<>();
    nodeToVal = new HashMap<>();
    whichBox = new HashMap<>();
    int K = fs.nextInt();
    int[][] vals = new int[K][], valToNode2 = new int[K][];
    long[] sums = new long[K];
    long total = 0;
    for (int i = 0; i < K; i++) {
        int size = fs.nextInt();
        vals[i] = new int[size];
        valToNode2[i] = new int[size];
        for (int j = 0; j < size; j++) {
            vals[i][j] = fs.nextInt();
            sums[i] += vals[i][j];
            valToNode2[i][j] = valToNode.size();
            valToNode.put(vals[i][j], valToNode.size());
            nodeToVal.put(valToNode.size() - 1, vals[i][j]);
            whichBox.put(vals[i][j], i);
        }
        total += sums[i];
    }
    if (total % K != 0) {
        System.out.println("No");
        return;
    }
    long perGroup = total / K;
    N = valToNode.size();
    ptsTo = new int[N];
    for (int i = 0; i < K; i++) {
        for (int j = 0; j < vals[i].length; j++) {
            long newSum = perGroup - (sums[i] - vals[i][j]);
            if (newSum > (int) 1e9 || newSum < (int) -1e9)
                continue;
            if (valToNode.containsKey((int) newSum)) {
                ptsTo[valToNode.get(vals[i][j])] = valToNode.get((int) newSum);
            } else
                ptsTo[valToNode.get(vals[i][j])] = -1;
        }
    }
    tempList = new int[N];
    dfsStack = new int[N];
    cycleMask = new int[N];
    for (int i = 0; i < K; i++) {
        for (int j = 0; j < vals[i].length; j++) {
            int node = valToNode.get(vals[i][j]);
            if (dfsStack[node] == 0)
                dfs(node);
        }
    }
    int[] goodMask = new int[1 << K];
    Arrays.fill(goodMask, -1);
    goodMask[0] = 0;
    for (int mask = 1; mask < goodMask.length; mask++) {
        int idx = Integer.numberOfTrailingZeros(Integer.lowestOneBit(mask));
        for (int i = 0; i < vals[idx].length; i++) {
            int node = valToNode2[idx][i];
            if (cycleMask[node] == mask) {
                goodMask[mask] = node;
                break;
            }
        }
    }
    int[] dp = new int[1 << K];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int mask = 1; mask < dp.length; mask++) {
        if (goodMask[mask] != -1) {
            dp[mask] = mask;
            continue;
        }
        for (int sub = mask; sub != 0; sub = (sub - 1) & mask) {
            if (goodMask[sub] == -1)
                continue;
            int newMask = mask - sub;
            if (dp[newMask] == -1)
                continue;
            dp[mask] = sub;
            break;
        }
    }
    if (dp[dp.length - 1] == -1)
        out.println("No");
    else {
        int[][] res = new int[K][2];
        for (int[] x : res) Arrays.fill(x, -1);
        int curMask = dp.length - 1;
        while (curMask > 0) {
            int temp = dp[curMask];
            int curNode = goodMask[temp];
            while (temp > 0) {
                int curVal = nodeToVal.get(curNode), curBox = whichBox.get(curVal);
                res[curBox][0] = curVal;
                int goingTo = ptsTo[curNode], goingVal = nodeToVal.get(goingTo), goingBox = whichBox.get(goingVal);
                res[goingBox][1] = curBox;
                curNode = ptsTo[curNode];
                temp -= 1 << curBox;
            }
            curMask -= dp[curMask];
        }
        out.println("Yes");
        for (int i = 0; i < K; i++) {
            if (res[i][1] == -1)
                throw null;
            out.printf("%d %d\n", res[i][0], res[i][1] + 1);
        }
    }
    out.close();
}