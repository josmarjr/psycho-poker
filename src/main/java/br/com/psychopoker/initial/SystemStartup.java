package br.com.psychopoker.initial;

import java.util.List;

import br.com.psychopoker.controller.DeckController;
import br.com.psychopoker.util.FileUtil;

public class SystemStartup {

	public static void main(String[] args) {
		List<String> decks = FileUtil.readFile("decks.txt");
		DeckController deckController = null;
		for(String deck : decks){
			deckController =  new DeckController(deck);
			System.out.println(deckController.bestHand());
		}
	}
}
