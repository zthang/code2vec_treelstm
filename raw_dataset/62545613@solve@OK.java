public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    degree = new int[n + 1];
    c1 = new long[n + 1];
    c2 = new long[n + 1];
    c3 = new long[n + 1];
    indexMap = new int[n + 1];
    reverseIndexMap = new int[n + 1];
    for (int i = 1; i <= n; i++) c1[i] = in.nextLong();
    for (int i = 1; i <= n; i++) c2[i] = in.nextLong();
    for (int i = 1; i <= n; i++) c3[i] = in.nextLong();
    graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int a = in.nextInt(), b = in.nextInt();
        graph[a].add(b);
        graph[b].add(a);
        degree[a]++;
        degree[b]++;
        if (degree[a] > 2 || degree[b] > 2) {
            out.println(-1);
            out.flush();
            return;
        }
    }
    for (int i = 1; i <= n; i++) {
        if (degree[i] == 1) {
            dfs(i, i);
            break;
        }
    }
    int[] tempColours = new int[n];
    tempColours[0] = 1;
    tempColours[1] = 2;
    long tempCost = c1[reverseIndexMap[0]] + c2[reverseIndexMap[1]];
    for (int i = 2; i < n; i++) {
        tempColours[i] = 1;
        while (tempColours[i - 1] == tempColours[i] || tempColours[i - 2] == tempColours[i]) tempColours[i]++;
        if (tempColours[i] == 1)
            tempCost += c1[reverseIndexMap[i]];
        if (tempColours[i] == 2)
            tempCost += c2[reverseIndexMap[i]];
        if (tempColours[i] == 3)
            tempCost += c3[reverseIndexMap[i]];
    }
    long minCost = tempCost;
    int[] colours = new int[n];
    System.arraycopy(tempColours, 0, colours, 0, n);
    tempColours[0] = 1;
    tempColours[1] = 3;
    tempCost = c1[reverseIndexMap[0]] + c3[reverseIndexMap[1]];
    for (int i = 2; i < n; i++) {
        tempColours[i] = 1;
        while (tempColours[i - 1] == tempColours[i] || tempColours[i - 2] == tempColours[i]) tempColours[i]++;
        if (tempColours[i] == 1)
            tempCost += c1[reverseIndexMap[i]];
        if (tempColours[i] == 2)
            tempCost += c2[reverseIndexMap[i]];
        if (tempColours[i] == 3)
            tempCost += c3[reverseIndexMap[i]];
    }
    if (tempCost < minCost) {
        minCost = tempCost;
        System.arraycopy(tempColours, 0, colours, 0, n);
    }
    tempColours[0] = 2;
    tempColours[1] = 1;
    tempCost = c2[reverseIndexMap[0]] + c1[reverseIndexMap[1]];
    for (int i = 2; i < n; i++) {
        tempColours[i] = 1;
        while (tempColours[i - 1] == tempColours[i] || tempColours[i - 2] == tempColours[i]) tempColours[i]++;
        if (tempColours[i] == 1)
            tempCost += c1[reverseIndexMap[i]];
        if (tempColours[i] == 2)
            tempCost += c2[reverseIndexMap[i]];
        if (tempColours[i] == 3)
            tempCost += c3[reverseIndexMap[i]];
    }
    if (tempCost < minCost) {
        minCost = tempCost;
        System.arraycopy(tempColours, 0, colours, 0, n);
    }
    tempColours[0] = 2;
    tempColours[1] = 3;
    tempCost = c2[reverseIndexMap[0]] + c3[reverseIndexMap[1]];
    for (int i = 2; i < n; i++) {
        tempColours[i] = 1;
        while (tempColours[i - 1] == tempColours[i] || tempColours[i - 2] == tempColours[i]) tempColours[i]++;
        if (tempColours[i] == 1)
            tempCost += c1[reverseIndexMap[i]];
        if (tempColours[i] == 2)
            tempCost += c2[reverseIndexMap[i]];
        if (tempColours[i] == 3)
            tempCost += c3[reverseIndexMap[i]];
    }
    if (tempCost < minCost) {
        minCost = tempCost;
        System.arraycopy(tempColours, 0, colours, 0, n);
    }
    tempColours[0] = 3;
    tempColours[1] = 1;
    tempCost = c3[reverseIndexMap[0]] + c1[reverseIndexMap[1]];
    for (int i = 2; i < n; i++) {
        tempColours[i] = 1;
        while (tempColours[i - 1] == tempColours[i] || tempColours[i - 2] == tempColours[i]) tempColours[i]++;
        if (tempColours[i] == 1)
            tempCost += c1[reverseIndexMap[i]];
        if (tempColours[i] == 2)
            tempCost += c2[reverseIndexMap[i]];
        if (tempColours[i] == 3)
            tempCost += c3[reverseIndexMap[i]];
    }
    if (tempCost < minCost) {
        minCost = tempCost;
        System.arraycopy(tempColours, 0, colours, 0, n);
    }
    tempColours[0] = 3;
    tempColours[1] = 2;
    tempCost = c3[reverseIndexMap[0]] + c2[reverseIndexMap[1]];
    for (int i = 2; i < n; i++) {
        tempColours[i] = 1;
        while (tempColours[i - 1] == tempColours[i] || tempColours[i - 2] == tempColours[i]) tempColours[i]++;
        if (tempColours[i] == 1)
            tempCost += c1[reverseIndexMap[i]];
        if (tempColours[i] == 2)
            tempCost += c2[reverseIndexMap[i]];
        if (tempColours[i] == 3)
            tempCost += c3[reverseIndexMap[i]];
    }
    if (tempCost < minCost) {
        minCost = tempCost;
        System.arraycopy(tempColours, 0, colours, 0, n);
    }
    out.println(minCost);
    int[] ans = new int[n + 1];
    for (int i = 0; i < n; i++) {
        ans[reverseIndexMap[i]] = colours[i];
    }
    for (int i = 1; i <= n; i++) out.printsc(ans[i]);
    out.println();
    out.flush();
}