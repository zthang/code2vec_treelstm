// if one has nobody to marry, add the leftover kingdom to her's
// for each daughter, go through her list, set the top prince as occupied in boolean array
public static int[] findMissing(LinkedList<int[]> allPrincesses, boolean[] princeAvail) {
    // for (int i = 0; i < allPrincesses.size(); i++){
    Iterator<int[]> it = allPrincesses.iterator();
    int j = 1;
    int waitingPrincess = -1;
    // }
    while (it.hasNext()) {
        int[] currentPrincess = it.next();
        boolean isMarried = false;
        for (int i = 0; i < currentPrincess.length; i++) {
            if (princeAvail[currentPrincess[i]] == true) {
                princeAvail[currentPrincess[i]] = false;
                isMarried = true;
                break;
            }
        }
        if (!isMarried) {
            waitingPrincess = j;
        }
        j++;
    }
    int waitingPrince = -1;
    if (waitingPrincess != -1) {
        for (int i = 0; i < princeAvail.length; i++) {
            if (princeAvail[i]) {
                waitingPrince = i;
                break;
            }
        }
        int[] ans = { waitingPrincess, waitingPrince };
        return ans;
    } else {
        int[] ans = { -1, -1 };
        return ans;
    }
}