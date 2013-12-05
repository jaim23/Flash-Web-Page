function insertar(){
	
	$.ajax( {
		type:"POST",
		url:"http://localhost:8080/flash/insertar/",
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
	$.ajax({
		var Pos = document.getElementById("Pos");
		type:"GET",
		dataType:"json",
		url:"http://localhost:8080/flash/buscar",
		var res=data.nombre + data.metros + data.tiempo,
		success: function(data){ $("#Consulta").html("<p>"+ res +"</p>");}
	});
}