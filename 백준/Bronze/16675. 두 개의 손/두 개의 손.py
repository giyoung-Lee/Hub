# 가위 바위 보를 R = 0, S = 1, P = 2로 저장
ml, mr, tl, tr = ('RSP'.index(i) for i in input().split())

"""
2 0
0 1
1 2
"""

if ml == mr and (ml+2) % 3 in [tl, tr]:
    print("TK")
elif tl == tr and (tl+2) % 3 in [ml, mr]:
    print("MS")
else:
    print("?")