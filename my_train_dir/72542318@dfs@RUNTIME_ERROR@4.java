    static boolean dfs(int r,int c,int pr,int pc,int sr,int sc){
        vis[r][c]=true;
        if (ans[r][c]!='-')return false;
        ans[r][c]=res(r,c,pr,pc);
        for (int i=0;i<4;i++){
            int newR=dirR[i]+r;
            int newC=dirC[i]+c;
            if (isValid(newR,newC) && !vis[newR][newC] && p[newR][newC].equals(new Point(sr,sc))){
                if (!dfs(newR,newC,r,c,sr,sc))return false;
            }
        }
        return true;
    }