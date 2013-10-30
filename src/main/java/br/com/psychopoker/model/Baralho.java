package br.com.psychopoker.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.com.psychopoker.model.Carta.Naipe;
import br.com.psychopoker.model.Carta.ValorCarta;


public class Baralho {

	private LinkedList<Carta> cartas;
	private LinkedList<ValorCarta> valorCartas;
	
	public Baralho(List<Carta> cartas){
		Collections.sort(cartas);
		this.cartas = new LinkedList<Carta>();
		this.cartas.addAll(cartas);
		this.valorCartas = new LinkedList<ValorCarta>(Arrays.asList(ValorCarta.values()));
	}
	
	/**
	 * Metodo que verifica se ha uma Dupla entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasDupla(){
		if(this.cartas.size()>0){
			for(Integer quantidade : getMapValores().values()){
				if(quantidade.equals(2))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que verifica se ha Duas Duplas entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasDuasDuplas(){
		int stack = 0;
		for (Integer quantidade : getMapValores().values()){
			if (quantidade == 2){
				if(stack != 0)
					return true;
				else
					stack++;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que verifica se ha uma Trinca entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasTrinca(){
		for (Integer quantidade : getMapValores().values()){
			if (quantidade == 3)
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo que verifica se ha um Straight entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasStraight() {
		// Verifica se ha repeticao de cartas
		for (Integer quantidade : getMapValores().values()) {
			if (quantidade != 1)
				return false;
		}
		// Verifica a diferenca de index entre a ultima e a primeira carta
		if (diffCards(this.cartas.getFirst(), this.cartas.getLast()) == 4) {
			return true;
			// Verifica a excecao da sequencia do DEZ ao AS
		} else if (diffCards(this.cartas.getFirst(), this.cartas.get(1)) == 9
				&& this.cartas.getFirst().getValor().equals(ValorCarta.AS)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a diferenca de index entre as cartas.
	 * 
	 * @param cartaInicial
	 * @param cartaFinal
	 * @return
	 */
	private int diffCards(Carta cartaInicial, Carta cartaFinal) {
		int diff = this.valorCartas.indexOf(cartaFinal.getValor())
				- this.valorCartas.indexOf(cartaInicial.getValor());

		return diff;
	}
	
	/**
	 * Metodo que verifica se ha um Flush entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasFlush(){
		for(Naipe naipe : Naipe.values()){
			if(this.cartas.getFirst().getNaipe().equals(naipe)){
				Iterator<Carta> itCartas = this.cartas.iterator();
				while(itCartas.hasNext()){
					if(!itCartas.next().getNaipe().equals(naipe))
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que verifica se ha um Full House entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasFullHouse(){
		if (hasDupla() && hasTrinca())
			return true;
		return false;
	}
	
	/**
	 * Metodo que verifica se ha uma Quadra entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasQuadra(){
		for (Integer quantidade : getMapValores().values()){
			if (quantidade == 4)
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo que verifica se ha um Straight Flush entre as 5 cartas.
	 * 
	 * @return
	 */
	public boolean hasStraightFlush(){
		if (hasStraight() && hasFlush())
			return true;
		return false;
	}
	
	/**
	 * Metodo que retorna um Map com a quantidade de vezes que as cartas com
	 * mesmo valor aparecem no baralho.
	 * 
	 * @return
	 */
	private Map<ValorCarta, Integer> getMapValores(){
		
		Map<ValorCarta, Integer> mapValores = new HashMap<ValorCarta, Integer>();

		if (this.cartas.size() > 0) {
			Iterator<Carta> itCartas = cartas.iterator();
			while(itCartas.hasNext()){
				Carta carta = itCartas.next();
				Integer quantidade = mapValores.get(carta.getValor());
				if (quantidade == null) {
					mapValores.put(carta.getValor(), 1);
				} else {
					mapValores.put(carta.getValor(), quantidade + 1);
				}
			}
		}
		return mapValores;
	}
}
