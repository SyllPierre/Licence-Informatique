dragon: dragon.hs
	ghc -dynamic -Wall dragon.hs && ./dragon

dragon2:
	LD_PRELOAD=/usr/lib/x86_64-linux-gnu/libglut.so runghc dragon.hs

.PHONY: dragon
