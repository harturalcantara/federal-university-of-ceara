# Problem-2: Construction of a DFA for the set of string over {a, b} such that length of the string |w|>=2 i.e, length of the string should be at least 2.
def checkStateA(n):
    if(len(n)==1):
        print("string not accepted")
    else:   
        if(n[0]=='a' or n[0]=='b'):
            stateB(n[1:]) 
def stateB(n):
    if(len(n)<1):
        print("string not accepted")
    else:
        stateC(n[1:])
def stateC(n):
    if (len(n)>=0):
        print("string accepted")
    else:
        print("string not accepted") 
n=input()
checkStateA(n)