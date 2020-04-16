// public class Vertex {
// Vertex father;
// Vertex l;
// Vertex r;
// int sz;
// long y;
// long x;
// int time;
// int mintime;
// int value;
// 
// public Vertex(Vertex father, Vertex l, Vertex r, int sz, long y, long x, int
// time, int mintime, int value) {
// this.father = father;
// this.l = l;
// this.r = r;
// this.sz = sz;
// this.y = y;
// this.x = x;
// this.time = time;
// this.mintime = mintime;
// this.value = value;
// }
// 
// public Vertex(long x, int time, int value) {
// this.father = null;
// this.l = null;
// this.r = null;
// this.sz = 1;
// this.y = random.nextLong();
// this.x = x;
// this.time = time;
// this.mintime = time;
// this.value = value;
// }
// 
// public void update() {
// sz = 1;
// mintime = time;
// if (l != null) {
// sz += l.sz;
// mintime = Math.min(time, mintime);
// }
// if (r != null) {
// sz += r.sz;
// mintime = Math.min(time, mintime);
// }
// }
// }
// 
// public void add0(Vertex v, Vertex v1, Vertex father) {
// if (v == null) {
// v1.father = father;
// father.r = v1;
// father.update();
// return;
// }
// if (v.y >= v1.y) {
// add0(v.r, v1, v);
// father.update();
// return;
// }
// father.r = v1;
// v1.father = father;
// v.father = v1;
// v1.l = v;
// v1.update();
// father.update();
// }
// 
// public Vertex pop(Vertex v, Vertex father, int h) {
// if (v.l == null) {
// if (h == 0) {
// father.r = v.r;
// } else {
// father.l = v.r;
// }
// if (v.r != null) {
// v.r.father = father;
// v.r.update();
// }
// father.update();
// v.father = null;
// v.r = null;
// v.update();
// return v;
// }
// Vertex ans = pop(v.l, v, h + 1);
// father.update();
// return ans;
// }
// 
// public void cut(Vertex rl, Vertex rr, Vertex v, int mint) {
// 
// }
// 
// public int push(Vertex v, Vertex v1, Vertex father, boolean rson, int szl) {
// 
// }
// 
// Vertex root0;
// public class State implements Comparable<State> {
// int[] a;
// 
// public State(int[] a) {
// this.a = a;
// }
// 
// @Override
// public int compareTo(State o) {
// for (int i = 0; i < a.length; i++) {
// if (a[i] != o.a[i]) {
// return a[i] - o.a[i];
// }
// }
// return 0;
// }
// }
public long[][] mult(long[][] a, long[][] b) {
    int n = a.length;
    long[][] c = new long[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                c[i][j] += a[i][k] * b[k][j];
                c[i][j] %= mod;
            }
        }
    }
    return c;
}