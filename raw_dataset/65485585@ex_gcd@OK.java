// int g[][] = {{1,2,3},{0,3,4},{0,3},{0,1,2,4},{1,3}};
// int res= 0;
// void go(int i,int a[],int x[],boolean ck[]){
// if(i==5){
// int an = 0;
// for(int j=0;i<5;++j){
// int id = a[j];
// if(ct[id]>3) continue;
// int all =0;
// for(int g:g[id]){
// all |= a[g];
// }
// if(all&(gz[id])==gz[id]){
// an++;
// }
// }
// if(an>res){
// res = an;
// }
// return;
// }
// for(int j=0;j<5;++j){
// if(!ck[j]){
// ck[j] = true;
// a[i] = x[j];
// go(i+1,a,x,ck);
// ck[j]  = false;
// }
// }
// 
// 
// }
// x = r[0], y = r[1] , gcd(x,y) = r[2]
public static long[] ex_gcd(long a, long b) {
    if (b == 0) {
        return new long[] { 1, 0, a };
    }
    long[] r = ex_gcd(b, a % b);
    return new long[] { r[1], r[0] - (a / b) * r[1], r[2] };
}