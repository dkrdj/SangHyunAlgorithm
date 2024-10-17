#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, s, cute = 0, uncute = 0;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> s;
        if (s == 0)
        {
            uncute++;
        }
        else
        {
            cute++;
        }
    }

    string str = (cute > uncute) ? "cute!" : "not cute!";

    cout << "Junhee is " << str;

    return 0;
}