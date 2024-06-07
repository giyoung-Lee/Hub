st = input()

list_ = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

count = 0

for i in list_:
    st = st.replace(i, 'a')
print(len(st))