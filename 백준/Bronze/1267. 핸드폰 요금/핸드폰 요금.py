n = int(input())
arr = list(map(int, input().split()))

m = 0
y = 0

for i in range(n):
    tmp_m = ((arr[i]//30) * 10) + 10
    tmp_y = ((arr[i]//60) * 15) + 15

    m += tmp_m
    y += tmp_y

if m < y:
    print("Y", m)
elif m > y:
    print("M", y)
else:
    print("Y M", y)
