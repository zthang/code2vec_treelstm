void startAlgo(int root) {
    long minSum = Long.MAX_VALUE;
    colorMap[0] = 0;
    colorMap[1] = 1;
    colorMap[2] = 2;
    long sum1 = dfs(root, 0, 0);
    if (sum1 < minSum) {
        minColorMap[0] = 0;
        minColorMap[1] = 1;
        minColorMap[2] = 2;
        minSum = sum1;
    }
    colorMap[0] = 0;
    colorMap[1] = 2;
    colorMap[2] = 1;
    long sum2 = dfs(root, 0, 0);
    if (sum2 < minSum) {
        minColorMap[0] = 0;
        minColorMap[1] = 2;
        minColorMap[2] = 1;
        minSum = sum2;
    }
    colorMap[0] = 1;
    colorMap[1] = 0;
    colorMap[2] = 2;
    long sum3 = dfs(root, 0, 0);
    if (sum3 < minSum) {
        minColorMap[0] = 1;
        minColorMap[1] = 0;
        minColorMap[2] = 2;
        minSum = sum3;
    }
    colorMap[0] = 1;
    colorMap[1] = 2;
    colorMap[2] = 0;
    long sum4 = dfs(root, 0, 0);
    if (sum4 < minSum) {
        minColorMap[0] = 1;
        minColorMap[1] = 2;
        minColorMap[2] = 0;
        minSum = sum4;
    }
    colorMap[0] = 2;
    colorMap[1] = 0;
    colorMap[2] = 1;
    long sum5 = dfs(root, 0, 0);
    if (sum5 < minSum) {
        minColorMap[0] = 2;
        minColorMap[1] = 0;
        minColorMap[2] = 1;
        minSum = sum5;
    }
    colorMap[0] = 2;
    colorMap[1] = 1;
    colorMap[2] = 0;
    long sum6 = dfs(root, 0, 0);
    if (sum6 < minSum) {
        minColorMap[0] = 2;
        minColorMap[1] = 1;
        minColorMap[2] = 0;
        minSum = sum6;
    }
    z.println(minSum);
    dfs2(root, 0, 0);
    for (int i = 1; i <= n; i++) {
        z.print(result[i] + " ");
    }
    z.println();
}