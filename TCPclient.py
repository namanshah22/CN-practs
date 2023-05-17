import socket

# Create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Define the host and port
host = socket.gethostname()  # Host IP
port = 12345

# Connect to the server
client_socket.connect((host, port))
print('Connected to server {}:{}'.format(host, port))

# Send data to the server
msg = "Hello Python!"
client_socket.sendall(msg.encode('utf-8'))

client_socket.close()
