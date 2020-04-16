    public void dfs(int a,int b,Pair[][] arr,char[][] ans ,int x ,int y,char ch)
    {
        ans[a][b]=ch;
        int tmp=a,tmp1=b;
        tmp++;
        if(f(tmp,tmp1,arr.length))
            if((arr[tmp][tmp1].a==x&&arr[tmp][tmp1].b==y)&&(ans[tmp][tmp1]=='@'))
                dfs(tmp,tmp1,arr,ans,x,y,'U');
        tmp--;
        tmp1++;
        if(f(tmp,tmp1,arr.length))
            if((arr[tmp][tmp1].a==x&&arr[tmp][tmp1].b==y)&&(ans[tmp][tmp1]=='@'))
                dfs(tmp,tmp1,arr,ans,x,y,'L');
        tmp1--;
        tmp--;
        if(f(tmp,tmp1,arr.length))
            if((arr[tmp][tmp1].a==x&&arr[tmp][tmp1].b==y)&&(ans[tmp][tmp1]=='@'))
                dfs(tmp,tmp1,arr,ans,x,y,'D');
        tmp++;
        tmp1--;
        if(f(tmp,tmp1,arr.length))
            if((arr[tmp][tmp1].a==x&&arr[tmp][tmp1].b==y)&&(ans[tmp][tmp1]=='@'))
                dfs(tmp,tmp1,arr,ans,x,y,'R');
        tmp1++;
    }