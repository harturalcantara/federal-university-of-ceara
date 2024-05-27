from user.UserActions import UserActions

class Game:
    def __init__(self,game_name):
        self.game_name = game_name
        self.map = None

    def start_game(self):
        if(self.map == None):
            return 'Mapa inexistente, use o metodo define_map e passe uma matriz de Positions como parametro'
        
        print(f'Bem Vindo ao {self.get_game_name()}')
    
        user = UserActions(self.map)
        user.start()


    def define_map(self, map):
        self.map = map

    def get_game_name(self):
        return self.game_name

    def get_map(self):
        return self.map()    