import numpy as np
import matplotlib.pyplot as plt

#numero de n's 36, 64, 100 e 196
#numero de repeticoes 250, 1000, e 5000

##### Dados para o programa, nossos valores obitidos apartir da nossa matricula.
#403897 - Hartur
#399811 - Tarcisio
#402542 - Talison
#
#x = 17
#y = 16
#z = 16-17 = -1 = 1 (1, pois no PDF nos diz que deve ser um valor absoluto.)
#Distribuicao Normal: Media = 17, Variancia = 16, desvio Padrao = 4


n = 36 #quantidade de elementos
N = 17 #quantidade de acertos
p = 0.94 #probabilidade de sucesso
numeroRep = 5000 #Numero de repetições

amostraMedia = [] #lista de valores de medias
amostraVariancia = [] #lista de valores de variancias



for i in range(numeroRep):
	b = np.random.binomial(N, p, n)
	media = np.mean(b)
	variancia = np.var(b)
	amostraMedia.append(media)
	amostraVariancia.append(variancia)

count, bins, ignored = plt.hist(amostraMedia, 11, normed=True)
plt.title('Media da Binomial')
plt.ylabel('Valores da media')
plt.xlabel('Media')
plt.show() #histograma da media

count, bins, ignored = plt.hist(amostraVariancia, 11, normed=True)
plt.title('Variancia da Binomial')
plt.ylabel('Valores da variancia')
plt.xlabel('Variancia')
plt.show()#histograma da variancia

plt.figure()
plt.title('Media da Binomial')
plt.ylabel('Valores da media')
plt.xlabel('Media')
plt.boxplot(amostraMedia, 1)
plt.show()#blox-plot da media

plt.figure()
plt.title('Variancia da Binomial')
plt.ylabel('Valores da variancia')
plt.xlabel('Variancia')
plt.boxplot(amostraVariancia, 1)
plt.show()#blox-plot da variancia