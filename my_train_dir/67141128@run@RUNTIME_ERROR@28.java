    public void run()
    {
        InputReader sc = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
		
		int n=sc.nextInt(),m=sc.nextInt();
		
		long bal[]= new long[n+1];
		
		for(int i=0;i<m;i++)
		{
			int u=sc.nextInt(),v=sc.nextInt(),x=sc.nextInt();
			bal[u]-=x;
			bal[v]+=x;
		}
		
		StringBuilder ans = new StringBuilder();
		int counter=0;
		
		for(int i=1;i<n+1;i++)
		{
			if(bal[i]==0) continue;
			else if(bal[i]<0)
			{
				int j=i+1;
				while(bal[i]<0)
				{
					if(bal[j]>=Math.abs(bal[i]))
					{
						ans.append(i+" "+j+" "+Math.abs(bal[i])+"\n");
						bal[j]-=Math.abs(bal[i]);
						bal[i]=0;
						counter++;
					}
					else if(bal[j]>0)
					{
						bal[i]+=bal[j];
						ans.append(i+" "+j+" "+bal[j]+"\n");
						bal[j]=0;
						counter++;
					}
					j++;
				}
			}
		}
		
		w.println(counter);
		w.println(ans);
		
		
        System.out.flush();
        w.close();
    }