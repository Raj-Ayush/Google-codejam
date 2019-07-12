test = int(input())
for i in range(test):
    inpu = input()
    val1 = inpu.replace('4','1')
    val2 = int(inpu) - int(val1)
    print("Case #"+str(i+1)+":",val1,val2)
    
