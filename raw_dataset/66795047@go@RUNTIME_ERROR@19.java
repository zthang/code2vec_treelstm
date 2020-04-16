        public static int go(int v, int mod) {
        	if (d[v] != -1) return d[v];
        	int left = v - a[v];
        	int right = v + a[v];
        	if (left < 1 && right > n) return -1; else {
        		if (left < 1) {
        			if (a[right] % 2 != mod) return 1; else {
        				int k = go(right, mod);
        				d[v] = k + 1;
        				return d[v];
        			}
        		} else if (right > n) {
        			if (a[left] % 2 != mod) return 1; else {
        				int k = go(left, mod);
        				d[v] = k + 1;
        				return d[v];
        			}
        		} else {
        			int k1 = go(right, mod);
        			int k2 = go(left, mod);
        			d[v] = Math.min(k1, k2) + 1;
        			return d[v];
        		}
        	}
        }