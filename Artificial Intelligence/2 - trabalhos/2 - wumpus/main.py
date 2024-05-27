from environment.Map import Map
from game.game import Game
from actions.Actions import Actions

def main():
        
        game = Game("Universitario Ocioso")
        while(True):
                print('1 - Jogar')
                print('0 - Sair')
                opt = input()
                if(opt == '1'):
                        map = Map()
                        game_map = map.build_map()

                        Actions.mapa_atual(game_map)

                        game.define_map(game_map)

                        game.start_game()
                elif (opt == 0):
                        exit()

if __name__ == '__main__':
    main()
