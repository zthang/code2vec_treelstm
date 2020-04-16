    static void solve(int i, int j, char c)
    {
        if(i > n || i == 0 || j > n || j == 0)
        {
            return;
        }
        ans[i][j] = c;
        int a = mat[i][j].f, b = mat[i][j].s;

        for(int k = 0; k < 4; k++)
        {
            int p = mat[i + x[k]][j + y[k]].f, q = mat[i + x[k]][j + y[k]].s;
            if(p == a && q == b)
            {
                if(ans[i + x[k]][j + y[k]] == null)
                {
                    solve(i + x[k], j + y[k], d[3 - k]);
                }
            }
        }
    }