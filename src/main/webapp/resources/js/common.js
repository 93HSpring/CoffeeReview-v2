$(document).ready(function() {
    		
	var searchForm = $("#searchForm");
	
	searchForm.find("input[name='keyword']").val("");
	
	$("#searchForm button").on("click", function(e) {
		
		if (!searchForm.find("option:selected").val()) {
			
			alert("카페를 선택하세요")
			return false;
			
		}
		
		if (!searchForm.find("input[name='keyword']").val()) {
			
			alert("키워드를 입력하세요")
			return false;
			
		}
		
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();
		
		searchForm.submit();
		
	});
	
	
	$(".form-input").keydown(function(key) {

		if (key.keyCode == 13) {
			
			console.log("Enter!!");
		
			if (!searchForm.find("option:selected").val()) {
				
				alert("카페를 선택하세요")
				return false;
				
			}
			
			if (!searchForm.find("input[name='keyword']").val()) {
				
				alert("키워드를 입력하세요")
				return false;
				
			}
			
			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			
			searchForm.submit();
		
		}
	
	});
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
	
});