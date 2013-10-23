psycho-poker
============

Cada jogador recebe 5 cartas e pode v�-las. O jogador pode ent�o descartar entre 0 e 5 das suas cartas e troc�-las pelo mesmo n�mero de cartas a partir do topo do monte. O objetivo � maximizar o valor final da m�o do jogador.

As cartas do monte est�o viradas para baixo, e normalmente n�o � poss�vel saber a ordem das cartas. Vamos imaginar que o nosso jogador � um paranormal e que ele consiga saber as pr�ximas 5 cartas do monte. Fa�a um c�digo que ajude o jogador a descartar e trocar as cartas de forma a maximizar sua m�o.

## Entradas e sa�das

A entrada ser� uma s�rie de linhas, cada linha contendo as 5 cartas na m�o do jogador e depois as 5 cartas do topo do monte. Cada carta ser� representada por 2 caracteres: o primeiro � o valor da carta (A=�s, 2-9, T=10, J=Valete, Q=Dama, K=Rei) e o segundo valor � o naipe (C=Paus, D=Ouro, S=Espada, H=Copas). As cartas ser�o separadas por espa�o e cada linha ser� de um �nico baralho v�lido. Logo, n�o haver� cartas duplicadas entre a m�o e o monte.

Cada linha de entrada deve produzir uma linha de sa�da com a m�o inicial, as 5 cartas do monte e a melhor m�o poss�vel.

A ordem das cartas na m�o do jogador � irrelevante mas a ordem das cartas no monte s�o importantes, pois cada carta s� pode ser trocada com carta no topo do monte.

## Exemplos de entrada
 
TH JH QC QD QS QH KH AH 2S 6S  
2H 2S 3H 3S 3C 2D 3D 6C 9C TH  
2H 2S 3H 3S 3C 2D 9C 3D 6C TH  
2H AD 5H AC 7H AH 6H 9H 4H 3C  
AC 2D 9C 3S KD 5S 4D KS AS 4C  
KS AH 2H 3C 4H KC 2C TC 2D AS  
AH 2C 9S AD 3C QH KS JS JD KD  
6C 9C 8C 2D 7C 2H TC 4C 9S AH  
3D 5S 2H QD TD 6S KH 9H AD QH  

## Exemplos de sa�da

M�o: TH JH QC QD QS Monte: QH KH AH 2S 6S Melhor Jogo: straight-flush (sequ�ncia num�rica e de naipe)  
M�o: 2H 2S 3H 3S 3C Monte: 2D 3D 6C 9C TH Melhor Jogo: four-of-a-kind (quadra)  
M�o: 2H 2S 3H 3S 3C Monte: 2D 9C 3D 6C TH Melhor Jogo: full-house (trinca + par)  
M�o: 2H AD 5H AC 7H Monte: AH 6H 9H 4H 3C Melhor Jogo: flush (sequ�ncia de naipe)  
M�o: AC 2D 9C 3S KD Monte: 5S 4D KS AS 4C Melhor Jogo: straight (sequ�ncia num�rica)  
M�o: KS AH 2H 3C 4H Monte: KC 2C TC 2D AS Melhor Jogo: three-of-a-kind (trinca)  
M�o: AH 2C 9S AD 3C Monte: QH KS JS JD KD Melhor Jogo: two-pairs (2 pares)  
M�o: 6C 9C 8C 2D 7C Monte: 2H TC 4C 9S AH Melhor Jogo: one-pair (1 par)  
M�o: 3D 5S 2H QD TD Monte: 6S KH 9H AD QH Melhor Jogo: highest-card (maior carta)  
