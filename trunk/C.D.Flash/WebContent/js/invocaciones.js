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
	url:"http://localhost:8082/flash/buscar/"+Pos.value;
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