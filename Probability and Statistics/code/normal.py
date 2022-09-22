import numpy as np
import matplotlib.pyplot as plt
import math

#Distribuicao Normal



n = 36 #amostras
numRep = 500 #O numero de repeticoes
u = 7 #media
sigma = math.sqrt(14) #variancia
var = 0 #variancia

listNormal = []
listMediasAmostral = []
listVarianciasAmostral = []


for i in range(numRep):
	listNormal = np.random.normal(u, sigma, n)
	
	media = np.mean(listNormal) #calculando media
	var = np.var(listNormal) #calculando variancia

	listMediasAmostral.append(media)
	listVarianciasAmostral.append(var)
	break
#print( 'Media: ', np.mean(n) )
#listNormal = np.random.normal(u, sigma, 1000)



fig, ax = plt.subplots()
#n, bins, patches = ax.hist(np.mean(listMediasAmostral), 11, normed=1)

#count, bins, ignored = plt.hist(listMediasAmostral, 30, normed=True)
count, bins, ignored = ax.hist(listMediasAmostral, 30, normed=True)
ax.set_title(r'Histograma das medias: $\mu=7$, $\sigma=15$')
ax.set_xlabel('Medias')
ax.set_ylabel('Densidade de probabilidade')
#plt.plot(bins, 1/(sigma * np.sqrt(2 * np.pi)) * np.exp( - (bins - u)**2 / (2 * sigma**2) ),linewidth=2, color='r')
plt.show()

fig, xp = plt.subplots()
count, bins, ignored = xp.hist(listVarianciasAmostral, 30, normed=True)
xp.set_title(r'Histograma das variancias: $\mu=100$, $\sigma=15$')
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