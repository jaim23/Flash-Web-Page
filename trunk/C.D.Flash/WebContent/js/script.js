
var entrada;


function ocultar()
{
	document.getElementById("Opcion1").style.display="none";
	document.getElementById("Opcion2").style.display="none";
	document.getElementById("Opcion3").style.display="none";
	document.getElementById("Opcion4").style.display="none";
	document.getElementById("Opcion5").style.display="none";
	
}

function ver(entrada)
{
	document.getElementById(entrada).style.display="inline-block";

}

function validar(){
	
	var x=document.forms["registro"]["nombre"].value;
	if (x==null || x=="")
	{
	  alert("Campo Nombre no puede estar vacio");
	  return false;
	}
	
	var y=document.forms["registro"]["apellidos"].value;
	if (y==null || y=="")
	{
	  alert("Campo Apellido no puede estar vacio");
	  return false;
	}

}