		private static int dfs(int[] T, int i, int j) {
			if(j>=0 && j<T.length) {
				if(T[j]%2!=T[i]%2)return 0;
				else {
					int x=dfs(T,i,j+T[j]);
					int y=dfs(T,i,j-T[j]);
					if(x==y && x==-1)return -1;
					else if(x==-1)return 1+y;
					else if(y==-1)return 1+x;
					else return 1+Math.min(x, y);
				}
			}else return -1;
		}