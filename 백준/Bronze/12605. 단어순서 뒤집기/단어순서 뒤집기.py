n = int(input())

for _ in range(n):
    arr = list(map(str, input().split()))

    print(f"Case #{_+1}:", end=' ')
    for i in reversed(arr):
        print(i, end=' ')