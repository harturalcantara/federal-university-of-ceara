import socket

def client_program():
    host = socket.gethostname()  # as both code is running on same pc
    port = 5000  # socket server port number

    client_socket = socket.socket()  # instantiate
    client_socket.connect((host, port))  # connect to the server

    message = ''
    #message = input(" -> ")  # take input
    #message = message + '\n'
    while message.lower().strip() != 'bye':
        data = ''
        message = ''
        message = input()  # again take input
        message = message + '\n'
        client_socket.send(message.encode())  # send message
        
        data = client_socket.recv(1024).decode()  # receive response
        print(len(data)) 
        if data == b'1':
            raise RuntimeError("socket connection broken")
        if len(data) == 1:
            data = client_socket.recv(1024).decode()
        print('Received from server: ' + data)  # show in terminal
       
    client_socket.close()  # close the connection


if __name__ == '__main__':
    client_program()
