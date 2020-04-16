    void go(int rt,Set<Integer> vis,int n){
        vis.remove(rt);
        for(int i:vis){
            if(!g[rt].contains(i)){
                go(i,vis,n);
            }
        }

    }