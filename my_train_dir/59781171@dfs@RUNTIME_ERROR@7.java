    static void dfs(int start,int par,int max){
        //debug(start,par,max);

        for(Pair p:graph[start]){
            if(p.u!=par){
                if(p.v>max){
                    list[p.v].add(subtree[p.u]);
                }
                dfs(p.u,start,Math.max(max,p.v));
            }
        }
    }