di = {chr(i): 0 for i in range(ord('a'), ord('z')+1)}

st = input()
st = st.lower()


for i in range(len(st)):
    di[st[i]] += 1

arr = [k for k, v in di.items() if max(di.values()) == v]

if len(arr) == 1:
    temp = str(arr[0])
    print(temp.upper())
else:
    print("?")