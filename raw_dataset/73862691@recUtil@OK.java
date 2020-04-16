/*
	static class SegmentTree {
        public int[] seg;
        public int N;
        public int size;

        public SegmentTree(int n) {
            
        	int h = (int)Math.ceil((double)Math.log(n)/Math.log(2));
        	
        	this.size = (int)Math.pow(2,h)*2-1;
        	seg = new int[size];
        }



        public int update(int l, int r, int i, int val) {
        	
        	
        	if(l == r && l == val)
        	{
        		seg[i]++;
        		return seg[i];
        	}
        	if(l > r || l == r || val > r || val < l) return seg[i];
            int m = (l+r) >>> 1;
            
            int left = update(l,m,2*i+1,val);
            
            int right = update(m+1,r,2*i+2,val);
            
            seg[i] = left+right;
            return seg[i];
        }

        

        public int getValue(int l, int r, int i, int ql, int qr) {
        	
            if (l > r || ql > qr || l > qr || r < ql) return 0;
            if (l == r) {
                return seg[i];
            }
            if (l >= ql && r <= qr) {
                return seg[i];
            }
            int m = (l + r) >>> 1;
            return getValue(l, m, 2 * i + 1, ql, qr) + getValue(m + 1, r, 2 * i + 2, ql, qr);
        }

    }
	
	public static int gcd(int a,int b)
	{
		if(a == 0) return b;
		if(b == 0) return a;
		
		return gcd(b, a%b);
	}
*/
public static void recUtil(int i) {
    if (ar[i].size() > 0 && map[i] == 0) {
        map[i] = i + 1;
    }
    for (String s : ar[i]) {
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map[ch - 'a'] == 0) {
                map[ch - 'a'] = map[i];
                recUtil(ch - 'a');
            }
        }
    }
}