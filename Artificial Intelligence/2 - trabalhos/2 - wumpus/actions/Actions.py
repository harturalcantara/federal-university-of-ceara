# to be implemented by tonton
from location.Position import Position

class Actions:

    @staticmethod
    def see_position_content(map, i, j):
        return map[i][j]

    @staticmethod
    def throw_keys(map, desirable_pos_x, desirable_pos_y):
        
        position = map[desirable_pos_x][desirable_pos_y]    
        if(position.get_monstro()):
            print('monstro pegou a chave')
        else:
            print('CHAMAR FUNCAO GAMEOVER POIS SEM A CHAVE, O UNIVERSITARIO VAI PRO BREJO')    

    @staticmethod    
    def mapa_atual(matriz): #exibicao dos campos que foram visitados ou nao.
        for i in range(3,-1,-1):
            for j in range(4):
                if(matriz[i][j] != None):
                    print(i,j,'[',matriz[i][j].get_visitado(), end=' ] ')
                else:
                    matriz[i][j] = Position()
                    matriz[i][j].set_livre(True)
                    print(i,j,'[',matriz[i][j].get_visitado(), end=' ] ')
            print('\n')
