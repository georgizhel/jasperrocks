$(document).ready(function() {
	$.subscribe('grid1OnSelectRowTopics', function(event, data) {
		var grid = event.originalEvent.grid; 
		var sel_id = grid.jqGrid('getGridParam', 'selrow'); 
		var uriString = grid.jqGrid('getCell', sel_id, 'uriString'); 
		var wsType = grid.jqGrid('getCell', sel_id, 'wsType'); 
		var label1 = grid.jqGrid('getCell', sel_id, 'label1'); 
		$('#urlString').val(uriString);
		$('#wsType').val(wsType);
		$('#label1').val(label1);
		$('#formView1').submit();
	});
});
