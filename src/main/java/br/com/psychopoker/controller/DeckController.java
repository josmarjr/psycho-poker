package br.com.psychopoker.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.psychopoker.model.Baralho;
import br.com.psychopoker.model.Carta;
import br.com.psychopoker.model.Hands;
import br.com.psychopoker.util.Combinacao;


public class DeckController {

	private LinkedList<Carta> cartas;
	List<List<Carta>> combination = null;
	private String stringDeck;
	private LinkedList<Hands> hands = null;
	
	public DeckController(String deck) {
		this.hands = new LinkedList<Hands>();
		this.cartas = new LinkedList<Carta>();
		setDeck(deck);
		doAllCombination();
		calculateHands();
	}
	
	public DeckController() {

	}

	public String bestHand(){
		String saida = "Mao: %s Monte: %s Melhor Jogo: %s";
		return String.format(saida, this.stringDeck.substring(0, 14), this.stringDeck.substring(15, 29), this.hands.getLast().getValue());
	}
	private void calculateHands() {
		Baralho deck = null;
		for(List<Carta> cards : this.combination){
			deck = new Baralho(cards);
			if(deck.hasDupla())
				this.hands.add(Hands.ONE_PAIR);
			if(deck.hasDuasDuplas())
				this.hands.add(Hands.TWO_PAIRS);
			if(deck.hasTrinca())
				this.hands.add(Hands.THREE_OF_A_KIND);
			if(deck.hasStraight())
				this.hands.add(Hands.STRAIGHT);
			if(deck.hasFlush())
				this.hands.add(Hands.FLUSH);
			if(deck.hasFullHouse())
				this.hands.add(Hands.FULL_HOUSE);
			if(deck.hasQuadra())
				this.hands.add(Hands.FOUR_OF_A_KIND);
			if(deck.hasStraightFlush())
				this.hands.add(Hands.STRAIGHT_FLUSH);
		}
		if(this.hands.size() == 0)
			this.hands.add(Hands.HIGHEST_CARD);
		Collections.sort(this.hands);
	}

	public void setDeck(String deck) {
		this.stringDeck = deck;
		String[] deckArray = deck.split(" ");
		Carta carta = null;
		for (int i = 0; i < deckArray.length; i++) {
			carta = new Carta(deckArray[i].substring(0, 1),
					deckArray[i].substring(1, 2));
			this.cartas.add(carta);
		}
	}

	private void doAllCombination() {
		List<Carta> hand = new LinkedList<Carta>(this.cartas.subList(0, 5));
		List<Carta> deck = new LinkedList<Carta>(this.cartas.subList(5, 10));
		combination = new LinkedList<List<Carta>>();
		for (int remove = 0; remove <= 5; remove++) {
			combination.addAll(doCombination(hand, deck, remove));
		}
	}

	private List<List<Carta>> doCombination(List<Carta> hand,
			List<Carta> deck, int remove) {

		List<List<Carta>> listPermuta = new LinkedList<List<Carta>>();
		if(remove == 0){
			listPermuta.add(hand);
			return listPermuta;
		}else if (remove == 5){
			listPermuta.add(deck);
			return listPermuta;
		}
		
		List<Carta> buyDeck = new LinkedList<Carta>(deck.subList(0, remove));
		Combinacao<Carta> combinacao = new Combinacao<Carta>(hand, 5-remove);
		List<Carta> resultHand = null;
		while(combinacao.hasNext()){
			resultHand = combinacao.next();
			resultHand.addAll(buyDeck);
			listPermuta.add(resultHand);
		}
		return listPermuta;
	}
	
}
