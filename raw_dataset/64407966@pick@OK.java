static void pick(int i, int j) {
    // System.out.println(" Pick "+i+" "+j);
    if (pickId[i] != -1)
        return;
    pickId[i] = j;
    long curLookfor = (sum - (curSum[i] - vs[i][j]));
    int nextBucket = valToBucket.get(curLookfor);
    newBox[nextBucket] = i;
    for (int k = 0; k < sz[nextBucket]; k++) {
        if (vs[nextBucket][k] == curLookfor)
            pick(nextBucket, k);
    }
}