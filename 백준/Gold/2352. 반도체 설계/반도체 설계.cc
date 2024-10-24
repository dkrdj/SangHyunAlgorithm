//  반도체 설계

#include<bits/stdc++.h>

using namespace std;
int n;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    int a[n+1];
    for(int i=1;i<=n;i++) {
        cin >> a[i];
    }
    int long_arr[n];
    long_arr[0] = a[1];
    int cnt = 1;
    for(int i=2;i<=n;i++) {
        if(a[i] > long_arr[cnt-1]) {
            long_arr[cnt] = a[i];
            cnt++;
            continue;
        }
        int target = -1;
        for(int j = cnt -1 ; j >= 0 ; j--) {
            if(a[i] < long_arr[j]) {
                target = j;
            }
        }
        long_arr[target] = a[i];
    }
    cout << cnt << '\n';
    return 0;
}
