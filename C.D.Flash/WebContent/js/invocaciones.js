
function getCorredor(){
	var Pos = document.getElementById('txPos').value;
	var uri="http://localhost:8080/es.uca.vogella/demo/flash/buscar/"+Pos;

	$.ajax({
		type:"GET",
		url:uri,
		dataType:"xml",
		success: function(data){
		var $XML=$(data);
		var metros = $XML.find('metros').text();
		var nombre = $XML.find('nombre').text();
		var tiempo = $XML.find('tiempo').text();
		var page =("<h1>Corredor</h1>" +
				"<table>" +
				"<tr>" +
				"<td><h3>Nombre</h3></td>" +
				"<td><h3>Tiempo<h3></td>" +
				"<td><h3>Metros</h3></td>" +
				"</tr> <tr>" +
				"<td><p>"+nombre+"</p></td>" +
				"<td><p>"+tiempo+"</p></td>" +
				"<td><p>"+metros+"</p></td>" +
				"</tr></table>");
		document.getElementById('Resultado').innerHTML=page;

	},
	error:function(res){
		alert("Oh no! " + res.statusText);
		}
	});
}

function insertar(){
	var Pos = document.getElementById('txPos').value;
	$.ajax( {
		type:"POST",
		url:"http://localhost:8080/es.uca.vogella/demo/flash/insertar/"+Pos,
		contentType:"application/json",
		data:JSON.stringify( {"nombre":$('#txtNombre').val(),"metros":$('#txtMetros').val(),"tiempo":$('#txtTiempo').val()}),
		success:function(res){
			document.getElementById('Resultado').innerHTML=res;

		},
		error:function(res){
		alert("Oh no! " + res.statusText);
		}
		});	
}

function update(){
	var Pos = document.getElementById('txPos').value;
	$.ajax( {
		type:"PUT",
		url:"http://localhost:8080/es.uca.vogella/demo/flash/actualizar/"+Pos,
		contentType:"application/json",
		data:JSON.stringify( {"nombre":$('#txtNombre').val(),"metros":$('#txtMetros').val(),"tiempo":$('#txtTiempo').val()}),
		success:function(res){
			document.getElementById('Resultado').innerHTML=res;
		
		},
		error:function(res){
		alert("Oh no! " + res.statusText);
		}
		});
	
}

function borrar(){
	var Pos = document.getElementById('txPos').value;
	var uri="http://localhost:8080/es.uca.vogella/demo/flash/borrar/"+Pos;
	$.ajax({
		type: "DELETE",
		url: uri,
		success: function(res){
			document.getElementById('Resultado').innerHTML=res;

		},
		error:function(res){
			alert("Oh no! " + res.statusText);
			}
		});
}
