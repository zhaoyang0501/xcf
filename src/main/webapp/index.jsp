<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html><html lang="en"><head>
<meta charset="utf-8">
<title>SimpleOne - A Responsive Html5 Ecommerce Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="http://fonts.useso.com/css?family=Open+Sans:400,300italic,400italic,600,600italic" rel="stylesheet" type="text/css">
<link href="http://fonts.useso.com/css?family=Crete+Round" rel="stylesheet" type="text/css">
<link href="http://fonts.useso.com/css?family=Crete+Round" rel="stylesheet" type="text/css"><link href="css/bootstrap.css" rel="stylesheet">
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
        <!-- Sidebar Start-->
        <aside class="span3">
          <!-- Category-->

          <h2 class="heading2"><span>菜谱分类</span></h2>
          <ul class="nav nav-list categories">
            <li> <a href="category.html">小吃</a> </li>
            <li> <a href="category.html">沙拉</a> </li>
            <li> <a href="category.html">零食</a> </li>
            <li> <a href="category.html">寿司</a> </li>
            <li> <a href="category.html">三明治</a> </li>
            <li> <a href="category.html">早餐</a> </li>
          </ul>
              <!--  Best Seller -->  
          
            <!-- Latest Product -->  
          
            <!--  Must have -->  
          
        </aside>
        <!-- Sidebar End-->
        <!-- Category-->

        <div class="span9"> 
		    
          <!-- Category Products-->
          <section id="category">
            <div class="row">
              <div class="span9">
			  <!--图片轮播-->
			  <div class="sidewidt">
				  <h2 class="heading2"><span>唯有美食与爱不可辜负</span></h2>
				  <div class="flexslider" id="testimonialsidebar">
					
				  <div class="flex-viewport" style="overflow: hidden; position: relative;"><ul class="slides" style="width: 1000%; -webkit-transition-duration: 0.6s; transition-duration: 0.6s; -webkit-transform: translate3d(-1740px, 0px, 0px);"><li class="clone" style="width: 870px; float: left; display: block;">
						" Lorem Ipsum is simply dummy text of the printing and  industry. Lorem  has been the industry's standard dummy text ever since the 1500s."<br>
						<span class="pull-right orange">By : Themeforest</span>
					  </li>
					  <li class="" style="width: 870px; float: left; display: block;">
						<a> <img src="img/product2a.jpg" style=" height:200px" height="100px" width="400px;" alt=""></a> 
						<span class="pull-right orange">By : Themeforest</span>
					  </li>
					  <li class="flex-active-slide" style="width: 870px; float: left; display: block;">
						" It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker   of Lorem Ipsum."<br>
						<span class="pull-right orange">By : Envato</span>
					  </li>
					  <li class="" style="width: 870px; float: left; display: block;">
						" Lorem Ipsum is simply dummy text of the printing and  industry. Lorem  has been the industry's standard dummy text ever since the 1500s."<br>
						<span class="pull-right orange">By : Themeforest</span>
					  </li>
					<li class="clone" style="width: 870px; float: left; display: block;">
						<a> <img src="img/exmple/2.jpg" style=" height:200px" height="100px" width="400px;" alt=""></a> 
						<span class="pull-right orange"> 上传：温家宝</span>
					  </li></ul></div><ol class="flex-control-nav flex-control-paging"><li><a class="">1</a></li><li><a class="flex-active">2</a></li><li><a class="">3</a></li></ol><ul class="flex-direction-nav"><li><a class="flex-prev" href="#">Previous</a></li><li><a class="flex-next" href="#">Next</a></li></ul></div>
				</div>

               <!-- Sorting-->

                <div class="row">
        <section id="featured" class="row mt40">
          <h1 class="heading1"><span class="maintext">最受欢迎</span></h1>
          <ul class="thumbnails">
            <li class="span3">
              <div class="thumbnail">
              <a href="img/product1.jpg" class="fancyboxpopup"><img alt="" src="img/exmple/1.jpg"><span class="viewfancypopup">&nbsp;</span><span class="viewfancypopup">&nbsp;</span></a>
              <div class="caption">
                <a href="#" class="bloggridtitle">干锅手撕包菜
                </a>               
                <div class="author">上传 : <a href="#"> 张博士</a>
                </div>
                <div>
                      
                      <span class="mr10"><i class="icon-calendar"></i> 2015-0101 </span>
                      <span class="mr10"><a href="#"><i class="icon-comment"></i> 评分：6.0</a> </span><br>
                      </div>
                     
                    </div>
              </div>
            </li>
           <li class="span3">
              <div class="thumbnail">
              <a href="img/product1.jpg" class="fancyboxpopup"><img alt="" src="img/exmple/1.jpg"><span class="viewfancypopup">&nbsp;</span><span class="viewfancypopup">&nbsp;</span></a>
              <div class="caption">
                <a href="#" class="bloggridtitle">干锅手撕包菜
                </a>               
                <div class="author">上传 : <a href="#"> 张博士</a>
                </div>
                <div>
                      
                      <span class="mr10"><i class="icon-calendar"></i> 2015-0101 </span>
                      <span class="mr10"><a href="#"><i class="icon-comment"></i> 评分：6.0</a> </span><br>
                      </div>
                     
                    </div>
              </div>
            </li>
            <li class="span3">
              <div class="thumbnail">
              <a href="img/product1.jpg" class="fancyboxpopup"><img alt="" src="img/exmple/1.jpg"><span class="viewfancypopup">&nbsp;</span><span class="viewfancypopup">&nbsp;</span></a>
              <div class="caption">
                <a href="#" class="bloggridtitle">干锅手撕包菜
                </a>               
                <div class="author">上传 : <a href="#"> 张博士</a>
                </div>
                <div>
                      
                      <span class="mr10"><i class="icon-calendar"></i> 2015-0101 </span>
                      <span class="mr10"><a href="#"><i class="icon-comment"></i> 评分：6.0</a> </span><br>
                      </div>
                     
                    </div>
              </div>
            </li>
            <li class="span3">
              <div class="thumbnail">
              <a href="img/product1.jpg" class="fancyboxpopup"><img alt="" src="img/product1a.jpg"><span class="viewfancypopup">&nbsp;</span><span class="viewfancypopup">&nbsp;</span></a>
              <div class="caption">
                <a href="#" class="bloggridtitle">干锅手撕包菜
                </a>               
                <div class="author">上传 : <a href="#"> 张博士</a>
                </div>
                <div>
                      
                      <span class="mr10"><i class="icon-calendar"></i> 2015-0101 </span>
                      <span class="mr10"><a href="#"><i class="icon-comment"></i> 评分：6.0</a> </span><br>
                      </div>
                     
                    </div>
              </div>
            </li>
            <li class="span3">
              <div class="thumbnail">
              <a href="img/product1.jpg" class="fancyboxpopup"><img alt="" src="img/exmple/1.jpg"><span class="viewfancypopup">&nbsp;</span><span class="viewfancypopup">&nbsp;</span></a>
              <div class="caption">
                <a href="#" class="bloggridtitle">干锅手撕包菜
                </a>               
                <div class="author">上传 : <a href="#"> 张博士</a>
                </div>
                <div>
                      
                      <span class="mr10"><i class="icon-calendar"></i> 2015-0101 </span>
                      <span class="mr10"><a href="#"><i class="icon-comment"></i> 评分：6.0</a> </span><br>
                      </div>
                     
                    </div>
              </div>
            </li>
          </ul>
        </section>
      </div>
       
              <div class="row">
        <section id="featured" class="row mt40">
          <h1 class="heading1"><span class="maintext">最新上传</span></h1>
          <ul class="thumbnails">
            <li class="span3">
              <a class="prdocutname" href="product.html">干锅手撕包菜</a>
              <div class="thumbnail">
                <a href="#"><img  alt="" src="img/exmple/1.jpg"></a>
                <div class="shortlinks" style="display: none;">
                  <a class="details" href="#">DETAILS</a>
                  <a class="wishlist" href="#">WISHLIST</a>
                  <a class="compare" href="#">COMPARE</a>
                </div>
              </div>
            </li>
           <li class="span3">
              <a class="prdocutname" href="product.html">干锅手撕包菜</a>
              <div class="thumbnail">
                <a href="#"><img  alt="" src="img/exmple/1.jpg"></a>
                <div class="shortlinks" style="display: none;">
                  <a class="details" href="#">DETAILS</a>
                  <a class="wishlist" href="#">WISHLIST</a>
                  <a class="compare" href="#">COMPARE</a>
                </div>
              </div>
            </li>
             <li class="span3">
              <a class="prdocutname" href="product.html">干锅手撕包菜</a>
              <div class="thumbnail">
                <a href="#"><img  alt="" src="img/exmple/1.jpg"></a>
                <div class="shortlinks" style="display: none;">
                  <a class="details" href="#">DETAILS</a>
                  <a class="wishlist" href="#">WISHLIST</a>
                  <a class="compare" href="#">COMPARE</a>
                </div>
              </div>
            </li>
             <li class="span3">
              <a class="prdocutname" href="product.html">干锅手撕包菜</a>
              <div class="thumbnail">
                <a href="#"><img  alt="" src="img/exmple/1.jpg"></a>
                <div class="shortlinks" style="display: none;">
                  <a class="details" href="#">DETAILS</a>
                  <a class="wishlist" href="#">WISHLIST</a>
                  <a class="compare" href="#">COMPARE</a>
                </div>
              </div>
            </li>
          </ul>
        </section>
      </div>         
                  <!-- Category-->

                
                
                
                
                
                
                
                
                
                
                
                
                
                                      
                
                
                
              </div>
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