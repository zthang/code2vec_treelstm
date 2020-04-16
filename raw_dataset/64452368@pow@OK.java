// static long pow(long x,long y)
// {
// int m=1000000007;
// x=x%m;
// if(y==1)
// return x;
// long ans=1;
// long val=pow(x,y/2)%m;
// ans=(val*val)%m;
// if(y%2!=0)
// {
// ans=(val*x)%m;
// }
// return ans%m;
// }
static long pow(long x, long y) {
    int p = 1000000007;
    long res = 1;
    x = x % p;
    while (y > 0) {
        if ((y & 1) == 1)
            res = (res * x) % p;
        y = y >> 1;
        x = (x * x) % p;
    }
    return res;
}