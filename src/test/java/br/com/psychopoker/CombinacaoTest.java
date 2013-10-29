package br.com.psychopoker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import br.com.psychopoker.model.Carta;
import br.com.psychopoker.util.Combinacao;

public class CombinacaoTest extends TestCase{
	
	public void testNext(){
		Combinacao<Carta> combinacao = new Combinacao<Carta>(getDeck("TH JH QH KH AH"), 3);
		List<List<Carta>> cartas = new LinkedList<List<Carta>>();
		while(combinacao.hasNext())
			cartas.add(combinacao.next());
		assertEquals(10, cartas.size());
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
