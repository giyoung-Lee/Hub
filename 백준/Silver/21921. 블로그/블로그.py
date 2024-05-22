N, X = map(int, input().split())

list_ = list(map(int, input().split()))
now = sum(list_[:X])
result = {now: 1}

for i in range(1, N-X + 1):
    end = i + X - 1
    now += list_[end] - list_[i-1]

    if now in result:
        result[now] += 1
    else:
        result[now] = 1

max_key = max(result.keys())

if max_key == 0:
    print("SAD")
else:
    print(max_key)
    print(result[max_key])