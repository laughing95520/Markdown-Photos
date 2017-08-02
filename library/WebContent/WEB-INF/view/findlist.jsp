<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 为了使用jstl.jar这个工具 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
         #special{
        	color: white;
        	font-size: 20px;
        	margin-top: 10px;
        	margin-left: 40%;
        }
        table td form{
        	display:inline;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
   <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                 
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${sessionScope.userbean.name}
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="signuppage.action">注销</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href=""><span class="first">图书信息</span> <span class="second">管理</span></a>
                <p id="special">made by laughing 04142131</p>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-dashboard"></i>Welcome</a>
        <ul id="dashboard-menu" class="nav nav-list collapse" style="height : 0px;">
            <li><a href="homepage.action">主页</a></li>
        </ul>
        
        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="signuppage.action">登录</a></li>
            <li ><a href="registepage.action">注册</a></li>
        </ul>

        <a href="#reader-menu" class="nav-header" data-toggle="collapse"><i class="icon-comment"></i>读者</a>
        <ul id="reader-menu" class="nav nav-list collapse" style="height:0px;">
        	<li ><a href="readerlist.behavior">读者信息</a></li>
            <li ><a href="userpage.action">读者管理</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>图书信息</a>
        <ul id="legal-menu" class="nav nav-list in collapse">
            <li ><a href="findpage.action">查找</a></li>
            <li ><a href="save_book_page.bookdo">增加</a></li>
        </ul>
    </div>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Find Book</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="homepage.action">Home</a> <span class="divider">/</span></li>
            <li class="active">Find</li>
        </ul>
 
        <div class="container-fluid">
            <div class="row-fluid">
      	
			<div class="btn-toolbar">
   
			</div>
		
						<table align="center" width="650" >
								<tr >
									<td align="center" colspan="6">
									<h2>所有图书信息</h2>
									</td>
								</tr>
								<tr >
									<td><b>编号</b></td>
									<td><b>图书名称</b></td>
									<td><b>价格</b></td>
									<td><b>数量</b></td>
									<td><b>作者</b></td>
									<td><b>出版社</b></td>
								</tr>
								<c:forEach var="booklist" items="${rslist}">
								<tr>
									<td>${booklist.serialnum}</td>
									<td>${booklist.name}</td>
									<td>${booklist.price}</td>
									<td>${booklist.bookCount}</td>
									<td>${booklist.author}</td>
									<td>${booklist.press}</td>
									<td>
						<form id="${booklist.id}" action="updatepage.bookdo" method='post'>  
				  <input type='hidden' name='id' value="${booklist.id}"/>  
	             <a onclick="document.getElementById('${booklist.id}').submit()"><i class="icon-pencil"></i></a>
	          			</form>
	          			<form id="${booklist.id}+${booklist.author}" action="delete.bookdo" method='post'>  
				  <input type='hidden' name='id' value="${booklist.id}"/>  
	              <a onclick="document.getElementById('${booklist.id}+${booklist.author}').submit()"  role="button" data-toggle="modal"><i class="icon-remove"></i></a>
	          			</form>
	          			</td>
								</tr>
								</c:forEach>
							</table>
             		<footer>
                        <hr>
                       <p class="pull-right">&copy; 2016 <a href="#" target="_blank">By laughing</a></p>
                    </footer>
          
            </div>
        </div>
    </div>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
    </script>
    
  </body>
</html>





