# basic you can find these out here https://linuxjourney.com/

# make a user sudoers
sudo usermod -aG sudo username
sudo visudo 
# username ALL=(ALL:ALL) NOPASSWD: ALL

# tar
tar -xzvf /path/to/file.tar.gz
tar -czvf /path/to/file.tar.gz /path/to/directory

# Change My Shell
chsh -s $(which zsh)

# ps 
ps aux
ps auxf # with children tree

# bg
^Z
bg %1

# chmod