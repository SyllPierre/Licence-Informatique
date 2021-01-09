#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <sys/types.h>
#include <string.h>
#include <unistd.h>
#include <assert.h>

int main(int argc, char** argv){

    char* msg = argv[1];
    int sock;
    assert((sock = socket(AF_INET, SOCK_DGRAM, 0)) >= 0);

    struct sockaddr_in addrDest;

    addrDest.sin_family = AF_INET;
    addrDest.sin_addr.s_addr = inet_addr("192.168.1.17");
    addrDest.sin_port = htons(5000);

    sendto(sock, msg, strlen(msg), 0, (struct sockaddr*) &addrDest, (socklen_t) sizeof(addrDest));

    close(sock);

    return 0;
}
