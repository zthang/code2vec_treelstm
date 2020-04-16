			static int recur(int[] a,int index,int odd)
			{
				if(index>=a.length || index<0)
					return -1;
				if(a[index]%2!=odd)
					return 0;
				if(a[index]%2==odd && dp[index]!=-1)
					return dp[index];
				int ans=Integer.MAX_VALUE;
				int value=recur(a,index+a[index],odd);
				int value1=recur(a,index-a[index],odd);
				visited[index]=true;
				if(value!=-1)
					ans=Math.min(ans,1+value);
				if(value1!=-1)
					ans=Math.min(ans,1+value1);
				dp[index]=ans;
				if(ans==Integer.MAX_VALUE)
					dp[index]=-1;
				return dp[index];
			}