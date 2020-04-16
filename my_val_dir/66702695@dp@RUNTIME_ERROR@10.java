    static int dp(int i,int p) {
    	if(i>n || i<1)
    		return -1;
    	if(memo[i][p]!=-2)
    		return memo[i][p];
    	if(a[i]%2!=p)
    		return 1;
    	int ans=-1;
    	if(a[i]+i<=n) {
    	int o=dp(a[i]+i,p);
    	if(o!=-1)
    		ans=o+1;
    	}
    	if(i-a[i]>=1) {
    		int o=dp(i-a[i],p);
        	if(o!=-1) {
        		if(ans==-1)
        			ans=0;
        		ans+=o+1;
        	}
    	}
    	return memo[i][p]=ans;
    }