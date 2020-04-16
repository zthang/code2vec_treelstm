static void dfsA(int i, int p) {
    // if(i==b){
    // ce=true;
    // return true;
    // 
    // }
    // if(v[i])return false;
    v[i] = true;
    cou++;
    // HashSet<Integer> temp=new HashSet<>();
    for (int j : arr[i]) {
        if (!v[j] && j != b) {
            dfsA(j, i);
        // temp.add(j);
        // f=true;
        // return true;
        }
    }
// for(int j:temp){
// arr[i].remove(j);
// arr[j].remove(i);
// }
// return false;
}