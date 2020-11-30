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
                   <form id='operForm' action="/menu/list" method="get">
                      <input type='hidden' name='cafe' value='<c:out value="${cri.cafe}"/>'>
                      <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
                      <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
                      <!-- <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'> -->
                      <input type='hidden' id='mno' name='mno' value='<c:out value="${menuInfo.mno}"/>'>
                   </form>
                   
                    <h1 class="page-header">${menuInfo.cafe} <button data-oper='list' class="btn btn-info pull-right">List</button></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                             ${menuInfo.menu}
                          </div>
                          <div class="panel-body">
                             <div class="col-sm-6">
                                <img src='/menu/display?menuName=${menuInfo.cafe}/${menuInfo.menu}' class="full-width">
                             </div>
                             <div class="col-sm-6">
                                <h3> 상세 정보 </h3>
                                <ul>
                                   <li>
                                      <dl>
                                         <dt>카페인 (mg)</dt><dd>${menuInfo.caffeine}</dd>
                                      </dl>
                                   </li>
                                   <li>
                                      <dl>
                                         <dt>칼로리 (kcal)</dt><dd>${menuInfo.kcal}</dd>
                                      </dl>
                                   </li>
                                   <li>
                                      <dl>
                                         <dt>나트륨 (mg)</dt><dd>${menuInfo.sodium}</dd>
                                      </dl>
                                   </li>
                                   <li>
                                      <dl>
                                         <dt>당류 (g)</dt><dd>${menuInfo.sugars}</dd>
                                      </dl>
                                   </li>
                                </ul>
                             </div>
                          </div>
                          <div class="panel-footer">
                             
                          </div>
         
                       </div>
                    <!-- /.panel -->
                    <!-- 리뷰 목록 시작 -->
                    <div class="panel panel-default">
                       <div class="panel-heading">
                          <i class="fa fa-comments fa-fw"></i> Reply
                          <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
                       </div>
                       
                       <div class="panel-body">
                          <ul class="chat">
                             <!-- 리뷰 목록 출력 시작 -->
                             
                             <!-- 리뷰 목록 출력 끝 -->
                          </ul>
                       </div>
                       
                       <div class="panel-footer replyPageFooter">
                          
                       </div>
                    </div>
                    <!-- 리뷰 목록 끝 -->
                    
                   </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
    <!-- 리뷰 Modal 처리 시작 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
          <div class="modal-content">
             <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
             </div>
             <div class="modal-body">
                <div class="form-group">
                   <label>Reply</label>
                   <input class="form-control" placeholder="리뷰를 작성해 주세요..." name="reply" value="New Reply!!!!" maxlength=1000>
                   <p class="data_count col-12 m-0">
                     <em id="modalMessagebyte">0</em> / 1000
                  </p>
                </div>
                <div class="form-group">
                   <label>Replyer</label>
                   <input class="form-control" name="replyer" value="replyer">
                </div>
                <div class="form-group">
                   <label>Reply Date</label>
                   <input class="form-control" name="replyDate" value="">
                </div>
                <div class="form-group">
                   <label>Reply Star</label>
                   <div class="make_star text-center" style="font-size: 3em;">
                      
                  </div>
                  <input class="form-control" name="star" value="star">
                </div>
             </div>
             <div class="modal-footer">
                <button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
                <button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
                <button id="modalRegisterBtn" type="button" class="btn btn-success">Register</button>
                <button id="modalCloseBtn" type="button" class="btn btn-default">Close</button>
             </div>
          </div>
       </div>
    </div>
    <!-- 리뷰 Modal 처리 끝 -->

    <!-- plugin-js -->
    <%@include file="../includes/plugin_js.jsp" %>
    
    <!-- import JS -->
      <script type="text/javascript" src="/resources/js/common.js?ver=0.1.2"></script>
    
    <script type="text/javascript" src="/resources/js/reply.js"></script>
    
    <script type="text/javascript">
    
    //console.log("================");
    //console.log("JS TEST");
    
    //var mnoValue = '<c:out value="${menuInfo.mno}"/>';
    
    // Reply Add Test
    //replyService.add(
      //   {reply:"JS Test", replyer:"tester", mno:mnoValue},
      //   function(result) {
      //      alert("RESULT : " + result);
      //   }
    //);
    
    // Reply List Test
    //replyService.getList({mno:mnoValue, page:1}, function(list) {
       
    //   for (var i = 0, len = list.length||0; i < len; i++) {
          
    //      console.log(list[i]);
          
    //   }
       
    //});
    
    // Reply Remove Test
    //replyService.remove(10, function(count) {
       
    //   console.log(count);
       
    //   if (count === "success") {
    //      alert("REMOVED");
    //   }
       
    //}, function(err) {
    //   alert('ERROR...');
    //});
    
    // Reply Update Test
    //replyService.update({
    //   rno : 2,
    //   mno : mnoValue,
    //   reply : "Modified Reply..."
    //}, function(result) {
    //   alert("수정 완료...");
    //});
    
    // 특정 번호 리뷰 조회
    // replyService.get(8, function(data) {
    //   console.log(data);
    //});
    
    </script>
    
    <script>
    $(document).ready(function() {
      
      var operForm = $("#operForm");
      
      $("button[data-oper='list']").on("click", function(e) {

         operForm.find("#mno").remove();
         operForm.attr("action", "/menu/list")
         operForm.submit();
         
      });
      
      // 리뷰 기능 처리
      //console.log(replyService);
      var mnoValue = '<c:out value="${menuInfo.mno}"/>';
      var replyUL = $(".chat");
      
      // 1페이지 출력
      showList(1);
      
      // 리뷰 목록 출력
      function showList(page) {
         
         console.log("show list " + page);
         
         replyService.getList({mno:mnoValue, page:page||1}, function(replyCnt, list) {
            
            console.log("replyCnt : " + replyCnt);
            console.log("list : " + list);
            console.log(list);
            
            // 사용자가 새로운 리뷰를 추가하면 showList(-1)을 호출하여
            // 우선 전체 리뷰의 숫자를 파악하고 마지막 페이지를 호출해서 이동시키는 동작
            if (page == -1) {
               
               // 리뷰를 10개씩 처리할때, Controller 에서 숫자 변경 시 변경 필요
               pageNum = Math.ceil(replyCnt / 10.0);
               showList(pageNum);
               return;
               
            }
            
            var str = "";
            if (list == null || list.length == 0) {
               
               //replyUL.html("");
               
               return;
               
            }
            
            for (var i = 0, len = list.length || 0; i < len; i++) {
               
               str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";
               str += "   <div><div class='header'><strong class='primary-font'>[" + list[i].rno + "] " + list[i].replyer + "</strong>";
               str += "   <small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) + "</small></div>";
               str += "   <p>" + list[i].reply + "</p></div></li>";
               
            }
            
            replyUL.html(str);
            
            showReplyPage(replyCnt);
            
         });
         
      }
      
      // 리뷰 Modal 처리
      var modal = $(".modal");
      var modalInputReply = modal.find("input[name=reply]");
      var modalInputReplyer = modal.find("input[name=replyer]");
      var modalInputReplyDate = modal.find("input[name=replyDate]");
      var modalInputStar = modal.find("input[name=star]");
      
      var modalModBtn = $("#modalModBtn");
      var modalRemoveBtn = $("#modalRemoveBtn");
      var modalRegisterBtn = $("#modalRegisterBtn");
      var modalCloseBtn = $("#modalCloseBtn");
      
      // 별점 기능 처리
      //var starNum = 0;
      
      $("#addReplyBtn").on("click", function(e) {
         
         modal.find("input").val("");
         modalInputReplyDate.closest("div").hide();
         modalInputStar.hide();
         modal.find("button[id !='modalCloseBtn']").hide();
         
         modalRegisterBtn.show();
         
         // 별 출력
         var str = "";
         
         for (var i = 1; i <= 5; i++) {
            
            str += '<i class="fa fa-star fa-fw"></i>'
            
         }
         
         // 화면에 별 출력
         $(".make_star").html(str);
         
         //$(".modal").modal("show");
         modal.modal("show");
         
      });
      
      modalRegisterBtn.on("click", function(e) {
         
         if (!modalInputReply.val()) {
            
            alert("리뷰를 입력하세요");
            return false;
            
         }
         
         if (!modalInputStar.val()) {
            
            alert("별점을 입력하세요");
            return false;
            
         }
         
         var reply = {
               reply: modalInputReply.val(),
               replyer: modalInputReplyer.val(),
               mno: mnoValue,
               star: modalInputStar.val()
         };
         
         replyService.add(reply, function(result) {
            
            alert(result);
            
            modal.find("input").val("");
            modal.modal("hide");
            
            // 1페이지 출력
            //showList(1);
            showList(-1);
         });
         
      });
      
      $(".chat").on("click", "li", function(e) {
         
         var rno = $(this).data("rno");
         
         replyService.get(rno, function(reply) {
            
            modalInputReply.val(reply.reply);
            modalInputReplyer.val(reply.replyer);
            modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly", "readonly");
            modalInputReplyDate.closest("div").show();
            modal.data("rno", reply.rno);
            
            modalInputStar.hide();
            modal.find("button[id != 'modalCloseBtn']").hide();
            modalModBtn.show();
            modalRemoveBtn.show();
            
            // 글자 수를 입력된 리뷰에 맞게 표시
            var totalByte = 0;
            var replyText = modalInputReply.val();
            
            for(var i =0; i < replyText.length; i++) {
               var currentByte = replyText.charCodeAt(i);
               if(currentByte > 128) 
                  totalByte += 1;
               else totalByte++;
            }
            
            // 현재 입력한 문자의 바이트 수를 체크하여 표시
            $('#modalMessagebyte').text(totalByte);
            
            // 색 있는 별 출력 개수
            var str = "";
            
            // 색 있는 별 출력
            for (var i = 1; i <= reply.star; i++) {
               
               str += '<i class="fa fa-star fa-fw" style="color: rgb(255, 0, 0);"></i>';
               
            }
            
            // 색 없는 별 출력
            for (var i = reply.star + 1; i <= 5; i++) {
               
               str += '<i class="fa fa-star fa-fw"></i>';
               
            }
            
            // 화면에 별 출력
            $(".make_star").html(str);
            
            $(".modal").modal("show");
            
         });
         
      });
      
      modalModBtn.on("click", function(e) {
         
         if (!modalInputReply.val()) {
            
            alert("리뷰를 입력하세요");
            return false;
            
         }
         
         var reply = {rno:modal.data("rno"), reply:modalInputReply.val(), star: modalInputStar.val()};
         
         replyService.update(reply, function(result) {
            
            alert(result);
            modal.modal("hide");
            showList(pageNum);
            
         });
         
      });
      
      modalRemoveBtn.on("click", function(e) {
         
         var rno = modal.data("rno");
         
         replyService.remove(rno, function(result) {
            
            alert(result);
            modal.modal("hide");
            showList(pageNum);
            
         });
         
      });
      
      modalCloseBtn.on("click", function(e) {
         
         modal.modal("hide");
         //showList(1);
         
      });
      
      // 리뷰 페이지 번호 출력
      var pageNum = 1;
      var replyPageFooter = $(".replyPageFooter");
      
      function showReplyPage(replyCnt) {
         
         var endNum = Math.ceil(pageNum / 10.0) * 10;
         var startNum = endNum - 9;
         
         var prev = startNum != 1;
         var next = false;
         
         if (endNum * 10 >= replyCnt) {
            
            endNum = Math.ceil(replyCnt / 10.0);
            
         }
         
         if (endNum * 10 < replyCnt) {
            
            next = true;
            
         }
         
         var str = "<ul class='pagination pull-right'>";
         
         if (prev) {
            
            str += "<li class='page-item'><a class='page-link' href='" + (startNum - 1) + "'>Previous</a></li>";
            
         }
         
         for (var i = startNum; i <= endNum; i++) {
            
            var active = pageNum == i ? "active" : "";
            
            str += "<li class='page-item " + active + "'><a class='page-link' href='" + i + "'>" + i + "</a></li>";
            
         }
         
         if (next) {
            
            str += "<li class='page-item'><a class='page-link' href='" + (endNum + 1) + "'>Next</a></li>";
            
         }
         
         str += "</ul></div>";
         
         console.log(str);
         
         replyPageFooter.html(str);
         
      }
      
      // 페이지의 번호를 클릭했을 때 새로운 리뷰를 가져오게 함
      replyPageFooter.on("click", "li a", function(e) {
         
         // 현재 페이지와 같은 페이지를 누를 경우
         //if (pageNum == $(this).attr("href") ) {
            
         //   console.log("같은 페이지");
         //   return false;
            
         //}
                  
         e.preventDefault();
         console.log("page click");
         
         var targetPageNum = $(this).attr("href");
         
         console.log("targetPageNum : " + targetPageNum);
         
         pageNum = targetPageNum;
         
         showList(pageNum);
         
      });
      
      
      // 별을 누르면 별점을 알려주는 함수
      $(".make_star").on("click", "i", function(e) {             
         
	     var targetNum = $(this).index() + 1;
	     
	     console.log(targetNum);
	     
	     $('.make_star i').css({color: '#000'});
	     $('.make_star i:nth-child(-n+' + targetNum + ')').css({color: '#F00'});
	     
	     modalInputStar.val(targetNum);
         
      });
      
      // Modal의 TextArea 글자수 검사
      modalInputReply.keyup(function() {
         var totalByte = 0;
         var replyText = modalInputReply.val();
         
         for(var i =0; i < replyText.length; i++) {
            var currentByte = replyText.charCodeAt(i);
            if(currentByte > 128) 
               totalByte += 1;
            else totalByte++;
         }
         
         // 현재 입력한 문자의 바이트 수를 체크하여 표시
         $('#modalMessagebyte').text(totalByte);          
       });

   });
    </script>

</body>

</html>