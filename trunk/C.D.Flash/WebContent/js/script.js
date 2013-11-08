
var entrada;
var entrada1;

function ocultar()
{
	document.getElementById("Noticias").style.display="none";
	document.getElementById("Instalaciones").style.display="none";
	document.getElementById("Servicios").style.display="none";
	document.getElementById("Registro").style.display="none";
	
}

function ver(entrada1)
{
	document.getElementById(entrada1).style.display="inline-block";

}