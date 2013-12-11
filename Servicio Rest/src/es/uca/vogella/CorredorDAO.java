package es.uca.vogella;


import java.util.HashMap;
import java.util.Map;

public class CorredorDAO {
	
	private static Map<Integer, Corredor> CorredorMap	= new HashMap<Integer, Corredor>();
	
public CorredorDAO() {}
	
	public String insertar(Integer i ,Corredor C){
		if(CorredorMap.containsKey(i)){
			return "Posicion ocupada";
		}
		else{
		CorredorMap.put(i,C);
		return C.getNombre()+" Insertado con exito";
		}
	}
	
	public String borrar(Integer pos){
		if(CorredorMap.containsKey(pos)){
		CorredorMap.remove(pos);
		return "Borrado con exito";
		}
		else 
			return "No existe esa posición";
	}
	
	public Corredor buscar(Integer pos){
		return CorredorMap.get(pos);
	}
	public void actualizar(Integer pos,Corredor c){
		CorredorMap.put(pos,c);
	}

}
