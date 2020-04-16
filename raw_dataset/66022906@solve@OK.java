private static void solve() throws IOException {
    int n = sc.nextInt();
    dsu dsuTask = new dsu(257);
    String[] in = new String[n];
    for (int i = 0; i < n; ++i) {
        String s = sc.next();
        in[i] = s;
        for (int j = 0; j < s.length() - 1; ++j) {
            dsuTask.merge(dsuTask.dad((int) s.charAt(j)), dsuTask.dad((int) s.charAt(j + 1)));
        }
    }
    int minAns = 0;
    TreeSet<Character> characters = new TreeSet<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < in[i].length(); ++j) {
            characters.add((char) dsuTask.dad((int) in[i].charAt(j)));
        }
    }
    pr.println(characters.size());
// pr.println(characters);
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