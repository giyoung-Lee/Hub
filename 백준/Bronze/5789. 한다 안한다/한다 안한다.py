n = int(input())

for i in range(n):
    st = input()
    if st[int(len(st)/2)] == st[int(len(st)/2)-1]:
        print("Do-it")
    else:
        print("Do-it-Not")