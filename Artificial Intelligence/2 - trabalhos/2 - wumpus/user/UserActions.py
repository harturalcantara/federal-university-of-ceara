# AQUI VAI FICAR O CODIGO DO HARTHUR PARA A MOVIEMENTACAO DO USUARIO
from actions.Actions import Actions
from location.Position import Position
from environment.Map import Map
import os

class UserActions:
    # ... 
    def __init__(self, map):
        self.map = map
        

    def start(self):
        self.cls()
        while(True):
            self.menu()
            #mapa_atual(mat)
            # FUNCAO - informacoes dwesse CAMPO
            print("W - CIMA ?")
            print("D - DIREITA ?")
            movimentao = input('Onde vc ira se mover?')
            vivo = True #status do jogador
            i = 0 #percorre linha matriz
            j = 0 #percorre coluna matriz
            if(movimentao == 'W'):
                i = i + 1
            elif(movimentao == 'D'):
                j = j + 1   
            
            while(vivo==True): #16 if's do campo
                if(i==0 and j==0):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    ###########    MODELO PARA TODOS OS IF'S

                    print("Mapa atual")
                    Actions.mapa_atual(self.map)
                    #precisa mostrar o estado do mapa atual
                    #mapa_atual(mat)
                    print('Informacoes sobre essa sala')
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    
                    #retorne a posicao atual da matriz.Posicao.toString(), pois ela contem as informacoes dessa Pocisao da matriz.                    
                    # print(mat[0][0])
                    print('Com base no mapa e informacoes acima, voce esta no campo: [0][0]\n')     
                    ################

                    print('Onde deseja se mover?')                  
                    print("W - CIMA")
                    print("D - DIREITA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        print('Voce nao pode ir para baixo!')
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        print('Voce nao pode ir para esquerda!')
                elif(i==0 and j==1):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    
                    #exit(1)
                    #Modelo descrito no [0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [0][1]')
                    print("W - CIMA")
                    #print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        print("Voce nao pode ir para baixo!")
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==0 and j==2):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #Modelo descrito no [0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())

                    print('\nEstou no Campo [0][2]')
                    print("W - CIMA")
                    #print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        print("Voce nao pode ir para baixo!")
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==0 and j==3):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #modelo descrito no [0][0]
                    
                        
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())

                    break
                    # print('\nEstou no Campo [0][3]')
                    # print("W - CIMA")
                    # #print("S - BAIXO")
                    # #print("D - DIREITA")
                    # print("A - ESQUERDA")
                    # movimentao = input('Onde vc ira se mover?')
                    # if(movimentao == 'W'):
                    #     i = i + 1
                    # if(movimentao == 'S'):
                    #     print('Voce nao pode ir para baixo')
                    # if(movimentao == 'D'):
                    #     print('Voce nao pode ir para direita')
                    # if(movimentao == 'A'):
                        # j = j - 1
                elif(i==1 and j==0): #LINHA_1_MATRIZ
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #modelo descrito no [0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [1][0]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    #print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        print('Voce nao pode ir para esquerda!')
                elif(i==1 and j==1):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    Actions.mapa_atual(self.map)
                    #precisa mostrar o estado do mapa atual
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [1][1]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==1 and j==2):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)

                    #Seguir o modelo[0][0]
                    Actions.mapa_atual(self.map)
                    if(self.map[i][j].get_monstro()):
                        print('DIED, GAME OVER!')
                        break

                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [1][2]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==1 and j==3):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #Seguir o modelo[0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [1][3]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    #print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        print('Voce nao pode ir para direita!')
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==2 and j==0): ## LINHA_2
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #Seguir o modelo[0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [2][0]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    #print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        print('Voce nao pode ir para esquerda!')
                elif(i==2 and j==1):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    Actions.mapa_atual(self.map)
                    #Seguir o modelo[0][0]
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [2][1]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==2 and j==2):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    Actions.mapa_atual(self.map)
                    #Seguir o modelo[0][0]
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [2][2]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==2 and j==3):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    Actions.mapa_atual(self.map)
                    #Seguir o modelo[0][0]
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [2][3]')
                    print("W - CIMA")
                    print("S - BAIXO")
                    #print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        i = i + 1
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        print('Voce nao pode ir para direita!')
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==3 and j==0): ## LINHA_3_DA_MATRIZ
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #Seguir o modelo[0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [3][0]')
                    #print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    #print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        print('Voce nao pode ir para cima!')
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        print('Voce nao pode ir para esquerda!')
                elif(i==3 and j==1):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    Actions.mapa_atual(self.map)
                    #Seguir o modelo[0][0]
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [3][1]')
                    #print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        print('Voce nao pode ir para cima!')
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==3 and j==2):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #Seguir o modelo[0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [3][2]')
                    #print("W - CIMA")
                    print("S - BAIXO")
                    print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        print('Voce nao pode ir para cima!')
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        j = j + 1
                    if(movimentao == 'A'):
                        j = j - 1
                elif(i==3 and j==3):
                    if (self.map[i][j] == None):
                        self.map[i][j] = Position()
                        self.map[i][j].set_visitado(True)
                        self.map[i][j].set_livre(True)
                    else:
                        self.map[i][j].set_visitado(True)
                    #Seguir o modelo[0][0]
                    Actions.mapa_atual(self.map)
                    print(Actions.see_position_content(self.map,i,j).__str__())
                    print('\nEstou no Campo [3][3]')
                    #print("W - CIMA")
                    print("S - BAIXO")
                    #print("D - DIREITA")
                    print("A - ESQUERDA")
                    movimentao = input('Onde vc ira se mover?')
                    if(movimentao == 'W'):
                        print('Voce nao pode ir para cima!')
                    if(movimentao == 'S'):
                        i = i - 1
                    if(movimentao == 'D'):
                        print('Voce nao pode ir para direita!')
                    if(movimentao == 'A'):
                        j = j - 1


                self.cls()
            break

    def menu(self):
        print('\nINSTRUÇÕES') #Incompleto
        print('Tecla W - Andar para cima')
        print('Tecla S - Andar para baixo')
        print('Tecla A - Andar para esquerda')
        print('Tecla D - Andar para direita')
        print('Objetivo: Voce deve ser formar!')
        print('Dificuldades: Provas surpresas e o Ociosao esta no mapa')
        print('Contexto: Um universirio da UFC....')
        print("GAME START!\n")

    def cls(self):
        print('calling')
        os.system('cls' if os.name=='nt' else 'clear')
