import sys

n = int(input())
n_list = list(map(int, input().split()))

box = int(input())
box_list = list(map(int, input().split()))

n_list.sort(reverse=True)
box_list.sort(reverse=True)

positions = [0] * n
checked = [False] * box

result = 0
count = 0

if max(n_list) < max(box_list):
    print(-1)
    sys.exit()  


while True:
    if count == len(box_list):
        break

    for i in range(n):
        while positions[i] < len(box_list):
            if not checked[positions[i]] and n_list[i] >= box_list[positions[i]]:
                checked[positions[i]] = True
                positions[i] += 1
                count += 1
                break
            positions[i] += 1
    result += 1

print(result)
