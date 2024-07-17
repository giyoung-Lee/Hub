b, c, d = map(int, input().split())

b_arr = list(map(int, input().split()))
c_arr = list(map(int, input().split()))
d_arr = list(map(int, input().split()))

result = sum(b_arr) + sum(c_arr) + sum(d_arr)

print(result)

b_arr.sort(reverse=True)
c_arr.sort(reverse=True)
d_arr.sort(reverse=True)

discount = 0

for i in range(min(b, c, d)):
    discount += (b_arr[i] + c_arr[i] + d_arr[i]) * 0.1

print(int(result - discount))