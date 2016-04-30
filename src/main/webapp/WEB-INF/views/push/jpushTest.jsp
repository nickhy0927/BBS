<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>极光推送测试</title>
		<style type="text/css">
			.contaner {
				width: 100%;
				background-color: #f2f2f2;
			}
			.contaner .title {
				text-align: center;
				height: 50px;
				line-height: 50px;
				border-bottom: 1px solid red; 
			}
			
			.contaner form {
				margin: 0 auto;
				text-align: center;
			}
			.contaner form label {
				width: 130px;
				text-align:left;
				display: inline-block;
				height: 50px;
				line-height: 50px;
			}
			.contaner form input {
				width: 400px;
				height:25px;
				border-radius: 5px;
				line-height:25px;
				display: inline-block;
				padding:4px 10px;
			    border: 0;
			    font-size: 14px;
				box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
			    -moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
			    -webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;    
			}
			
			textarea {
				margin-top:10px;
			    padding: 4px;
			    border: solid 1px #E5E5E5;
			    outline: 0;
			    font: normal 13px/100% Verdana, Tahoma, sans-serif;
			    width: 400px;
			    background: #FFFFFF;
			    box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
			    -moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
			    -webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;    
			}
			
		</style>
	</head>
	<body>
		<div class="contaner">
			<div class="title">${title}</div>
			<form action="${ctx}/outLink/send" method="post">
				<div style="border-bottom: 1px solid blue;">
					<label>tag</label>
					<input name="tag" type="text" id="tag"/>
				</div>
				<div style="border-bottom: 1px solid blue;">
					<label>消息标题</label>
					<input name="msgTitle" type="text" id="msgTitle"/>
				</div>
				<div style="border-bottom: 1px solid blue;">
					<label style="margin-top: 0px;top: 0px;">消息内容</label>
					<textarea style="height: 50px;" id="msgContent" name="msgContent"></textarea>
				</div>
				<div style="border-bottom: 1px solid blue;">
					<input type="submit" value="推送">
				</div>
			</form>
		</div>
	</body>
</html>