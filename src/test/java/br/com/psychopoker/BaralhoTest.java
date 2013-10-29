package br.com.psychopoker;

import java.util.ArrayList;
import java.util.List;

import br.com.psychopoker.model.Baralho;
import br.com.psychopoker.model.Carta;
import junit.framework.TestCase;

public class BaralhoTest extends TestCase{
	
	public void testHasDupla(){
		
		Baralho baralho = new Baralho(getDeck("7H 9C 8C 2D 7C"));
		assertEquals(true, baralho.hasDupla());
	}
	
	public void testHasDuasDuplas(){
		Baralho baralho = new Baralho(getDeck("AH 2C 9S AD 2H"));
		assertEquals(true, baralho.hasDuasDuplas());
	}
	
	public void testHasTrinca(){
		Baralho baralho = new Baralho(getDeck("KS KD KH 3C 4H"));
		assertEquals(true, baralho.hasTrinca());
	}

	public void testHasStraight(){
		Baralho baralho = new Baralho(getDeck("AC 2D 3S 5S 4D"));
		assertEquals(true, baralho.hasStraight());
	}
	
	public void testHasFlush(){
		Baralho baralho = new Baralho(getDeck("2H KH 5H AH 7H"));
		assertEquals(true, baralho.hasFlush());
	}
	
	public void testHasFullHouse(){
		Baralho baralho = new Baralho(getDeck("2H 2S 3H 3S 3C"));
		assertEquals(true, baralho.hasFullHouse());
	}
	
	public void testHasQuadra(){
		Baralho baralho = new Baralho(getDeck("2H 3H 3S 3C 3D"));
		assertEquals(true, baralho.hasQuadra());
	}
	
	public void testHasStraightFlush(){
		Baralho baralho = new Baralho(getDeck("TH JH QH KH AH"));
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
