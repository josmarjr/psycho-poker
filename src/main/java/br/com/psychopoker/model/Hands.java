package br.com.psychopoker.model;

public enum Hands {
	HIGHEST_CARD("highest-card (maior carta)"), ONE_PAIR("one-pair (1 par)"), TWO_PAIRS(
			"two-pairs (2 pares)"), THREE_OF_A_KIND("three-of-a-kind (trinca)"), STRAIGHT(
			"straight (sequencia numerica)"), FLUSH(
			"flush (sequencia de naipe)"), FULL_HOUSE(
			"full-house (trinca + par)"), FOUR_OF_A_KIND(
			"four-of-a-kind (quadra)"), STRAIGHT_FLUSH(
			"straight-flush (sequencia numerica e de naipe)");

	private String value;

	private Hands(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
