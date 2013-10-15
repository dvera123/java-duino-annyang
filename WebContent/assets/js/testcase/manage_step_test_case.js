var manageStep = {
		init: function(){
			this.add();
		},
		add: function(){
			$('#addStep').click(function(){
				$('.stepList').html($('.step').clone().show());
				manageStep.remove();
			});
		},
		remove: function(){
			$('.deleteStep').click(function(){
				$(this).parent().remove();
			});	
		}
};

$(document).ready(function(){
	manageStep.init();
});