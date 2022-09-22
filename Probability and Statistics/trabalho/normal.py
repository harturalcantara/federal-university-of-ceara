import numpy as np
import matplotlib.pyplot as plt
import math

#numero de n's 36, 64, 100 e 196
#numero de repeticoes 250, 1000, e 5000

##### Dados para o programa, nossa
#403897 - Hartur
#399811 - Tarcisio
#402542 - Talison

#x = 17
#y = 16
#z = 16-17 = -1 = 1 (1, pois no PDF nos diz que deve ser um valor absoluto.)
#Distribuicao Normal: Media = 17, Variancia = 16, desvio Padrao = 4

u = 17 #media
sigma = 4 #desvio padrao
n = 36 #quantidade de amostras
numeroRep = 250 #quantidade de repeticoes

amostraMedia = [] #lista de valores de medias
amostraVariancia = [] #lista de valores de variancias

for i in range(numeroRep):
	norm = np.random.normal(u, sigma, n)
	media = np.mean(norm)
	variancia = np.var(norm)
	amostraMedia.append(media)
	amostraVariancia.append(variancia)



count, bins, ignored = plt.hist(amostraMedia, 11, normed=True)
plt.title('Media da Normal')
plt.ylabel('Valores da media')
plt.xlabel('Media')
plt.show()#histograma da Media

count, bins, ignored = plt.hist(amostraVariancia, 11, normed=True)
plt.title('Variancia da Normal')
plt.ylabel('Valores da variancia')
plt.xlabel('Variancia')
plt.show()#histograma da Variancia

plt.figure()
plt.ylabel('Valores da media')
plt.xlabel('Media')
plt.suptitle('Media da Normal')
plt.boxplot(amostraMedia, 1)
plt.show()#box plot da Media

plt.figure()
plt.ylabel('Valores da variancia')
plt.xlabel('Variancia')
plt.suptitle('Variancia da Normal')
plt.boxplot(amostraVariancia, 1)
plt.show()#box plot da Variancia