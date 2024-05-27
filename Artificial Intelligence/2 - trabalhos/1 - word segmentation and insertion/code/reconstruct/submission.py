import shell
import util
import wordsegUtil

############################################################
# Problema 1: Segmentacao de Palavras com funcao de custo 'unigram'

class SegmentationProblem(util.SearchProblem):
    def __init__(self, query, unigramCost):
        self.query = query
        self.unigramCost = unigramCost

    def startState(self):
        # BEGIN_YOUR_CODE (solucao em 1 linha de codigo, mas utilize quantas linhas julgar necessario)
        return 0
        # END_YOUR_CODE

    def isEnd(self, state):
        # BEGIN_YOUR_CODE (solucao em 2 linhas de codigo, mas utilize quantas linhas julgar necessario)
        return state == len(self.query)
        # END_YOUR_CODE

    def succAndCost(self, state):
        # BEGIN_YOUR_CODE (solucao em 7 linhas de codigo, mas utilize quantas linhas julgar necessario)
        possible = []
        for i in range(state + 1,len(self.query) + 1):
        	
        	possible.append((i - state,i , self.unigramCost(self.query[state:i])))


        return possible
        # END_YOUR_CODE

def segmentWords(query, unigramCost):
    if len(query) == 0:
        return ''

    ucs = util.UniformCostSearch(verbose=0)
    ucs.solve(SegmentationProblem(query, unigramCost))

    # BEGIN_YOUR_CODE (solucao em 3 linhas de codigo, mas utilize quantas linhas julgar necessario)
    #aqui eu pego cada palavra e jogo em uma variavel auxiliar, depois jogo na lista de palavras para ficar um vetor , e depois formulo a frase 
    state = 0
    words = []
    for i in ucs.actions:

    	word = query[state:state + i]

    	
    	state = state + i
    	words.append(word)
    return ' '.join(words)
    # END_YOUR_CODE

############################################################
# Problema 2: Insercao de Vogais com custo 'bigram'

class VowelInsertionProblem(util.SearchProblem):
    def __init__(self, queryWords, bigramCost, possibleFills):
        self.queryWords = queryWords
        self.bigramCost = bigramCost
        self.possibleFills = possibleFills
        
    def startState(self):
     	# BEGIN_YOUR_CODE (solucao em 1 linha de codigo, mas utilize quantas linhas julgar necessario)
     	#comeca de zero, e com BEGIN
     	return (0,wordsegUtil.SENTENCE_BEGIN)
        # END_YOUR_CODE

    def isEnd(self, state):
        # BEGIN_YOUR_CODE (solucao em 2 linhas de codigo, mas utilize quantas linhas julgar necessario)
        #palavra atual e anterior, ou seja, chegou em uma possivel candidata
        currentWord,prevWord = state
        return currentWord == len(self.queryWords)
        # END_YOUR_CODE

    def succAndCost(self, state):
        # BEGIN_YOUR_CODE (solucao em 8 linhas de codigo, mas utilize quantas linhas julgar necessario)
        #possibilidade ou possiveis escolhas,aqui temos nextWords guardando a lista de possiveis palavras
        possible = []
        currentWord,prevWord = state
        nextWord = self.queryWords[currentWord]
        nextWords = self.possibleFills(nextWord)
        if len(nextWords) == 0: 
        	nextWords = set([nextWord])#lista de palavras
        
        for i in nextWords:
        	

        	cost = self.bigramCost(prevWord,i)#custo da palvra
        
        	possible.append((i,(currentWord + 1,i),cost))#palavra mais o custo dela
        	
        	
        return possible
        # END_YOUR_CODE

def insertVowels(queryWords, bigramCost, possibleFills):
    # BEGIN_YOUR_CODE (solucao em 3 linhas de codigo, mas utilize quantas linhas julgar necessario)
    prob = VowelInsertionProblem(queryWords,bigramCost,possibleFills)
    ucs = util.UniformCostSearch(verbose=0)
    ucs.solve(prob)
    results = []
    for word in ucs.actions:
         results.append(word)
    return ' '.join(results)
    # END_YOUR_CODE

############################################################
# Problema 3: Programa Integrado com custo 'bigram'

class JointSegmentationInsertionProblem(util.SearchProblem):
    def __init__(self, query, bigramCost, possibleFills):
        self.query = query
        self.bigramCost = bigramCost
        self.possibleFills = possibleFills

    def startState(self):
        # BEGIN_YOUR_CODE (solucao em 1 linha de codigo, mas utilize quantas linhas julgar necessario)
        return (0,wordsegUtil.SENTENCE_BEGIN)#(BEGIN,0)
        # END_YOUR_CODE

    def isEnd(self, state):
        # BEGIN_YOUR_CODE (solucao em 2 linhas de codigo, mas utilize quantas linhas julgar necessario)
        currentWord,prevWord = state
        return currentWord == len(self.query)#consumiu a palavra toda
        # END_YOUR_CODE

    def succAndCost(self, state):
        # BEGIN_YOUR_CODE (solucao em 14 linhas de codigo, mas utilize quantas linhas julgar necessario)
        currentWord,prevWord = state
        possible = []
        for i in range(currentWord + 1,len(self.query) + 1):
            nextWord = self.query[currentWord:i]#quebra as possiveis palavras
            nextWords = self.possibleFills(nextWord)#adiciona na lista de possibilidades
            for j in nextWords:
            	cost = self.bigramCost(prevWord,j)
            	
            	possible.append((j,(i,j),cost))#custo mais a palavra

        return possible
        # END_YOUR_CODE

def segmentAndInsert(query, bigramCost, possibleFills):
    if len(query) == 0:
        return ''

    # BEGIN_YOUR_CODE (solucao em 4 linhas de codigo, mas utilize quantas linhas julgar necessario)
    prob = JointSegmentationInsertionProblem(query,bigramCost,possibleFills)
    ucs = util.UniformCostSearch(verbose=0)
    ucs.solve(prob)
    results = []
    for word in ucs.actions:
    	results.append(word)
    return ' '.join(results)
    # END_YOUR_CODE

############################################################

if __name__ == '__main__':
    shell.main()
