#################################################
# CRIADO POR MANELITO, COM UMA ALTERACAO NA LINHA DE self.positionados, em vez de vetor usa-se apenas um boolean.
# A razao para isso eh que cada posicao é um objeto que contem apenas a informacao de visitado e não de lista de visitados. 
# Também foram adicionados metodos gets para podermos fazer uso das variaveis da classe. 
#################################################

from utils.TypeObstacle import TypeObstacle

class Position:
          def __init__(self):
                self.prova_surpresa = False
                self.materia_acumulada = False
                self.livre = False
                self.ta_ocioso = False
                self.fumo = False
                self.monstro = False
                self.dica = ''
                self.visitado = False
                self.posicionados = False
                self.formatura = False

          def set_prova_surpresa(self, val):
                self.prova_surpresa = val
          
          def set_materia_acumulada(self, val):
                self.materia_acumulada = val
          
          def set_livre(self, val):
                self.livre = val
          
          def set_ta_ocioso(self, val):
                self.ta_ocioso = val
          
          def set_fumo(self, val):
                self.fumo = val

          def set_monstro(self, val):
                self.monstro = val
          
          def set_dica(self, dica):
                self.dica = dica

          def set_visitado(self, val):
                self.visitado = val
          
          def set_formatura(self, val):
                self.formatura = val     

          def get_prova_surpresa(self):
                return self.prova_surpresa
          
          def get_materia_acumulada(self):
                return self.materia_acumulada
          
          def get_livre(self):
                return self.livre
          
          def get_ta_ocioso(self):
                return self.ta_ocioso
          
          def get_fumo(self):
                return self.fumo

          def get_monstro(self):
                return self.monstro
          
          def get_dica(self, dica):
                return self.dica

          def get_visitado(self):
                return self.visitado
          
          def get_formatura(self):
                return self.formatura

          def __str__(self):
                  if (self.get_livre()):
                        return TypeObstacle.TYPE_LIVRE

                  msg = '================== \n'
                  if(self.get_prova_surpresa()):
                      msg += TypeObstacle.TYPE_PROVA_SURPRESA  + ' \n '
                  if(self.get_materia_acumulada()):
                      msg += TypeObstacle.TYPE_MATERIA_ACUMULADA + ' \n '
                  if(self.get_ta_ocioso()):
                      msg += TypeObstacle.TYPE_TA_OCIOSO + ' \n '
                  if(self.get_fumo()):
                      msg += TypeObstacle.TYPE_FUMO + ' \n '
                  if(self.get_formatura()):
                      msg += TypeObstacle.TYPE_FORMATURA + ' \n '
                  if (self.get_monstro()):
                      msg += TypeObstacle.TYPE_MONSTRO + ' \n '
                  msg += '======================= \n\n'

                  return msg

