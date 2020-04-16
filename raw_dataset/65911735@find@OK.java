/*static long power(long x, long y, long p) 
{ 
    long res = 1;      // Initialize result 
  
    x = x % p;  // Update x if it is more than or  
                // equal to p 
  
    /*while (y > 0) 
    { 
        // If y is odd, multiply x with result 
        if ((y & (long)1)%2!=0) 
            res = (res*x) % p; 
  
        // y must be even now 
        y = y>>1; // y = y/2 
        x = (x*x) % p;   
    } */
// return res%p;
static int find(int x) {
    // that x is an element of
    while (parent[x] != x) {
        // if x is not the parent of itself
        // Then x is not the representative of
        // his set,
        x = parent[x];
    // so we recursively call Find on its parent
    // and move i's node directly under the
    // representative of this set
    }
    return x;
}