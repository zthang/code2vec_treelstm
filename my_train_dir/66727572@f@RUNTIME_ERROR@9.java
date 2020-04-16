	public static int f(int[] arr,int i,int a) {
		if(arr[i]%2!=a%2)
			return 0;
		if(dp[i][a%2]!=-1)return dp[i][a%2];
		int m = Integer.MAX_VALUE;
		int n = Integer.MAX_VALUE;
		boolean t = false;
		if(i+arr[i]<arr.length) {
			m = 1+f(arr,i+arr[i],arr[i]);
			t = true;
		}
		if(i-arr[i]>=0) {
			t= true;
			n = 1+f(arr,i-arr[i],arr[i]);
		//	System.out.println(n);
		}
		if(t)
			return dp[i][a%2] = Math.min(m, n);
		return Integer.MIN_VALUE;
	}