	public static void solve() throws IOException {
	    // Read inputs
	    st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if(n==1) {
		    System.out.println("No");
		    return;
		}
		if(n==m){
		    System.out.println("Yes");
		    return;
		}
		
		for(int i = 0; i<n+1; i++){
		    v[1][i] = new ArrayList<Integer>();
		    v[0][i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<m; i++){
    	    st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
		    v[0][a].add(b);
		    v[1][b].add(a);
		}
		if (findSCC(0,n) != "Yes" && findSCC(1,n) != "Yes") {
		    System.out.println("No");
		}
		br.readLine();
		
	}