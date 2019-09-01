#include <iostream>
#include <vector>

using namespace std;

// 统计 >= x的数量
        int helper(int x, const vector<int> & a, const vector<int> & b) {
        int n = a.size();
        int m = b.size();
        int c = 0, j = m-1;
        for(int i = 0; i < n; i++){
        for (; j >= 0; j--) {
        if (a[i] * b[j] >= x) {
        c += j+1;
        break;
        }
        }
        }
        return c;
        }
        int main() {
        int n, m, k;
        cin >> n >> m >> k;
        vector<int> a(n, 0);
        for (int i = 0; i < n; i++) {
        a[i] = n - i;
        }
        vector<int> b(m, 0);
        for (int i = 0; i < m; i++) {
        b[i] = m - i;
        }

        int mid;
        int l = a[n-1] * b[m-1];
        int r = a[0] * b[0];
        while ( l <= r ) {
        mid = (l + r) / 2;
        if (helper(mid, a, b) >= k)
        l = mid + 1;
        else
        r = mid - 1;
        }
        cout<< l- 1 <<endl;

        }