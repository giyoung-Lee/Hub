import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    x, y = map(int, input().split())
    arr.append((x, y))      # (시작점, 끝점)

arr.sort()
result = 0
start, current = arr[0]     # 첫번째 선

for line in arr:
    x, y = line
    if current >= x:        # 현재 펜의 위치가 시작점 x의 크기 보다 크다면
        current = max(current, y)   # y중 더 큰 것으로 비교 하여 현재를 수정
    else:                   # 현재 펜의 위치가 시작점 보다 작다면(새로 선을 그어야 할 경우)
        result += current - start
        start = x
        current = y

result += current - start

print(result)