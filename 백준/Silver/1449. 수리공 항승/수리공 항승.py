N, L = map(int, input().split())

list_ = list(map(int, input().split()))
list_.sort()

result = 0
now = 0

for i in range(len(list_)):
    if now < list_[i]:
        now = list_[i] + L -1
        result += 1
    else:
        pass

print(result)