n, m = map(int, input().split())

pack = []
arr = []

for i in range(m):
    a, b = map(int, input().split())
    pack.append(a)
    arr.append(b)

pack.sort()
arr.sort()

result = []

result.append(arr[0]*n)
tmp = (n // 6) + 1
if tmp >= 1:
    result.append(pack[0]*tmp)

tmp = n // 6
if tmp > 0:
    tmp2 = n % 6
    cal = (tmp * pack[0]) + (tmp2 * arr[0])
    result.append(cal)

print(min(result))
