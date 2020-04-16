/**
 * 		1. We compute the prefix values π[i] in a loop by iterating 	<br/>
 * 				from i=1 to i=n−1 (π[0] just gets assigned with 0).		<br/><br/>
 * 		2. To calculate the current value π[i] we set the variable j 	<br/>
 * 				denoting the length of the best suffix for i−1. Initially j=π[i−1].	<br/>
 * 		3. Test if the suffix of length j+1 is also a prefix by		 <br/><br/>
 * 				comparing s[j] and s[i]. If they are equal then we assign π[i]=j+1, 	<br/>
 * 				otherwise we reduce j to π[j−1] and repeat this step.		<br/><br/>
 * 		4. If we have reached the length j=0 and still don't have a match,	<br/>
 * 				then we assign π[i]=0 and go to the next index i+1.		<br/><br/>
 *
 * 		@param
 * 	 	pattern(String)
 * *
 */
private List<Integer> getPrefixTable(char[] pattern) {
    List<Integer> prefixTable = new ArrayList<Integer>();
    int n = pattern.length;
    for (int i = 0; i < n; i++) {
        prefixTable.add(0);
    }
    for (int i = 1; i < n; i++) {
        for (int j = prefixTable.get(i - 1); j >= 0; ) {
            if (pattern[j] == pattern[i]) {
                prefixTable.set(i, j + 1);
                break;
            } else if (j > 0) {
                j = prefixTable.get(j - 1);
            } else {
                break;
            }
        }
    }
    return prefixTable;
}