$(document).ready(function(){
	
	//listen to button event
	$("#load-list-btn").bind("click", function(){
		
		$("#employees-table tbody").empty();
		
		//do ajax call
		$.ajax({
			type:"post",
			url:"http://localhost:8080/recipe3/list/employees/",
			contentType: "application/json; charset=utf-8",
			headers: {},
	        dataType:"json",
	        data:null,
	        success: function(data, textStatus, XMLHttpRequest) {
	        	
	        	for(var i = 0; i < data.length; i++){
	        		
	        		var employee = data[i];
	        		
	        		var html = [
	        		    "<tr>",
	        		    	"<td>",
	        		    		employee.id,
	        		    	"</td>",
	        		    	"<td>",
        		    			employee.firstName,
        		    		"</td>",
        		    		"<td>",
    		    				employee.lastName,
    		    			"</td>",
    		    			"<td>",
    		    				employee.department,
    		    			"</td>",
    		    			"<td>",
    		    			    employee.role,
    		    			"</td>",
    		    			"<td>",
    		    				employee.salary,
    		    			"</td>",
	        		    "</tr>"
	        		].join("");
	        		
	        		$("#employees-table tbody").append(html);
	        	}
	        	
	        },
	        error: function(xhr, status, error){
	             alert(xhr.responseText);
	         }
		});
	});
	
});