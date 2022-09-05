import numpy as np
import matplotlib.pyplot as plt
import math

#Distribuicao Uniforme

a  = 17 #menor valor
b = 2 # o maior valor
n = 100 #numero de elementos
numeroRep = 100 

#numero de n's 36, 64, 100 e 196
#numero de repeticoes 250, 1000, e 5000

media = 0
variancia = 0
amostraMedia = []
amostraVariancia = []
amostraTotal = []
z = 0

for i in range(numeroRep):
	listUniform = np.random.uniform(b, a, n)

	#for j in listuniform:
	#	media += j
	media = float((np.max(listUniform) + np.min(listUniform)))/2.0#calculando a media da lista uniforme
	print(media)
	#media = float(media)/float(n)
	#print ('media: ', media, '\n')
	#for j in listUniform:
	#	variancia += pow(j-media, 2)
	#variancia = float(variancia)/float(n-1)
	variancia = float(pow(listUniform.max() - listUniform.min(), 2)/12)#calculando a variancia da lista uniforme
	print(variancia)

	amostraMedia.append(media) #estou adicionando a media da listUniform em uma lista de amostras de medias;
	amostraVariancia.append(variancia)
	


count, bins, ignored = plt.hist(amostraMedia, 11, normed=True)
plt.show()
count, bins, ignored = plt.hist(amostraVariancia, 11, normed=True)
plt.show()