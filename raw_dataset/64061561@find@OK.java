public static int find(int x, int[] pre) {
    int temp = x;
    while (temp != pre[temp]) temp = pre[temp];
    int i = x, j;
    while (i != temp) {
        j = pre[i];
        pre[i] = temp;
        i = j;
    }
    return temp;
}