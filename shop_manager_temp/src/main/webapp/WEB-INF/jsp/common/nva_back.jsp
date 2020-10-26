<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 引入c标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a  class="navbar-brand " style="color: red" href="<c:url value="/article_manager/getAll.action"/>">网上书城-后台管理</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
        
        	<ul class="nav navbar-nav">
        		<li class="active"><a href="<c:url value="/article_manager/getAll.action"/>">商品管理</a></li>
	            <li><a href="<c:url value="/articleType_manager/getAll.action"/>">商品类型管理</a></li>
	            <li><a href="<c:url value="/order_manager/getAll.action"/>">订单管理</a></li>
          	</ul>
          	
             <ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${not empty session_user}">
						  	<li><a href="#"> <span style='color: red;'></span>
							</a></li>
							<li><a href="#">欢迎[<font color="red">${session_user.name}</font>]访问!</a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/logout">退出</a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/showRegisterPage">免费注册</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#"> <span style='color: red;'></span>
							</a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/showLoginPage">登录</a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/showRegisterPage">免费注册</a></li>
						</c:otherwise>
						
					</c:choose>
					<li><a href="${pageContext.request.contextPath}/article/index">访问官网</a></li>
					
			</ul>
        </div>

    </div>
</nav>
