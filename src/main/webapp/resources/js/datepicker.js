	$(function() {
	$("#issueDate").datepicker({
		dateFormat : "dd-mm-yy",
		inline : true,
		dayNamesMin : [ 'Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa' ],
		firstDay: 1,
	});
});
	$(function() {
		$("#expirationDate").datepicker({
			dateFormat : "dd-mm-yy",
			inline : true,
			dayNamesMin : [ 'Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa' ],
			firstDay: 1,
		});
	});