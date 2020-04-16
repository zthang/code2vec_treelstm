    void solve(){
        int t = ni();
        for(int i=0;i<t;++i){
            int n = ni();
            int m = ni();
            int a = ni()-1;
            int b = ni()-1;
            init(n);
            g = new ArrayList[n];
            for(int j=0;j<n;++j){
                g[j] = new ArrayList<>();
            }
//            color[],dfn[],low[],stack[],cnt[];
            color = new int[n];
            dfn = new int[n];
            low = new int[n];
            stack =new int[n*10];
            cnt = new int[n+10];

             vis = new boolean[n];
             iscut = new boolean[n];
            deep = 0;top = 0;sum = 0;ans = 0;
            for(int j=0;j<m;++j){
                int u  = ni()-1;
                int v  = ni()-1;
                g[u].add(v);
                g[v].add(u);

            }

            for(int j=0;j<n;j++)
            {
                if(0==dfn[j])
                {
                    tarjan(j,-1);
                }
            }
            for(int j=0;j<n;j++)
            {
                cnt[color[i]]++;
            }
            if(iscut[a]&&iscut[b]){
                hasV  = false;
                hasU  = false;
                vis = new boolean[n];
                long c =1;

                for(int j=0;j<n;++j){
                    if(j==a||j==b||vis[j]) continue;
                    ct = 0;
                    hasV  = false;
                    hasU  = false;
                    dfs(j,-1,a,b);

                    if(hasV&&hasU){

                    }else{
                        c *= ct;
                    }
                }
                println(c);

            }else{
                println(0);
            }


        }

    }