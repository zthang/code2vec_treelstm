static int LongestIncreasingSubsequenceLength(int[] A, int size) {
    // Add boundary case, when array size is one
    int[] tailTable = new int[size];
    // always points empty slot
    int len;
    tailTable[0] = A[0];
    len = 1;
    for (int i = 1; i < size; i++) {
        if (A[i] < tailTable[0])
            // new smallest value
            tailTable[0] = A[i];
        else if (A[i] > tailTable[len - 1])
            // A[i] wants to extend largest subsequence
            tailTable[len++] = A[i];
        else
            // A[i] wants to be current end candidate of an existing
            // subsequence. It will replace ceil value in tailTable
            tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
    }
    for (int i = 0; i < len; i++) System.out.println(tailTable[i]);
    return len;
}