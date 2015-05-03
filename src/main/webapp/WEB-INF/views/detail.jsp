<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html><html lang="en"><head>
<meta charset="utf-8">
<title>SimpleOne - A Responsive Html5 Ecommerce Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/font.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/flexslider.css" type="text/css" media="screen" rel="stylesheet">
<link href="css/jquery.fancybox.css" rel="stylesheet">
<link href="css/cloud-zoom.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<!-- fav -->
<link rel="shortcut icon" href="assets/ico/favicon.html">
</head>
<body>
<!-- Header Start -->
<%@include file="./head.jsp" %>
<!-- Header End -->

<div id="maincontainer">
  <section id="product">
    <div class="container">
      <div class="row">        
     <div class="span12">
         <!-- Blog start-->   
          <section id="latestblog">         
            <div class="blogdetail">
              <h2 class="heading2"><span>${cookBook.name }</span></h2>
              <hr>
              <ul class="margin-none">
                <li class="listblcok" style="border-bottom:none;">
                  <div class="mb20">
                    <a class="fancyboxpopup thumbnail" href="${pageContext.request.contextPath}/upload/${cookBook.imgPath}"><img src="${pageContext.request.contextPath}/upload/${cookBook.imgPath}" alt=""></a>
                  </div>
                </li>
              </ul>
              <section class="leavecomment">
                	<h2 class='heading2' >简介</h2>
                	<hr>
                	<p>
                		${cookBook.remark }
                	</p>
                	<h2 class='heading2' >用料</h2>
                	<hr>
									<table class='table table-bordered '>

										<tbody>
										<c:forEach items="${cookBook.cookFoods }" var="bean">
											<tr>
												<td class="name has-border">${bean.name }</td>
												<td class="unit has-border">${bean.number }</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
									<h2 class='heading2' >做法</h2>
                					<hr>
                					<ul>
	                					<c:forEach items="${cookBook.cookSteps }" var="bean" varStatus="status">
		                					 <li >
								              <h3 >第${status.index +1}步：${bean.name }</h3>
								              <img src="${pageContext.request.contextPath}/upload/${bean.imgPath}" alt="葡式蛋挞的做法 步骤1" width="200">
								            </li>
	                					</c:forEach>
          							</ul>
								</section>
            </div>
          </section>
        </div>
      
       </div>
    </div>
  </section>
</div>
<%@include file="./foot.jsp" %>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/respond.min.js"></script>
<script src="js/application.js"></script>
<script src="js/bootstrap-tooltip.js"></script>
<script defer="" src="js/jquery.fancybox.js"></script>
<script defer="" src="js/jquery.flexslider.js"></script>
<script type="text/javascript" src="js/jquery.tweet.js"></script>
<script src="js/cloud-zoom.1.0.2.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.carouFredSel-6.1.0-packed.js"></script>
<script type="text/javascript" src="js/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="js/jquery.touchSwipe.min.js"></script>
<script type="text/javascript" src="js/jquery.ba-throttle-debounce.min.js"></script>
<script defer="" src="js/custom.js"></script>

</body></html>