package br.com.josmarjr.model;

import java.util.ArrayList;
import java.util.List;

public class Carta implements Comparable<Carta>{

	private ValorCarta valor;
	private Naipe naipe;
	
	public Carta(){
		
	}
	
	/**
	 * Recebe os valores de {@link ValorCarta} e {@link Naipe} e cria os enums corretos.
	 * 
	 * @param valor Valor do enum {@link ValorCarta}
	 * @param naipe Valor do enum {@link Naipe}
	 */
	public Carta(String valor, String naipe){
		this. valor = ValorCarta.getEnum(valor);
		this.naipe = Naipe.getEnum(naipe);
	}
	
	public ValorCarta getValor() {
		return valor;
	}
	public void setValor(ValorCarta valor) {
		this.valor = valor;
	}
	public Naipe getNaipe() {
		return naipe;
	}
	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}
	
	public boolean sameValue(Carta carta){
		if(getValor().equals(carta.getValor())){
			return true;
		}
		return false;
	}
	
	public boolean sameValue(ValorCarta valor){
		if(getValor().equals(valor)){
			return true;
		}
		return false;
	}
	
	public boolean sameNaipe(Carta carta){
		if(getNaipe().equals(carta.getNaipe())){
			return true;
		}
		return false;
	}
	
	public enum ValorCarta {
		AS("A"), DOIS("2"), TRES("3"), QUATRO("4"), CINCO("5"), SEIS("6"), SETE(
				"7"), OITO("8"), NOVE("9"), DEZ("T"), VALETE("J"), DAMA("Q"), REIS(
				"K");

		private String valorCarta;

		private ValorCarta(String valorCarta) {
			this.valorCarta = valorCarta;
		}

		public String getValorCarta() {
			return this.valorCarta;
		}
		
		public static ValorCarta getEnum(String value) {
			for (ValorCarta re : ValorCarta.values()) {
				if (re.valorCarta.compareTo(value) == 0) {
					return re;
				}
			}
			throw new IllegalArgumentException("Invalid ValorCarta value: "
					+ value);
		}
		
		public static List<ValorCarta> getListValores(){
			List<ValorCarta> valores = new ArrayList<Carta.ValorCarta>();
			for (ValorCarta valor : ValorCarta.values()) {
				valores.add(valor);
			}
			return valores;
		}
		
	}

	public enum Naipe {
		PAUS("C"), OURO("D"), COPAS("H"), ESPADA("S");

		private String naipe;

		private Naipe(String naipe) {
			this.naipe = naipe;
		}

		public String getValorNaipe() {
			return this.naipe;
		}
		
		public static Naipe getEnum(String value) {
			for (Naipe re : Naipe.values()) {
				if (re.naipe.compareTo(value) == 0) {
					return re;
				}
			}
			throw new IllegalArgumentException("Invalid Naipe value: "
					+ value);
		}

	}

	@Override
	public int compareTo(Carta carta) {
		return getValor().compareTo(carta.getValor());
	}

}
