    public static void solve(int a[],int curr,int n,int b[]){
//        print(b,n);
        for(int i=curr;i<=n;i++){
            if(b[i]!=0){
                continue;
            }
            int left=i-a[i];
            int right=i+a[i];
            if(left>=0){
                if(a[i]%2==0&&a[left]%2==1){
                    b[i]=1;
                    continue;
                }
                else if(a[i]%2==1&&a[left]%2==0){
                    b[i]=1;
                    continue;
                }
            }
            if(right<=n){
                if(a[i]%2==0&&a[right]%2==1){
                    b[i]=1;
                    continue;
                }
                else if(a[i]%2==1&&a[right]%2==0){
                    b[i]=1;
                    continue;
                }
            }
            int op1=Integer.MAX_VALUE,op2=Integer.MAX_VALUE;
            if(left>=0) {
                if(b[left]==0)
                solve(a, left, n, b);
                op1=b[left];
            }
            if(right<=n) {
                if(b[right]==0)
                solve(a, right, n, b);
                op2=b[right];
            }
            if(op1==Integer.MAX_VALUE&&op2==Integer.MAX_VALUE){
                b[i]=-1;
            }
            else {
                b[i] = Math.min(op1, op2)+1;
            }
        }
        return;
    }