import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    arr.append(int(input()))

max_v = 0
max_index = -1

# 가장 큰값과 그 인덱스 값을 찾기
for i in range(n):
    if max_v < arr[i]:
        max_v = arr[i]
        max_index = i


# 뒤에서 부터 출발해서 내림차순 배열의 크기를 계산
length = 1
target = max_v - 1

# 뒤에서부터 출발하여 내림차순 배열의 크기를 계산
for i in range(max_index -1, -1, -1):
    # 다음원소를 찾았다면, 그 다음 원소 찾기
    if target == arr[i]:
        target -= 1
        length += 1
        
print(n - length)

# 주어진 값중, 뒤에서부터 봤을떄, 내림차순의 경우 숫자를 변경하지 않아도됨.
# 그래서 배열중, 내림차순으로 존재하는 수의 개수를 찾고, 전체 길이에서 그만큼 빼줌
