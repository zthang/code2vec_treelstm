    static boolean dfs(int r,int c,int pr,int pc){
        if (ans[r][c]!='-')return false;
        ans[r][c]=res(r,c,pr,pc);
        vis[r][c]=true;
        for (int i=0;i<4;i++){
            int newR=dirR[i]+r;
            int newC=dirC[i]+c;
            if (isValid(newR,newC) && !vis[newR][newC] && p[newR][newC].equals(tmp)){
                if (!dfs(newR,newC,r,c))return false;
            }
        }
        return true;
    }