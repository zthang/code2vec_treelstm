// static int find(Pair pr[],int i)
// {
// if(i==pr[i].parent)
// return i;
// else
// {
// pr[i].parent=find(pr,pr[i].parent);
// return pr[i].parent;
// }
// }
// static void join(Pair[] pr,int i,int j)
// {
// i=find(pr,i);
// j=find(pr,j);
// if(i==j)
// return;
// if(pr[i].rank>=pr[j].rank)
// {
// pr[j].parent=i;
// pr[i].rank+=pr[j].rank;
// }
// else
// {
// pr[i].parent = j;
// pr[j].rank+=pr[i].rank;
// }
// }
static void swap(char[] ar, int i, int j) {
    char f = ar[i];
    ar[i] = ar[j];
    ar[j] = f;
}