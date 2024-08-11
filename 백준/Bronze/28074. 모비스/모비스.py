st = input()

m_count = 0
o_count = 0
b_count = 0
i_count = 0
s_count = 0

for i in st:
    if i == "M":
        m_count += 1
    elif i == "O":
        o_count += 1
    elif i == "B":
        b_count += 1
    elif i == "I":
        i_count += 1
    elif i == "S":
        s_count += 1
        
if m_count >= 1 and o_count >= 1 and b_count >= 1 and i_count >= 1 and s_count >= 1:
    print("YES")
else:
    print("NO")