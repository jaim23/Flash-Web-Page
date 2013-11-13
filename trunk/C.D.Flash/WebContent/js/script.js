
var entrada;
var seleccion;


function ocultar(seleccion)
{	
	for(var i = 1 ;i<=seleccion;i++){
	document.getElementById('Opcion'+i).style.display="none";
	}
	
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