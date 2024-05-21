n = int(input())

list_ = list(map(int, input().split()))

A, B = map(int, input().split())

result = 0

for i in range(n):
    now = list_[i]

    if A >= now:
        result += 1
    else:
        now2 = now - A

        if now2 % B != 0:
            result += now2 // B + 2
        else:
            result += now2 // B + 1

print(result)