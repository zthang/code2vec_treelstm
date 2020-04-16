	public static void fill(int at) {
		if(res[at]!=-1) return;
		for(int nxt:a[at]) fill(nxt);
		
		int num=c[at]-1;
		ArrayList<Integer> temp=new ArrayList<>();
		for(int i=pre[at]+1;i<=post[at];i++) temp.add(res[i]);
		Collections.sort(temp);
		int greater=temp.get(num);
//		System.out.println(temp);
		int less;
		if(temp.size()>num+1) less=temp.get(num+1);
		else less=1000000000;
//		System.out.println(at+" "+greater+" "+less);
		res[at]=(greater+less)/2;
	}