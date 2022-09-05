import numpy as np
import matplotlib.pyplot as plt

n = 36
numeroRep = 5000
N = 17
p = 0.9444

#numero de n's 36, 64, 100 e 196
#numero de repeticoes 250, 1000, e 5000

media = 0
variancia = 0
amostraMedia = []
amostraVariancia = []
amostraTotal = []
z = 0

for i in range(numeroRep):
	uniform = np.random.binomial(N, p, n)
	for j in uniform:
		media += j
	media = float(media)/float(n)
	for j in uniform:
		variancia += pow(j-media, 2)
	variancia = float(variancia)/float(n-1)
	amostraMedia.append(media)
	amostraVariancia.append(variancia)

amostraTotal.append(amostraMedia)
amostraTotal.append(amostraVariancia)

plt.figure()
plt.ylabel('Valores da media e variancia')
plt.xlabel('Media e Variancia')
plt.suptitle('Media e Variancia')
plt.boxplot(amostraTotal, 1)
plt.show()

np.random.binomial(2, 0.5, 23000)