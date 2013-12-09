
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

function validar_mensaje(){
	var x=document.forms["contacto"]["nombre"].value;
	if (x==null || x=="")
	{
	  alert("Campo Nombre no puede estar vacío");
	  return false;
	}
	
	var c =document.forms["contacto"]["correo"].value;
	var correo=/[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;
	
	if(correo.test(c)!=true)
	{
		alert("Correo No Válido");
		return false;
	}
	
	var m =document.forms["contacto"]["mensaje"].value;
	if (m==null || m=="")
	{
	  alert("Debes mandar un mensaje");
	  return false;
	}
	
}

function validar(){
	
	var x=document.forms["registro"]["nombre"].value;
	if (x==null || x=="")
	{
	  alert("Campo Nombre no puede estar vacío");
	  return false;
	}
	
	var y=document.forms["registro"]["apellidos"].value;
	if (y==null || y=="")
	{
	  alert("Campo Apellido no puede estar vacío");
	  return false;
	}
	var c =document.forms["registro"]["correo"].value;
	var correo=/[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;
	
	if(correo.test(c)!=true)
		{
			alert("Correo No Válido");
			return false;
		}
	
	var patron=/^[a-zA-Z].*$/;
  	var patronpass1=/(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$/;

	var pass=document.forms["registro"]["pwd"].value;
	
	
	if(pass!="")
	{
		if(patron.test(pass)!=true)
  		{
  			alert("No ha introducido la letra obligatoria");
  			return false;
  		}
  		
  		if(pass.length > 5)
  		{	
  			if(patronpass1.test(pass)!=true)
  			{
  				alert("Introduce una contraseña válida");
  				return false;
  			}
  			
  			
  		}
  		else
  		{
 			alert("Tamaño de contraseña no válido");
 			return false;
 		}
	}
	else
	{
  		alert("Error campo de contraseña vacío");
  		return false;
	}
	
	
	var c_pwd=document.forms["registro"]["c_pwd"].value;
	
	if(c_pwd != pass){
	  alert("Contraseñas No Coinciden");	
	  return false;
	}
	
	var av = document.forms["registro"]["condiciones"].checked;
	if( av == false){
		alert("Debes Leer y Aceptar el aviso legal");
		return false;
	}
	
}