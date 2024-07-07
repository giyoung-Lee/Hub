import sys
input = sys.stdin.readline

n, h = map(int, input().split())

bottom = [0] * (h + 1)
top = [0] * (h + 1)

for i in range(n):
    height = int(input())
    if i % 2 == 0:
        bottom[height] += 1
    else:
        top[height] += 1

# 누적합 계산
for i in range(h - 1, 0, -1):
    bottom[i] += bottom[i + 1]
    top[i] += top[i + 1]


result = [0] * (h + 1)
for i in range(1, h + 1):
    result[i] = bottom[i] + top[h - i + 1]

# 최소 충돌 횟수와 그 개수 찾기
min_ = min(result[1:])
count = result[1:].count(min_)

# 결과 출력
print(min_, count)