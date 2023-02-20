r, c = map(int, input().split())
m = [list(input()) for i in range(r)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

ck = False

for i in range(r):
    for j in range(c):
        if m[i][j] == 'W':
            for w in range(4):
                ii, jj = i + dx[w], j + dy[w]
                if ii < 0 or ii == r or jj < 0 or jj == c:
                    continue
                if m[ii][jj] == 'S':
                    ck = True

if ck:
    print(0)
else:
    print(1)
    for i in range(r):
        for j in range(c):
            if m[i][j] not in 'SW':
                m[i][j] = 'D'

for i in m:
    print(''.join(i))