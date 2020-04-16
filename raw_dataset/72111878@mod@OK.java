// private static boolean check(int x,int y){
// if((x>=0&&x<n)&&(y>=0&&y<m)&&mat[x][y]!='X'&&!visited[x][y])return true;
// return false;
// }
public static int mod(int n, int c) {
    if (n < 0)
        return n % c + c;
    return n % c;
}