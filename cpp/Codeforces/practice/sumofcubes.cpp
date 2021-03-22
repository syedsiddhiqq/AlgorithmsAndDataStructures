
#include<bits/stdc++.h>
using namespace std;

using ll = long long;

ll n = 1000000000000L;

unordered_set<ll> cubes;


void preCalculate(){
    for(ll i=1;i*i*i <= n;i++){
        cubes.insert(i * i * i);
    }
}

void solve(){
    ll x;
    cin >> x;
    for(ll i=1;i * i * i <= x ; i++){
        if(cubes.count(x - i * i * i)){
            cout << "YES" << endl;
            return;
        }
    }
    cout<< "NO" << endl;
}

int main(){
    preCalculate();
    int t;
    cin >> t;
    while(t--){
        solve();
    }
    return 0;
}