$(document).ready(function(){
	
	//ajax call add Test Case
	$('#testCase').submit(function(e){
		var target = $(this);
		e.preventDefault();
		$.ajax({
			  type: 'POST',	
			  url: "save.do",
			  data: target.serialize()
			}).done(function(content) {
				$('#myModal').modal('hide');
				target.each (function(){
					  this.reset();
				});
				$('#testCaseList').html(content);
			});
		});
	
	//ajax call update Test Case
	$('#testCaseDetail').submit(function(e){
		var target = $(this);
		e.preventDefault();
		$.ajax({
			  type: 'POST',	
			  url: "update.do",
			  data: target.serialize()
			}).done(function(content) {});
		});
	
	
});

