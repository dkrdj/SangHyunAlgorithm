#include <bits/stdc++.h>
using namespace std;

int N,M;

vector<int> v;
void solve(int start) {
    if(v.size() == M) {
        for(int i : v) {
            cout << i << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = start ; i <= N ; i++) {
        v.push_back(i);
        solve(i+1);
        v.pop_back();
    }
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    solve(1);

    return 0;
}
