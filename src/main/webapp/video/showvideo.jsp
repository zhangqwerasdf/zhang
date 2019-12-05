<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!--<base href="http://localhost:8080/Voids/">--><base href=".">
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>智游教育</title>
		
<link href="http://localhost:8080/SSMVideo/js/bootstrap.css" rel="stylesheet">

<script src="http://localhost:8080/SSMVideo/js/jquery-1.js"></script>
<script src="http://localhost:8080/SSMVideo/js/bootstrap.js"></script>
<script src="http://localhost:8080/SSMVideo/js/confirm.js"></script>
<script src="http://localhost:8080/SSMVideo/js/jquery.js"></script>
<script src="http://localhost:8080/SSMVideo/js/message_cn.js"></script>

		<style type="text/css">
		th {
			text-align: center;
		}
		</style>
	</head>

	<body>
<nav class="navbar-inverse">
	<div class="container">
		
		<div class="navbar-header">
			<a class="navbar-brand">视频管理系统</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
			<ul class="nav navbar-nav">
				<li class="active"><a>视频管理</a></li>
				<li><a>主讲人管理</a></li>
				<li><a>课程管理</a></li>
			</ul>
			<p class="navbar-text navbar-right">
				<span>admin</span> <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a  class="navbar-link">退出</a>
			</p>
		</div>
	</div>
</nav>


    <div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
	  <div class="container">
	          <h2>课程管理</h2>
	  </div>
	</div>
	
	<form action="videoshow">
	<div class="container">
	    <button onclick="showAddPage()" type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      添加
		</button>
		
		<button onclick="deleteAll()" type="submit" id="btn" class="btn btn-info dropdown-toggle">
		      批量删除
		</button>
	</div>
	
	<div class="container" style="margin-top: 20px;">
		
		<table class="table table-bordered table-hover" style="text-align: center;table-layout:fixed;">
      <thead>
        <tr class="active">
          <th><input type="checkbox" id="all"></th>
          <th>序号</th>
          <th style="width:8%">名称</th>
          <th style="width:50%">介绍</th>
          <th style="width:8%">讲师</th>
          <th style="width:8%">时长</th>
          <th style="width:8%">播放次数</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>

        
         <c:if test="${list.size()>0}">
        <c:forEach begin="0" end="${list.size()-1}" var="i">
            <tr>
              <td><input type="checkbox"></td>
		      <td>${list[i].id}</td>
		      <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis">${list[i].title}</td>
		      <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis">${list[i].detail}</td>
		      <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis">${list[i].speaker_id}</td>
		      <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis">${list[i].time}</td>
		      <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis">${list[i].playnum}</td>
		      <td><a href="">✎</a></td>
		      <td><a href="">X</a></td>
            </tr>
         
        </c:forEach>
        </c:if>
        </tbody>
      </table> 
        <td colspan="2">
        <font>总共6条,当前第1页</font>
		<a href=""> 1</a>&gt;
		<a href="">2</a>&gt;
        </td></tr>
	</div>
	  </form>
	<script type="text/javascript">
		function showAddPage(){
			location.href="Course/addCourse.do";
		}
		function delCourseById(Obj,id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("admin/course/delCourse.action",param,function(data){
							if(data=='success'){
								Confirm.show('温馨提示：', '删除成功');
								$(Obj).parent().parent().remove();
							}else{
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
	</script>
<div id="modal-background" class=""></div><div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1"><div class="modal-dialog modal-undefined"><div class="modal-content"><div class="modal-header"><button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button><h4 id="modal-title" class="modal-title">Modal Title</h4></div><div id="modal-body" class="modal-body"> Modal Message </div><div id="modal-footer" class="modal-footer"></div></div></div></div><div id="modal-background" class=""></div></body></html>