"use strict";

  if (annyang) {

    // define the functions our commands will run.
    var hello = function() {
      $("#hello").text("Hi buddy, What do you want from annyang?");
      
    };
    
    var turnOnRed = function() {
    	
        //$("#hello").text("...turning on red light");
        
        $.ajax({
			  type: 'POST',	
			  url: "turnOnLight.do",
			  data: { light: "red"}
			}).done(function(content) {
				
				$("#hello").text("...servo: LEFT");
			});
        
     };
     
     var turnOffRed = function() {
     	
         //$("#hello").text("...turning off red light");
         
         $.ajax({
 			  type: 'POST',	
 			  url: "turnOffLight.do",
 			  data: { light: "red"}
 			}).done(function(content) {
 				
 				$("#hello").text("...servo: RIGHT");
 			});
         
      };
     
     

    // * The key is what you want your users to say say.
    // * The value is the action to do.
    //   You can pass a function, a function name (as a string), or write your function as part of the commands object.
    var commands = {
      'hello': hello,
      'turn left': turnOnRed,
      'turn right': turnOffRed
    };

    
    annyang.init(commands);
    annyang.start();
  } 
  