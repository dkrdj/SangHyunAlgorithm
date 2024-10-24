#include<bits/stdc++.h>

using namespace std;

struct Piece {
    int r, c, dir, floor;
    Piece(int r, int c, int dir) : r(r), c(c), dir(dir), floor(0) {}
};

int N, K;
int map22[12][12];
vector<int> num[12][12];
Piece* pieces[11];
int dr[] = { 0, 0, -1, 1 }, dc[] = { 1, -1, 0, 0 };

void move(Piece* piece, bool flag);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map22[i][j];
        }
    }

    for (int i = 1; i <= K; i++) {
        int r, c, dir;
        cin >> r >> c >> dir;
        r--; c--; dir--;
        pieces[i] = new Piece(r, c, dir);
        num[r][c].push_back(i);
    }

    for (int t = 1; t <= 1000; t++) {
        for (int i = 1; i <= K; i++) {
            move(pieces[i], false);
            if (num[pieces[i]->r][pieces[i]->c].size() >= 4) {
                cout << t << endl;
                return 0;
            }
        }
    }

    cout << -1 << endl;
    return 0;
}

void move(Piece* piece, bool flag) {
    vector<int>& list = num[piece->r][piece->c];
    int beforeFloor = piece->floor;
    int nr = piece->r + dr[piece->dir];
    int nc = piece->c + dc[piece->dir];

    if (nr < 0 || nr >= N || nc < 0 || nc >= N || map22[nr][nc] == 2) {
        if (!flag) {
            if (piece->dir == 0) piece->dir = 1;
            else if (piece->dir == 1) piece->dir = 0;
            else if (piece->dir == 2) piece->dir = 3;
            else piece->dir = 2;
            move(piece, true);
        }
    }
    else if (map22[nr][nc] == 1) {
        stack<int> stk;
        for (int i = beforeFloor; i < list.size(); i++) {
            stk.push(list[i]);
        }
        while (!stk.empty()) {
            int nxtIdx = stk.top(); stk.pop();
            Piece* nxtPiece = pieces[nxtIdx];
            nxtPiece->r = nr;
            nxtPiece->c = nc;
            nxtPiece->floor = num[nr][nc].size();
            num[nr][nc].push_back(nxtIdx);
        }
        while (list.size() > beforeFloor) {
            list.pop_back();
        }
    }
    else {
        for (int i = piece->floor; i < list.size(); i++) {
            Piece* nxtPiece = pieces[list[i]];
            nxtPiece->r = nr;
            nxtPiece->c = nc;
            nxtPiece->floor = num[nr][nc].size();
            num[nr][nc].push_back(list[i]);
        }
        while (list.size() > beforeFloor) {
            list.pop_back();
        }
    }
}
