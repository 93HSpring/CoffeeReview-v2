<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Coffee Review</a>
            </div>
            <!-- /.navbar-header -->

			<!-- navbar-top-links -->

            <ul class="nav navbar-top-links navbar-right">
				
				
				<sec:authorize access="isAnonymous()">
					<h1>
						<a href="/customLogin">로그인하세요</a> <a href="/member/register">회원가입</a>
					</h1>

				
				</sec:authorize>
				
            	<sec:authorize access="isAuthenticated()">
					<li class="dropdown">
	                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
	                    </a>
	                    <ul class="dropdown-menu dropdown-user">
	                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
	                        </li>
	                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
	                        </li>
	                        <li class="divider"></li>
	                        <li><a href="/customLogout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
	                        </li>
	                    </ul>
	                    <!-- /.dropdown-user -->
	                </li>
	                <!-- /.dropdown -->
            	
            	</sec:authorize>
				
				

            
                
            </ul>
            <!-- /.navbar-top-links -->



            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                        	<!-- 검색 처리 -->
	            			<form id='searchForm' action="/menu/list" method='get'>
	            				<select name='cafe' class="form-control">
	            					<option value="" <c:out value="${cri.cafe == null ? 'selected' : ''}" />>--</option>
            						<option value="STARBUCKS" <c:out value="${cri.cafe == 'STARBUCKS' ? 'selected' : ''}" />>STARBUCKS</option>
            						<option value="COFFEEBEAN" <c:out value="${cri.cafe == 'COFFEEBEAN' ? 'selected' : ''}" />>COFFEEBEAN</option>
	            				</select>
                           	
                           		<!-- 검색 처리 끝 -->
	                            <div class="input-group custom-search-form">
	                                <input type="text" name='keyword' class="form-control form-input" placeholder="메뉴를 입력하세요..." value='<c:out value="${cri.keyword}" />' />
	                                <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}" />' />
	                                <!-- <input type='hidden' name='amount' value='<c:out value="${cri.amount}" />' /> -->
	                                <span class="input-group-btn">
		                                <button class="btn btn-default" type="button">
		                                    <i class="fa fa-search"></i>
		                                </button>
	                            	</span>
	                            </div>
                            </form>
                            <!-- /input-group -->
                        </li>                        
                        <li>
                            <a href="#"><i class="fa fa-coffee fa-fw"></i> Cafes<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <!-- <a href="/menu/list?cafe=STARBUCKS&pageNum=1&amount=12">STARBUCKS</a> -->
                                    <a href="/menu/list?cafe=STARBUCKS&pageNum=1">STARBUCKS</a>
                                </li>
                                <li>
                                    <!-- <a href="/menu/list?cafe=COFFEEBEAN&pageNum=1&amount=12">COFFEEBEAN</a> -->
                                    <a href="/menu/list?cafe=COFFEEBEAN&pageNum=1">COFFEEBEAN</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>