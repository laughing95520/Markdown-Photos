
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  
  <!-- 网页左上角的图标 -->	<link rel = "icon" href="">
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
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>Welcome</a>
        <ul id="dashboard-menu" class="nav nav-list in collapse">
            <li><a href="homepage.action">主页</a></li>
        </ul>
        
        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="signuppage.action">登录</a></li>
            <li ><a href="registepage.action">注册</a></li>
        </ul>

        <a href="#reader-menu" class="nav-header" data-toggle="collapse"><i class="icon-comment"></i>读者</a>
        <ul id="reader-menu" class="nav nav-list collapse">
        	<li ><a href="readerlist.behavior">读者信息</a></li>
            <li ><a href="userpage.action">读者管理</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>图书信息</a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="findpage.action">查找</a></li>
            <li ><a href="save_book_page.bookdo">增加</a></li>
        </ul>
    </div>
    

    
    <div class="content">
        
        <div class="header">
            <div class="stats">
						</div>
            <h1 class="page-title">Welcome</h1>
        </div>
                <ul class="breadcrumb">
            <li><a href="homepage.action">Home</a> <span class="divider">/</span></li>
            <li class="active">Welcome</li>
        </ul>

       <!-- <div class="container-fluid">
            <div class="row-fluid">
                    -->

<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>First Blood:</strong> Hope you like it!---By laughing 04142131
    </div>

    <div class="block">
        <a href="#page-stats" class="block-heading" data-toggle="collapse">Books Information</a>
        <div id="page-stats" class="block-body collapse in">

            <div class="stat-widget-container">
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">文学</p>
                        <p class="detail">民间文学|外国随笔</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">时尚娱乐</p>
                        <p class="detail"> 服装/饰品|游戏/棋牌</p>
                    </div>
                </div>

                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">传记</p>
                        <p class="detail">领袖/政治人物|历史人物</p>
                    </div>
                </div>
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">外语</p>
                        <p class="detail">英语词汇 | 英语语法 | 英语听力</p>
                    </div>
                </div>
				
				<div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">计算机</p>
                        <p class="detail">计算机理论 | 硬件/外部设备 | 操作系统 | 程序设计</p>
                    </div>
                </div>
                
                <div class="stat-widget">
                    <div class="stat-button">
                        <p class="title">医学</p>
                        <p class="detail">基础医学 | 医药卫生教材 | 预防医学/卫生学 </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">Introduce<span class="label label-warning"></span></a>
        <div id="tablewidget" class="block-body collapse in">
		<h2>Reading</h2>
		 <span><p>I think reading is important in the whole life for people. There are many benefits of reading. 
		 Firstly, reading increases our knowledge and we can learn the world affairs without going out. 
		 Secondly, reading is a good way to improve reading and writing skills. Before you learn to write, 
		 you must know how others write. Thirdly, reading can broaden our knowledge and horizon, which is 
		 important to job hunting in the future. Finally, reading helps us become self-cultivation that 
		 would be beneficial to our whole life. Therefore, start to reading, no matter how old you are and
		 what you are doing. Then, you may find the great charm and benefits of reading.
		 </p></span>
		</div>
		    </div>
    <div class="block span6">
        <a href="#widget1container" class="block-heading" data-toggle="collapse">Picture</a>
        <div id="widget1container" class="block-body collapse in">
        <img src="img/home.jpg" />
        </div>
    </div>
</div>
                    <footer>
                        <hr>
                        <p class="pull-right">&copy; 2016 <a href="#" target="_blank">By laughing</a></p>
                    </footer>
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