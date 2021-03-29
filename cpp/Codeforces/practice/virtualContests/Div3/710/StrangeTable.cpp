/*
 * @Author: SyedAli 
 * @Date: 2021-03-29 13:24:40 
 * @Last Modified by: SyedAli
 * @Last Modified time: 2021-03-29 13:31:14
 */
#include<bits/stdc++.h>
#define ll long long
using namespace std;

void solve(){
    ll n,m,x;
    cin >> n >> m >> x;
    ll colPosition = (x - 1) / n;
    ll rowPosition = (x - 1) % n;

    cout << (rowPosition ) * m + (colPosition + 1)<< endl;
}

int main(){
    int t;
    cin >> t;
    while(t--){
        solve();
    }
    return 0;
}