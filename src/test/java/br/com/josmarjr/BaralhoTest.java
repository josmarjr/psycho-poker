package br.com.josmarjr;

import java.util.ArrayList;
import java.util.List;

import br.com.josmarjr.model.Baralho;
import br.com.josmarjr.model.Carta;
import junit.framework.TestCase;

public class BaralhoTest extends TestCase{
	
	public void testHasDupla(){
		
		Baralho baralho = new Baralho(getDeck("6C 9C 8C 2D 7C 2H TC 4C 9S AH"));
		assertEquals(true, baralho.hasDupla());
	}
	
	public void testHasDuasDuplas(){
		Baralho baralho = new Baralho(getDeck("AH 2C 9S AD 3C QH KS JS JD KD"));
		assertEquals(true, baralho.hasDuasDuplas());
	}
	
	public void testHasTrinca(){
		Baralho baralho = new Baralho(getDeck("KS AH 2H 3C 4H KC 2C TC 2D AS"));
		assertEquals(true, baralho.hasTrinca());
	}

	public void testHasStraight(){
		Baralho baralho = new Baralho(getDeck("AC 2D 9C 3S KD 5S 4D KS AS 4C"));
		assertEquals(true, baralho.hasStraight());
	}
	
	public void testHasFlush(){
		Baralho baralho = new Baralho(getDeck("2H AD 5H AC 7H AH 6H 9H 4H 3C"));
		assertEquals(true, baralho.hasFlush());
	}
	
	public void testHasFullHouse(){
		Baralho baralho = new Baralho(getDeck("2H 2S 3H 3S 3C 2D 9C 3D 6C TH"));
		assertEquals(true, baralho.hasFullHouse());
	}
	
	public void testHasQuadra(){
		Baralho baralho = new Baralho(getDeck("2H 2S 3H 3S 3C 2D 3D 6C 9C TH"));
		assertEquals(true, baralho.hasQuadra());
	}
	
	public void testHasStraightFlush(){
		Baralho baralho = new Baralho(getDeck("TH JH QC QD QS QH KH AH 2S 6S"));
		assertEquals(true, baralho.hasStraightFlush());
	}
	
	private List<Carta> getDeck(String deck) {
		List<Carta> cartas = new ArrayList<Carta>();
		String[] deckArray = deck.split(" ");
		Carta carta = null;
		for (int i = 0; i < deckArray.length; i++) {
			carta = new Carta(deckArray[i].substring(0, 1),
					deckArray[i].substring(1, 2));
			cartas.add(carta);
		}
		return cartas;
	}
}
