     public static void cal(int k,int dis[], int a[],int n){
          
          if(k-a[k]<=0 && k+a[k]>n){
               dis[k]=-1;
               return;
          }
          else if(k-a[k]<=0 && k+a[k]<=n){
               if(!((a[k]%2==0 && a[k+a[k]]%2!=0) || (a[k]%2!=0 && a[k+a[k]]%2==0))){
                    if(dis[k+a[k]]==0){
                         cal(k+a[k],dis,a,n);
                    }
                    dis[k]=1+dis[k+a[k]];
               }
               else{
                    dis[k]=1;
               }
          }
          else if(k-a[k]>0 && k+a[k]>n){
               if(!((a[k]%2==0 && a[k-a[k]]%2!=0) || (a[k]%2!=0 && a[k-a[k]]%2==0))){
                    if(dis[k-a[k]]==0){
                         cal(k-a[k],dis,a,n);
                    }
                    dis[k]=1+dis[k-a[k]];
               }
               else{
                    dis[k]=1;
               }
          }
          else{
               if(!(((a[k]%2==0 && a[k+a[k]]%2!=0) || (a[k]%2!=0 && a[k+a[k]]%2==0)) || ((a[k]%2==0 && a[k-a[k]]%2!=0) || (a[k]%2!=0 && a[k-a[k]]%2==0)))){
                    if(dis[k+a[k]]==0){
                         cal(k+a[k],dis,a,n);
                    }
                    if(dis[k-a[k]]==0){
                         cal(k-a[k],dis,a,n);
                    }
                    dis[k]=1+Math.min(dis[k-a[k]],dis[k+a[k]]);
               }
               else{
                    dis[k]=1;
               }
          }
     }