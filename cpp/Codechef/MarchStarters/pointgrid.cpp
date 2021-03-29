#include<bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin >> n;
        int arr[n];
        int max = -1;
        for(int i=0;i<n;i++){
            cin >> arr[i];
            if(max < arr[i]){
                max = arr[i];
            }
        }

        
    }
    return 0;
}