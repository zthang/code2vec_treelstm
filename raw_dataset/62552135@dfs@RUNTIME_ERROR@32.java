	public static void dfs(int x,int color,int sum,int temp[])
	{
		if(du[x]==1&&x!=root)
		{
			int aa=Integer.MAX_VALUE;
			for(int i=1;i<=3;i++)
			{
				if(i!=color)
				{
					if(cost[i][x]<aa)
					{
						aa=cost[i][x];
						temp[x]=i;
					}
				}
			}
			if(sum+aa<ans)
			{
				ans=sum+aa;
				list=temp.clone();
				//System.out.println(x+" "+temp[x]+" "+ans);
			}
		}
		else
		{
			for(int i=1;i<=3;i++)
			{
				if(i!=color&&sum+cost[i][x]<ans)
				{
					int next=E[x].get(0);
					temp[x]=i;//System.out.println(x+" "+i+" "+(sum+cost[i][x]));
				dfs(next,i,sum+cost[i][x],temp.clone());
				}
			}
		}
		
	}