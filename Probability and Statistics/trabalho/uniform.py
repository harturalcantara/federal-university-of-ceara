import numpy as np
import matplotlib.pyplot as plt
import math

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


n = 36 #quantidade de amostras
a  = 17 #
b = 2 #
numeroRep = 250 #quantidade de repeticoes

amostraMedia = [] #lista de valores de medias
amostraVariancia = [] #lista de valores de variancias



for i in range(numeroRep):
	uni = np.random.uniform(a, b, n)
	media = np.mean(uni)
	variancia = np.var(uni)
	amostraMedia.append(media)
	amostraVariancia.append(variancia)

count, bins, ignored = plt.hist(amostraMedia, 11, normed=True)
plt.title('Media da Uniform')
plt.ylabel('Valores da media')
plt.xlabel('Media')
plt.show()

count, bins, ignored = plt.hist(amostraVariancia, 11, normed=True)
plt.title('Variancia da Uniform')
plt.ylabel('Valores da variancia')
plt.xlabel('Variancia')
plt.show()

plt.figure()
plt.ylabel('Valores da media')
plt.xlabel('Media')
plt.title('Media da Uniform')
plt.boxplot(amostraMedia, 1)
plt.show()

plt.figure()
plt.ylabel('Valores da variancia')
plt.xlabel('Variancia')
plt.title('Variancia da Uniform')
plt.boxplot(amostraVariancia, 1)
plt.show()