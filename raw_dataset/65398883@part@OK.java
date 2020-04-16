static void part(int osize, int[] pref, int ind, int ans, int ct, int temp) {
    if (ct == osize - 1) {
        list.add((((pref[pref.length - 1] ^ pref[ind - 1])) * (pref.length - ind)) + ans);
        return;
    }
    for (int i = ind; i < pref.length - 1; i++) {
        if (ind == 0)
            temp = pref[i] * (i + 1);
        else
            temp = (pref[i] ^ pref[ind - 1]) * (i - ind + 1);
        ct++;
        part(osize, pref, i + 1, ans + temp, ct, temp);
        ct--;
    }
}