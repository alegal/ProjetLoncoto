$(document).ready(function() {
	$(".dropdown-button").dropdown();
	$('select').material_select();
	$('.button-collapse').sideNav({
		menuWidth: 240, // Default is 240
    	edge: 'left', // Choose the horizontal origin
    	closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
    });
	$('.button-collapse-second').sideNav({
		menuWidth: 240, // Default is 240
    	edge: 'right', // Choose the horizontal origin
    	closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
    });
	
	 $(document).ready(function(){
		    $('ul.tabs').tabs();
	});
});

