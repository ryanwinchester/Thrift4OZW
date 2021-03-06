#
# Makefile for Thrift4OZW
# Elias Karakoulakis <elias.karakoulakis@gmail.com>
# based on Makefile for OpenWave Control Panel application by Greg Satz

# GNU make only

.SUFFIXES:	.cpp .o .a .s .thrift

# Sorry gcc, clang is way better. 
# Use it if found in path...
CLANG := $(shell which clang)
ifeq ($(CLANG),)
CC     := gcc
CXX    := g++
else
CC     := clang
CXX    := clang++
endif

LD     := ld
AR     := ar rc
RANLIB := ranlib

# Change for DEBUG or RELEASE
TARGET := DEBUG

# TODO: Restore the -Werror flag after removing calls to the deprecated
# Manager::BeginControllerCommand method.
DEBUG_CFLAGS    := -DHAVE_INTTYPES_H -DHAVE_NETINET_IN_H -Wall -Wno-format -g -DDEBUG -O0 -DDEBUG_BOOSTSTOMP 
RELEASE_CFLAGS  := -DHAVE_INTTYPES_H -DHAVE_NETINET_IN_H -Wall -Wno-unknown-pragmas -Wno-format -O3 -DNDEBUG

DEBUG_LDFLAGS	:= -g

# ============================
# change directories if needed
# ============================
OPENZWAVE      := $(HOME)/ozw/openzwave
OPENZWAVE_LIB	:= /usr/lib
OPENZWAVE_INC	:= $(OPENZWAVE)/cpp/src
THRIFT		    := $(HOME)/ozw/thrift
THRIFT_INC	    := /usr/local/include/thrift
BOOSTSTOMP_LIB  := /usr/local/lib
BOOSTSTOMP_INC	:= /usr/local/include/booststomp

CFLAGS	:= -c $($(TARGET)_CFLAGS) 
LDFLAGS	:= $($(TARGET)_LDFLAGS) \
		-Wl,-rpath=$(OPENZWAVE)/cpp/lib/linux/ 

INCLUDES := -I $(OPENZWAVE_INC) -I $(OPENZWAVE_INC)/command_classes/ -I $(OPENZWAVE_INC)/value_classes/ \
 -I $(OPENZWAVE_INC)/platform/	-I $(OPENZWAVE_INC)/platform/unix	-I $(THRIFT_INC) -I $(BOOSTSTOMP_INC) \
 -I . -I gen-cpp

# Remove comment below for gnutls support
#GNUTLS := -lgnutls

LIBZWAVE_STATIC := $(OPENZWAVE_LIB)/libopenzwave.a
LIBZWAVE_DYNAMIC := $(OPENZWAVE_LIB)/libopenzwave.so.1.3
LIBZWAVE := -lopenzwave
LIBUSB := -ludev

# for Mac OS X comment out above 2 lines and uncomment next 2 lines
#LIBZWAVE := $(wildcard $(OPENZWAVE)/cpp/lib/mac/*.a)
#LIBUSB := -framework IOKit -framework CoreFoundation

LIBBOOST := -lboost_thread -lboost_program_options -lboost_system -lboost_filesystem -lpthread
LIBBOOST_STATIC := -lboost_thread -lboost_program_options -lboost_system -lboost_filesystem 
LIBTHRIFT := -lthrift
LIBBOOSTSTOMP := -lbooststomp
LIBBOOSTSTOMP_STATIC := libbooststomp.a

LIBS := $(GNUTLS) $(LIBZWAVE) $(LIBUSB) $(LIBBOOST) $(LIBTHRIFT) $(LIBBOOSTSTOMP) 

%.o : %.cpp
	$(CXX) $(CFLAGS) $(INCLUDES) -o $@ $<

%.o : %.c
	$(CC) $(CFLAGS) $(INCLUDES) -o $@ $<

#all: openzwave booststomp ozwd ozwd.static
all: openzwave booststomp ozwd
	@echo "---------------------------------"
	@echo "Your OpenZWave daemon is compiled!"
	@echo "---------------------------------"

