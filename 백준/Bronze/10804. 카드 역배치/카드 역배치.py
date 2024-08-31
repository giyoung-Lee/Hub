arr = [i+1 for i in range(20)]

for _ in range(10):
    m, n = map(int, input().split())

    a = arr[:m-1]
    b = arr[m-1:n][::-1]
    c = arr[n:]
    arr = a+b+c


for i in range(len(arr)):
    print(arr[i], end=" ")