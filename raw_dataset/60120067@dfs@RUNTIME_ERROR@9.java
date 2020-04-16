    static void dfs(int node,int ret,int c){
        for (int i =ret;i<adjmat.length;i++){
            if (adjmat[node][i]>0){
                if (i==ret){
                    ans[adjmat[node][i]]=c+1;
                }
                else{
                    ans[adjmat[node][i]]=c;
                    dfs(i,ret,c);
                }
            }
        }
    }