gen-cpp/RemoteManager_server.cpp: create_server.rb gen-cpp/RemoteManager.cpp
	- patch -u -N -p0 gen-cpp/ozw_types.h < ozw_types.h.patch
	ruby create_server.rb --ozwroot=${OPENZWAVE} --thriftroot=$(THRIFT_INC)
	cp gen-cpp/RemoteManager_server.cpp gen-cpp/RemoteManager_server.cpp.orig
	cp gen-cpp/ozw_types.h gen-cpp/ozw_types.h.orig
	- patch -u -N -p0 gen-cpp/RemoteManager_server.cpp < RemoteManager_server.cpp.patch
    
gen-cpp/RemoteManager.cpp: ozw.thrift
	thrift --gen cpp --gen java --gen js --gen py --gen rb ozw.thrift

gen-cpp/RemoteManager.o: gen-cpp/RemoteManager.cpp
	$(CXX) $(CFLAGS) -c gen-cpp/RemoteManager.cpp -o gen-cpp/RemoteManager.o $(INCLUDES)

gen-cpp/ozw_constants.o:  gen-cpp/ozw_constants.cpp
	$(CXX) $(CFLAGS) -c gen-cpp/ozw_constants.cpp -o gen-cpp/ozw_constants.o $(INCLUDES)
    
gen-cpp/ozw_types.o:  gen-cpp/ozw_types.cpp gen-cpp/ozw_types.h
	$(CXX) $(CFLAGS) -c gen-cpp/ozw_types.cpp -o gen-cpp/ozw_types.o $(INCLUDES)

Main.o: Main.cpp gen-cpp/RemoteManager_server.cpp
	$(CXX) $(CFLAGS) -c Main.cpp $(INCLUDES)   
	
openzwave: 
	cd $(OPENZWAVE); make

openzwave-install: openzwave
	cd $(OPENZWAVE); sudo make install
	
booststomp:
	#cd $(BOOSTSTOMP); make 

ozwd.static: Main.o booststomp gen-cpp/RemoteManager.o gen-cpp/ozw_constants.o gen-cpp/ozw_types.o openzwave
	$(CXX) -static -static-libgcc -o $@ $(LDFLAGS) Main.o gen-cpp/RemoteManager.o gen-cpp/ozw_constants.o gen-cpp/ozw_types.o  $(LIBZWAVE_STATIC) $(LIBBOOSTSTOMP_STATIC) $(LIBBOOST_STATIC) -lpthread -ludev -lthrift -lrt

ozwd:   Main.o booststomp gen-cpp/RemoteManager.o gen-cpp/ozw_constants.o gen-cpp/ozw_types.o openzwave
	$(CXX) -o $@ $(LDFLAGS) Main.o gen-cpp/RemoteManager.o gen-cpp/ozw_constants.o gen-cpp/ozw_types.o $(LIBS)

dist:	main
	rm -f Thrift4OZW.tar.gz
	tar -c --exclude=".git" --exclude ".svn" --exclude "*.o" -hvzf Thrift4OZW.tar.gz *.cpp *.h *.thrift *.sm *.rb Makefile gen-*/ license/ README*

bindist: main
	rm -f Thrift4OZW_bin_`uname -i`.tar.gz
	upx ozwd*
	tar -c --exclude=".git" --exclude ".svn" -hvzf Thrift4OZW_bin_`uname -i`.tar.gz ozwd license/ README*

clean:
	rm -f ozwd*.o gen-cpp/RemoteManager.cpp gen-cpp/RemoteManager_server.cpp gen-cpp/ozw_types.h

binclean: 
	rm -f ozwd *.o  gen-cpp/*.o
    
thrift: gen-cpp/RemoteManager.cpp

patchdiffs:
	- diff -u gen-cpp/ozw_types.h.orig gen-cpp/ozw_types.h > ozw_types.h.patch
	- diff -u gen-cpp/RemoteManager_server.cpp.orig gen-cpp/RemoteManager_server.cpp > RemoteManager_server.cpp.patch
	
java:
	cd gen-java/OpenZWave; javac -cp .:`find $(THRIFT)/lib/java/build -name "*.jar" | tr "\n" ":"` *.java
	cd gen-java;  jar -cf OpenZWave.jar OpenZWave/*.class
	

