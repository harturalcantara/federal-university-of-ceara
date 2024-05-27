#################################################
# CLASSE VERSÂO OFICIAL, FABIO -SAN
#################################################

from location.Position import Position # classe Position que contem o que pode ter dentro de uma posicao
from utils.TypeObstacle import TypeObstacle # script utilitario para representacao dos tipos de obstaculos com tipagem int
class Map:
    
    def __init__(self):
        # self.ambiente = None
        # initList = [None, None, None, None]
        self.ambiente = [[None, None, None, None],[None, None, None, None],[None, None, None, None],[None, None, None, None]]

    # Método responsável por criar aleatoriamente o mapa do jogo, tanto as posicoes quanto os obstaculos.
    def build_map(self):
        # Exemplo
        linha = 4
        coluna = 4

        return self.map()


    def map(self):

        for i in range(4):
            for j in range(4):
                if i == 3:
                    self.ambiente[3][0] = Position()
                    self.ambiente[3][0].set_prova_surpresa(True)
    
                if i == 1:
                    self.ambiente[1][2] = Position()
                    self.ambiente[1][2].set_monstro(True)
                if j == 2:
                    self.ambiente[3][2] = Position()
                    self.ambiente[3][2].set_prova_surpresa(True)
                if i == 0:
                    self.ambiente[0][3] = Position()
                    self.ambiente[0][3].set_formatura(True)

                self.percepcoes()
               #1 print(f'{self.ambiente[i][j]:^10}',end=' ')
            
        # print(self.ambiente)

        return self.ambiente





    def percepcoes(self):
        for i in range(4):
            for j in range(4):

                if i == 3 and j == 1:
                    self.ambiente[3][1] = Position()
                    pos = self.ambiente[3][1]
                    pos.set_materia_acumulada(True)
                if i == 2 and j == 1:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_ta_ocioso(True)
                if i == 2 and j == 2:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_ta_ocioso(True)
                    self.ambiente[i][j].set_prova_surpresa(True)
                if i == 0 and j == 2:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_ta_ocioso(True)
                    self.ambiente[i][j].set_prova_surpresa(True)
                if  i == 3 and j == 3:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_materia_acumulada(True)
                if i == 1 and j == 3:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_ta_ocioso(True)
                if i == 0 and j == 1:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_materia_acumulada(True)
                
                if j == 0 and i == 2:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_materia_acumulada(True)
                if j == 1 and i == 3:
                    self.ambiente[i][j] = Position()
                    self.ambiente[i][j].set_materia_acumulada(True)


    @staticmethod
    def get_map(self):
        return self.ambiente

