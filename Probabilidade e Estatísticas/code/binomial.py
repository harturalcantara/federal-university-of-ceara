import numpy as np
import matplotlib.pyplot as plt

#Distribuicao Binomial



N = 14 #quantidade de acertos
p = 0.5


n = 196
numRep = 100 #O numero de repeticoes
u = 7 #media
sigma = 14 #desvio padrao
var = 0 #variancia

listNormal = []
listMediasAmostral = []
listVarianciasAmostral = []



#np.random.

for i in range(numRep):
    
	listNormal = np.random.binomial(N, p, n)
	
	media = np.mean(listNormal)
	#media = float(n * p)
	var = float(media * (1-p))

	#media = np.mean(listNormal) #calculando media
	#var = np.var(listNormal) #calculando variancia

	listMediasAmostral.append(media)
	listVarianciasAmostral.append(var)



#listNormal = np.random.normal(u, sigma, 1000)
count, bins, ignored = plt.hist(listMediasAmostral, 30, normed=True)
#plt.plot(bins, 1/(sigma * np.sqrt(2 * np.pi)) * np.exp( - (bins - u)**2 / (2 * sigma**2) ),linewidth=2, color='r')
plt.show()
count, bins, ignored = plt.hist(listVarianciasAmostral, 30, normed=True)
plt.show()

#Parte do blox-pot

amostraTotal1 = []
amostraTotal1.append(listMediasAmostral)


plt.figure()
plt.ylabel('Valores da media')
plt.xlabel('Media')
plt.suptitle('Media')
plt.boxplot(amostraTotal1, 1)
plt.show()

amostraTotal2 = []
amostraTotal2.append(listVarianciasAmostral)
plt.figure()
plt.ylabel('Valores da variancia')
plt.xlabel('Variancia')
plt.suptitle('Variancia')
plt.boxplot(amostraTotal2, 1)
plt.show()