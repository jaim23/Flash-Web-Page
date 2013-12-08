function insertar(){
	
	$.ajax( {
		type:"POST",
		url:"http://localhost:8082/flash/insertar/",
		contentType:"application/json",
		data:JSON.stringify( {"nombre":$('#CorredorNombre').val(),"metros":$('#Metros').val(),"tiempo":$('#Minutos').val()}),
		success:function(res){
			$("#Consulta").html("<p>"+ res +"</p>");
		},
		error:function(res){
		alert("Oh no! " + res.statusText);
		}
		});	
}


function getCorredor(){
	var Pos = document.getElementById("Pos");
	url:"http://localhost:8082/servidorFlash/Flash/buscar/"+Pos.value;
	$.ajax({
		type:"GET",
		dataType:"xml",
		success:function(data){
			var $XML=$(data);
			var nombre=$XML.find('nombre').text();
			var tiempo=$XML.find('tiempo').text();
			var metros=$XML.find('metros').text();
			var page=("<p>"+nombre+tiempo+metros+"</p>");
			var corredor=document.getElementById("Resultado");
			corredor.innerHTML=page;
		}
	});
}


function changeFunc() {
    var selectBox = document.getElementById("selectBox");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    if (selectedValue== 1){
    	document.getElementById("SendButton").style.display="block";
    	document.getElementById("table").style.display="none";
    	document.getElementById("tablePos").style.display="block";
    	$("#send").attr("onClick","consultar()");
    	$('#txPos').val("");
    }
    if (selectedValue== 2){
    	document.getElementById("SendButton").style.display="block";
    	document.getElementById("tablePos").style.display="none";
    	document.getElementById("table").style.display="block";
    	$("#send").attr("onClick","anadir()");    
    	$('#txtNombre').val("");
    	$('#txtTiempo').val("");
    	$('#txtMetros').val("");
    }
    if (selectedValue== 3){
    	document.getElementById("SendButton").style.display="block";
    	document.getElementById("table").style.display="block";
    	document.getElementById("tablePos").style.display="none";
    	$("#send").attr("onClick","modificar()");   
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