/*static double res=0;
	 static void help(int p,int r,int n){
		double tmp=p;
		for(int i=1;i<=n;i++){
			double x=1+(double)r/1200 ;
			tmp*=x;
		}
		res+=tmp;
		int k=100000,m=360;
		for(int i=m;i>0;i--){
			help(k,5,i);
		}
		System.out.println("paid amount "+k*m+" ");
		System.out.println((long)res);
	}
	//static long rest=0l;
	static long resf=0l;
	static int prex=0,prey=0;
	static void dfs1(Map<Integer,Set<Integer>>map, boolean[][] b, boolean[] b1,int x,int[] w,long rest){
		System.out.print(x+"  " );
		b1[x]=true;
		rest+=w[x];
		for(int y:map.get(x)){

			if((prex!=y||prey!=x)&&!b1[y]){
				prex=x;prey=y;
				b[x][y]=true;
			long zz=rest;
				dfs(map,b,b1,y,w,zz);
				b1[y]=false;
			}
		}
		//b1=new boolean[w.length];
		//	b=new boolean[w.length][w.length];
		System.out.println("--->  "+rest+"  ok path completed");
		resf=Math.max(resf,rest); 
	}

	*/
public static boolean dfs(int curr, int prev, boolean[] done, boolean[] ok, long[] w, long[] sumNotOk, ArrayList<Integer>[] g) {
    // System.out.println(curr + " " + prev);
    done[curr] = true;
    for (int next : g[curr]) {
        // System.out.println(curr + " -> " + next + " " + done[next]);
        if (next == prev)
            continue;
        ok[curr] |= done[next];
        if (done[next])
            continue;
        ok[curr] |= dfs(next, curr, done, ok, w, sumNotOk, g);
    }
    if (!ok[curr]) {
        sumNotOk[curr] = w[curr];
        for (int next : g[curr]) if (next != prev)
            sumNotOk[curr] = Math.max(sumNotOk[curr], w[curr] + sumNotOk[next]);
    }
    return ok[curr];
}