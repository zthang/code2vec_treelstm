private static void solve() throws IOException {
    int n = sc.nextInt(), m = sc.nextInt();
    dsu dsuTask = new dsu(n + 1);
    for (int i = 1; i <= m; ++i) {
        int u = sc.nextInt(), v = sc.nextInt();
        dsuTask.merge(dsuTask.dad(u), dsuTask.dad(v));
    }
    int countVertex = 0;
    int minInsertEdge = 0;
    for (int i = 1; i <= n; ++i) {
        ++countVertex;
        if (countVertex < dsuTask.rank[dsuTask.dad(i)]) {
            if (i + 1 <= n) {
                int j = i + 1;
                if (dsuTask.dad(i) != dsuTask.dad(j)) {
                    dsuTask.merge(dsuTask.dad(i), dsuTask.dad(j));
                    ++minInsertEdge;
                }
            }
        } else
            countVertex = 0;
    }
    pr.println(minInsertEdge);
/*int n=sc.nextInt(),i0=-1,j0=-1;
        long in=0;
        long [][][]dp=new long[n][n][2];
        boolean haveZero=false;
        for (int i=0;i<n;++i){
            for (int j=0;j<n;++j) {
                in=sc.nextLong();
                if (in==0){
                    haveZero=true;
                    in=10;
                    i0=i;
                    j0=j;
                }
                long val1=in,val2=in;
                while (val1%2==0){
                    val1/=2;
                    ++dp[i][j][0];
                }
                while (val2%5==0) {
                    val2 /= 5;
                    ++dp[i][j][1];
                }
            }
        }
        for (int i=0;i<n;++i) {
            for (int j = 0; j < n; ++j) {
                if (i==0&&j==0)continue;
                else if (i == 0) {
                    dp[i][j][0] += dp[i][j - 1][0];
                    dp[i][j][1] += dp[i][j - 1][1];
                } else if (j == 0) {
                    dp[i][j][0] += dp[i - 1][j][0];
                    dp[i][j][1] += dp[i - 1][j][1];
                } else {
                    dp[i][j][0] += Math.min(dp[i - 1][j][0], dp[i][j - 1][0]);
                    dp[i][j][1] += Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
                }
            }
        }
        //pr.println("1:"+dp[n-1][n-1][0]+" 2:"+dp[n-1][n-1][1]);
        pr.println(Math.min(dp[n-1][n-1][0],dp[n-1][n-1][1]));
        if (dp[n-1][n-1][0]<=dp[n-1][n-1][1])printPath(true,n-1,n-1,dp);
        else printPath(false,n-1,n-1,dp);
        pr.println(solve.reverse());*/
}