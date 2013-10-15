$(document).ready(function(){
	//ajax call delete Test Case
	$('.deleteTCForm').submit(function(e){
		e.preventDefault();
		$.ajax({
			  type: 'POST',	
			  url: "delete.do",
			  data: $(this).serialize()
			}).done(function(content) {
				$('#testCaseList').html(content);
			});
		});
});