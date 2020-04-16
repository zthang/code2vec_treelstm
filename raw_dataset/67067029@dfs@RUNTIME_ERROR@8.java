		int dfs(int arr[], int cur, int pre, int count[]) {
			if(cur-arr[cur]<0&&arr[cur]+cur>=arr.length) return count[cur] = 999999999;
			if(cur-arr[cur]>=0&&arr[cur]%2!=arr[cur-arr[cur]]%2) return count[cur] = 1;
			if(cur+arr[cur]<arr.length&&arr[cur]%2!=arr[cur+arr[cur]]%2) return count[cur] = 1;
			if(count[cur]<999999999) return count[cur];
			int l = 999999999;
			int r = 999999999;
			if(cur-arr[cur]>=0&&cur-arr[cur]!=pre) l = dfs(arr,cur-arr[cur],cur,count);
			if(cur+arr[cur]<arr.length&&cur+arr[cur]!=pre) r = dfs(arr,cur+arr[cur],cur,count);
			return count[cur] = Math.min(l, r)+1;
		}