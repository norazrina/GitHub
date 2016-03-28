import binascii;
name = input("Enter Yourname: ");
address = input("Enter Address: ");

with open("yourname.txt","w") as fh:
 fh.write("Yourname: {} \nAddress: {}".format(name,address));

rd = [rf.rstrip('\n') for rf in open("yourname.txt","r")];
with open("yourname.bin","w") as wb:
 for data in rd:
  bd = bin(int.from_bytes(data.encode(),'big'))
  wb.write("{}\n".format(bd));

with open("yourname.bin","rb") as rb, open("last.txt","w") as wl:
 for data in rb:
  n = int(data,2)
  wl.write("{}\n".format(n.to_bytes((n.bit_length() + 7) // 8, 'big').dec"