    static int solve (int index){
        if (memo[index] != -2)
            return memo[index];
        int elem = arr[index];
        boolean pair = elem % 2 == 0;
        int nextIndex = index + elem;
        int op1 = -1;
        if (nextIndex < n){
            int nextElem = arr[nextIndex];
            boolean pair2 = nextElem % 2 == 0;
            if (pair ^ pair2){
                op1 = 1;
            } else {
                op1 = solve(nextIndex);
                if (op1 != -1) op1++;
            }
        }
        int op2 = -1;
        int pastIndex = index - elem;
        if (pastIndex >= 0){
            int lastElem = arr[pastIndex];
            boolean pair2 = lastElem % 2 == 0;
            if (pair ^ pair2){
                op2 = 1;
            } else { 
                op2 = solve(pastIndex);
                if (op2 != -1) op2++;
            }
        }
        
        int ans;
        if (op1 == -1)
            ans = op2;
        else if (op2 == -1)
            ans = op1;
        else
            ans = Math.min(op1, op2);
        return memo[index] = ans;
    }