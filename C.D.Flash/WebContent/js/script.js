
var entrada;
var seleccion;

/*Función que nos oculta los submenus no seleccionados*/
function ocultar(seleccion)
{	
	for(var i = 1 ;i<=seleccion;i++){
	document.getElementById('Opcion'+i).style.display="none";
	}
	
}

/*Función que nos muestra el submenu seleccionado*/
function ver(entrada)
{
	document.getElementById(entrada).style.display="inline-block";

}

/*Función que nos muestra un formulario u otro, dependiendo de la selección de la caja*/
function changeFunc() {
    var selectBox = document.getElementById("selectBox");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    if (selectedValue== 1){
    	document.getElementById("SendButton").style.display="block";
    	document.getElementById("table").style.display="none";
    	document.getElementById("tablePos").style.display="block";
    	$("#send").attr("onClick","getCorredor()");
    	$('#txPos').val("");
    }
    if (selectedValue== 2){
    	document.getElementById("SendButton").style.display="block";
    	document.getElementById("tablePos").style.display="block";
    	document.getElementById("table").style.display="block";
    	$("#send").attr("onClick","insertar()");    
    	$('#txtNombre').val("");
    	$('#txtTiempo').val("");
    	$('#txtMetros').val("");
    }
    if (selectedValue== 3){
    	document.getElementById("SendButton").style.display="block";
    	document.getElementById("table").style.display="block";
    	document.getElementById("tablePos").style.display="block";
    	$("#send").attr("onClick","update()");   
    	$('#txtPos').val("");
    	$('#txtNombre').val("");
    	$('#txtMetros').val("");
    }
    if (selectedValue== 4){
    	document.getElementById("SendButton").style.display="block";
    	document.getElementById("tablePos").style.display="block";
    	document.getElementById("table").style.display="none";
    	$("#send").attr("onClick","borrar()");
    	$('#txPos').val("");
    }
}

/*Función para validar los campos del formulario de contacto*/
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

/*Función que valida los campos del formulario de registro*/
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