package br.com.psychopoker.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	 * Método que verifica se há uma Dupla entre as 5 cartas.
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
	 * Método que verifica se há Duas Duplas entre as 5 cartas.
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
	 * Método que verifica se há uma Trinca entre as 5 cartas.
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
	 * Método que retorna um Map com a quantidade de vezes que as cartas com
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
