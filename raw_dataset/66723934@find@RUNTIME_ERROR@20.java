	static int find(int i)
	{
		if(ans[i]!=0)
			return ans[i];
		int x=-1;
		if(i+a[i]<=n)
		{
			if(parity(a[i+a[i]])!=parity(a[i]))
				x=1;
			else if(find(i+a[i])==-1)
				x=-1;
			else
				x=1+find(i+a[i]);
		}
		int y=-1;
		if(i-a[i]>=1)
		{
			if(parity(a[i-a[i]])!=parity(a[i]))
				y=1;
			else if(find(i-a[i])==-1)
				y=-1;
			else
				y=1+find(i-a[i]);
		}
		if(x==-1 && y==-1)
			return -1;
		if(x==-1)
			return y;
		if(y==-1)
			return x;
		return Math.min(x,y);

	}