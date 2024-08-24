arr = list(map(int, input().split("/")))

if arr[0]+arr[2] < arr[1]:
    print("hasu")
elif arr[1] == 0:
    print("hasu")
else:
    print("gosu")