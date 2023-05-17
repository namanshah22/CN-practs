import socket

# Create a socket object
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Define the host and port
host = socket.gethostname()  # Host IP
port = 12345

# Bind the socket to the host and port
server_socket.bind((host, port))

# Listen for incoming connections
server_socket.listen(1)

print('Server listening on {}:{}'.format(host, port))

# Accept a client connection
client_socket, address = server_socket.accept()
print('Connected to client:', address)

while True:
    # Receive data from the client
    data = client_socket.recv(1024).decode()
    if not data:
        break
    
    print("Received message:", data, "from", address)

client_socket.close()
server_socket.close()
