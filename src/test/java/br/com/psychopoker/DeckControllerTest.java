package br.com.psychopoker;

import br.com.psychopoker.controller.DeckController;
import junit.framework.TestCase;

public class DeckControllerTest extends TestCase{
	
	public void testBestHandHighestCard(){
		DeckController deckController = new DeckController("3D 5S 2H QD TD 6S KH 9H AD QH");
		assertEquals("Mao: 3D 5S 2H QD TD Monte: 6S KH 9H AD QH Melhor Jogo: highest-card (maior carta)", deckController.bestHand());
	}
	
	public void testBestHandOnePair(){
		DeckController deckController = new DeckController("6C 9C 8C 2D 7C 2H TC 4C 9S AH");
		assertEquals("Mao: 6C 9C 8C 2D 7C Monte: 2H TC 4C 9S AH Melhor Jogo: one-pair (1 par)", deckController.bestHand());
	}
	
	public void testBestHandTwoPairs(){
		DeckController deckController = new DeckController("AH 2C 9S AD 3C QH KS JS JD KD");
		assertEquals("Mao: AH 2C 9S AD 3C Monte: QH KS JS JD KD Melhor Jogo: two-pairs (2 pares)", deckController.bestHand());
	}
	
	public void testBestHandThreeOfAKind(){
		DeckController deckController = new DeckController("KS AH 2H 3C 4H KC 2C TC 2D AS");
		assertEquals("Mao: KS AH 2H 3C 4H Monte: KC 2C TC 2D AS Melhor Jogo: three-of-a-kind (trinca)", deckController.bestHand());
	}
	
	public void testBestHandStraight(){
		DeckController deckController = new DeckController("AC 2D 9C 3S KD 5S 4D KS AS 4C");
		assertEquals("Mao: AC 2D 9C 3S KD Monte: 5S 4D KS AS 4C Melhor Jogo: straight (sequencia numerica)", deckController.bestHand());
	}
	
	public void testBestHandFlush(){
		DeckController deckController = new DeckController("2H AD 5H AC 7H AH 6H 9H 4H 3C");
		assertEquals("Mao: 2H AD 5H AC 7H Monte: AH 6H 9H 4H 3C Melhor Jogo: flush (sequencia de naipe)", deckController.bestHand());
	}
	
	public void testBestHandFullHouse(){
		DeckController deckController = new DeckController("2H 2S 3H 3S 3C 2D 9C 3D 6C TH");
		assertEquals("Mao: 2H 2S 3H 3S 3C Monte: 2D 9C 3D 6C TH Melhor Jogo: full-house (trinca + par)", deckController.bestHand());
	}
	
	public void testBestHandFourOfAKinf(){
		DeckController deckController = new DeckController("2H 2S 3H 3S 3C 2D 3D 6C 9C TH");
		assertEquals("Mao: 2H 2S 3H 3S 3C Monte: 2D 3D 6C 9C TH Melhor Jogo: four-of-a-kind (quadra)", deckController.bestHand());
	}
	
	public void testBestHandStraightFlush(){
		DeckController deckController = new DeckController("TH JH QC QD QS QH KH AH 2S 6S");
		assertEquals("Mao: TH JH QC QD QS Monte: QH KH AH 2S 6S Melhor Jogo: straight-flush (sequencia numerica e de naipe)", deckController.bestHand());
	}

}
