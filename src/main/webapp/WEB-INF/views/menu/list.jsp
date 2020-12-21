<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../includes/header.jsp" %>

<body>

    <div id="wrapper">

		<!-- Navigation -->
        <%@include file="../includes/nav.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">메뉴</h1>
                    <div class="form-group pull-right">
			            <select class="form-control orderSelect">
			            	<option value="" selected>정렬 선택</option>
			               	<option value="star_avg">별점</option>
			               	<option value="caffeine">카페인</option>
			               	<option value="kcal">칼로리</option>
			               	<option value="sodium">나트륨</option>
			               	<option value="sugars">당분</option>
			            </select>
	            	</div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            
            
            <!-- 메뉴 목록 출력 -->
            <div class="row">
                <c:forEach items="${list}" var="menuInfo">
                    <div class="col-xs-6 col-sm-6 col-md-3">
                    	<a class='move' href='<c:out value="${menuInfo.mno}"/>'>
	                    	<div class="panel panel-default">
	                        	<div class="mname panel-heading text-center">
	                        		<c:out value="${menuInfo.menu}" />
	                        	</div>
	                        	<div class="panel-body p-0">
	                        		<img src='/menu/display?menuName=<c:out value="${pageMaker.cri.cafe}" />/<c:out value="${menuInfo.menu}" />' class="full-width">
	                        	</div>
	                        	<div class="panel-footer list-star text-center">
	                        		<i class="fa fa-star fa-fw m-0"></i>
	                        		<c:out value="${menuInfo.star_avg}" />
	                        		<b>[ <c:out value="${menuInfo.replyCnt}" /> ]</b>
	                        	</div>
	                        </div>
	                    	<!-- /.panel -->
	                    </a>
                	</div>
                	<!-- /.col-xs-3 -->
                </c:forEach>
            </div>
            <!-- 메뉴 목록 출력 끝 -->
            
            <!-- 페이징 처리 -->
            <div class="text-center">
            	<ul class="pagination">
            		<c:if test="${pageMaker.prev}">
            			<li class="paginate_button previous">
            				<a href='<c:out value="${pageMaker.startPage - 1}"/>'><i class="fa fa-angle-double-left"></i></a>
            			</li>
            		</c:if>
            			
            		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
            			<li class="<c:out value= "${pageMaker.cri.pageNum == num ? 'paginate_button active': 'paginate_button'}" />">
            				<a href='<c:out value="${num}"/>'>${num}</a>
            			</li>
            		</c:forEach>
            		
            		<c:if test="${pageMaker.next}">
            			<li class="paginate_button next">
            				<a href='<c:out value="${pageMaker.endPage + 1}"/>'><i class="fa fa-angle-double-right"></i></a>
            			</li>
            		</c:if>            		
            	</ul>
            </div>
            <form id='actionForm' action="/menu/list" method='get'>
            	<input type='hidden' name='cafe' value='<c:out value="${pageMaker.cri.cafe}" />'>
            	<input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}" />'>
            	<input type='hidden' name='orderKeyword' value='<c:out value="${pageMaker.cri.orderKeyword}" />'>
				<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}" />'>	
				<!-- <input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}" />'> -->
			</form>
            <!-- 페이징 처리 끝 -->            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- plugin-js -->
    <%@include file="../includes/plugin_js.jsp" %>
    
    <!-- import JS -->
   	<script type="text/javascript" src="/resources/js/common.js?ver=0.1.1"></script>
    
    <script>
    
    	$(document).ready(function() {
    		
    		// 주소의 파라미터를 구하는 함수
    		// $.urlParam(파라미터 이름);
    		$.urlParam = function(name){
    		    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    		    if (results==null){
    		       return null;
    		    }
    		    else{
    		       return results[1] || 0;
    		    }
    		}
    		
    		var actionForm = $("#actionForm");    		
    		
    		// orderKeyword의 값이 없을 경우 url 파라미터에서 제거
    		if (!actionForm.find("input[name=orderKeyword]").val())	{
    			
    			console.log('orderKeyword is empty');
    			actionForm.find("input[name=orderKeyword]").remove();
    			
    		}
    		
			// keyword의 값이 없을 경우 url 파라미터에서 제거
    		if (!actionForm.find("input[name=keyword]").val()) {
    			
    			console.log('keyword is empty');
    			actionForm.find("input[name=keyword]").remove();
    			
    		}
    		
    		// 페이지를 눌러 이동 시
    		$(".paginate_button a").on("click", function(e) {
    			
    			// 현재 페이지와 같은 페이지를 클릭할 경우
				if (${pageMaker.cri.pageNum} == $(this).attr("href") ) {
    				
    				console.log("같은 페이지");
    				return false;
    				
    			}

				e.preventDefault();

				console.log('click');

				actionForm.find("input[name=pageNum]").val($(this).attr("href"));			
				
				actionForm.submit();
			});
    		
    		// 메뉴 정보로 이동 시
    		$(".move").on("click", function(e) {
    			
    			e.preventDefault();
    			actionForm.append("<input type='hidden' name='mno' value='" + $(this).attr("href") + "'>");   
    			actionForm.attr("action", "/menu/info");
    			actionForm.submit();
    			
    		});
    		
    		// 정렬을 위한 select option을 선택 시
    		$(".orderSelect").on("change", function(e) {
    			
    			console.log("정렬 선택");
    			
    			if (!$(this).val()) {
    				
    				console.log("정렬 미선택");
    				return false;
    				
    			}
    			
    			e.preventDefault();
    			
    			console.log('>> ' + $(this).val());
    			
    			if (!actionForm.find("input[name=orderKeyword]").val()) {    				
    				
    				actionForm.append("<input type='hidden' name='orderKeyword' value='" + $(this).val() + "'>");
    				
    			}
    			else {
    				
    				actionForm.find("input[name=orderKeyword]").val($(this).val());
    				
    			}
    			
    			actionForm.submit();
    			
    		})
    
    	});
    
    </script>

</body>

</html>
