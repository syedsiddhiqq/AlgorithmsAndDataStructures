#include<bits/stdc++.h>
#define ll long long
#define pb push_back
#define fr(a,b) for(int i = a; i < b; i++)
#define rep(i,a,b) for(int i = a; i < b; i++)
#define mod 1000000007
#define inf (1LL<<60)
#define all(x) (x).begin(), (x).end()
#define prDouble(x) cout << fixed << setprecision(10) << x
#define triplet pair<ll,pair<ll,ll>>
#define goog(tno) cout << "Case #" << tno <<": "
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL)
#define read(x) int x; cin >> x
using namespace std;
 
void init_code(){
    fast_io;
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif 
}
 
int main() {
   init_code();
   int t = 1; cin >> t;
   while(t--){
       read(n); std::vector<int> prefixMax(n); fr(0, n) cin >> prefixMax[i];
       std::vector<int> minimal, maximal; set<int> nums;
       
       int curr_max = 0;
       fr(1,n+1) nums.insert(i);
       for(int i = 0; i < n; i++){
          int chosenNumber;
          if(curr_max < prefixMax[i])chosenNumber = prefixMax[i];
          else chosenNumber = *nums.begin();
          nums.erase(chosenNumber);
          minimal.push_back(chosenNumber);
          curr_max = max(curr_max, minimal.back());
       }
 
       curr_max = 0;
       fr(1,n+1) nums.insert(i);
       for(int i = 0; i < n; i++){
          int chosenNumber;
          if(curr_max < prefixMax[i])chosenNumber = prefixMax[i];
          else chosenNumber = *(--(nums.lower_bound(prefixMax[i])));
          nums.erase(chosenNumber);
          maximal.push_back(chosenNumber);
          curr_max = max(curr_max, maximal.back());
       }
 
       fr(0,n) cout << minimal[i] << ' '; cout << '\n';
       fr(0,n) cout << maximal[i] << ' '; cout << '\n';
 
   }
   return 0;
}