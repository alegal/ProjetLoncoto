
$(function() {

	$("#tbDate").datepicker();
	$("#lstStatut").on("change", function() {
		fct_search();
	});
});

function fct_search(){
	statut = $("#lstStatut").val();
	site = $("#tbSite").val();
	client = $("#tbClient").val();
	valdate = $("#tbDate").val(); //
	
	
	
	console.log(statut);
	$("#divaffLstintervention").load('recherche?interventionStatut='+statut+'&site='+site+'&client='+client+'&interventionPlanified_at='+valdate);
/*	$.ajax({
		type:"POST",
		url : 'recherche?interventionStatut='+statut+'&site='+site+'&client='+client+'&interventionPlanified_at='+valdate,
		contentType: 'application/json; charset=utf-8',
		dataType: 'json',
		success: function(msg){
			console.log(msg);
			$("#divaffLstintervention").empty();
			$("#divaffLstintervention").append(msg);
	    }
		
	});
	*/
}
