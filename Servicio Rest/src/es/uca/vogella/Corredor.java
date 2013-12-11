package es.uca.vogella;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Corredor {
	String nombre;
	float tiempo;
	long metros;
	
public Corredor(String nombre, long metros, float tiempo){
	this.nombre=nombre;
	this.metros=metros;
	this.tiempo=tiempo;
}
	
public Corredor(){}	
	
public String getNombre(){return nombre;}
public long getMetros(){return metros;}
public float getTiempo(){return tiempo;}

public void setNombre(String n){nombre=n;}
public void setMetros(long n){metros=n;}
public void setTiempo(float n){tiempo=n;}
	
}
