
var entrada;


function ocultar()
{
	document.getElementById("Noticias").style.display="none";
	document.getElementById("Instalaciones").style.display="none";
	document.getElementById("Servicios").style.display="none";
	document.getElementById("Contacto").style.display="none";
	document.getElementById("Registro").style.display="none";
	
}

function ver(entrada)
{
	document.getElementById(entrada).style.display="inline-block";

}