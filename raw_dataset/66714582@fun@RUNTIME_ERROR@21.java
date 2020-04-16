    static int fun(int pp , int i  , int hops){
        if (i<0 || i >= n){
            return Integer.MAX_VALUE;
        }
        if (v[i]==true){
            if ((pp ^ parity[i])==1){
                return hops;
            }
            else{
                if (ans[i]==Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                else{
                    return ans[i] + 1;
                }
            }
        }
        if ((pp ^ parity[i])==1){
            return hops;
        }
        int num1 = fun(parity[i] , i + arr[i] , 1);
        int num2 = fun(parity[i] , i - arr[i] , 1);
        ans[i] = Math.min(num1,num2);
        v[i] = true;
        if (ans[i]==Integer.MAX_VALUE){
            return ans[i];
        }
        else{
            return ans[i] + hops;
        }

    }