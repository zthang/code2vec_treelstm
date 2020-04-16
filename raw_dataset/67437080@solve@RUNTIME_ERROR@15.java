	    public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
	    	int t=1;
	    	while(t-->0) { 
	    		int n=in.nextInt();
	    		int m=in.nextInt();
	    		edges=new ArrayList[n];
	    		for(int i=0;i<n;i++) {
	    			edges[i]=new ArrayList<Integer>();
	    		}
	    		vis=new boolean[n];
	    		for(int i=0;i<m;i++) {
	    			int x=in.nextInt();
	    			int y=in.nextInt();
					edges[x].add(y);
					edges[y].add(x);
	    				
	    		}
	    		int res=0;
	    		for(int i=0;i<n;i++) {
	    			if(!vis[i]) {
	    				if(i<mx) {
	    					res++;
	    				}
	    				dfs(i);
	    			}
	    		}
	    		out.println(res);
	    		
	        }
	 
	    }