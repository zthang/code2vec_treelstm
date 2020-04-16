	static void process() throws Exception {

		out = new BufferedWriter(new OutputStreamWriter(System.out));
		reader = new InputReader(System.in);

		int T=reader.readInt();
		for (int t=0;t<T;t++) {
			int n=reader.readInt();
			int[] a=new int[n];
			Composite[] ar=new Composite[n];
			int tgt=-1;
			TreeSet<Composite> neg=new TreeSet<Composite>();
			TreeSet<Composite> pos=new TreeSet<Composite>();

			for (int i=0;i<n;i++) {
				a[i]=reader.readInt();
				ar[i]=new Composite(Math.abs(a[i]),i);
				if (a[i]==0) {
					tgt=i;
				} else 
					if (a[i]<0)
						neg.add(ar[i]);
					else
						pos.add(ar[i]);
			}
			if (tgt>=0) {
				output("1");
				output((tgt+1));
			} else {
				// must remain between 0 and n-1
				boolean goon=true;
				int cur=0;
				int[] stack=new int[n];
				int st=0;
				int[] mem=new int[n];
				int MX=Integer.MAX_VALUE;
				Arrays.fill(mem, MX);
				mem[0]=-1;

				loop:while (goon) {
					//log("looping !!!");
					//log(neg);
					//log(pos);
					//log("cur:"+cur);

					// positive
					//log("cur:"+cur);
					int rem=n-1-cur;
					Composite bob=new Composite(rem+1,0);
					Composite X=pos.lower(bob);
					if (X!=null) {

						cur+=X.v;
						pos.remove(X);

						stack[st]=X.idx;
						if (mem[cur]!=MX) {
							output(st-mem[cur]);
							for (int i=mem[cur]+1;i<=st;i++) {
								outputWln((stack[i])+1+" ");
							}
							output("");
							break loop;
						}
						mem[cur]=st;
						st++;
					}
					if (cur<0 || cur>n-1) {
						log("problem");
						int x=1/0;
					}
					//log("cur:"+cur);
					rem=cur;
					bob=new Composite(rem+1,0);
					X=neg.lower(bob);
					if (X!=null) {

						//log("case 2");
						cur-=X.v;
						neg.remove(X);

						stack[st]=X.idx;
						if (mem[cur]!=MX) {
							output(st-mem[cur]);
							for (int i=mem[cur]+1;i<=st;i++) {
								outputWln((stack[i])+1+" ");
							}
							output("");
							break loop;
						}
						mem[cur]=st;
						st++;

					}

					if (cur<0 || cur>n-1) {
						log("problem");
						int x=1/0;
					}
				}
			}

		}

		try {
			out.close();
		} catch (Exception e) {
		}

	}