<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<header>
  <div class="headerstrip">
    <div class="container">
      <div class="row">
        <div class="span12">
          <a href="index-2.html" class="logo pull-left"><img src="img/xcf_logo_106x35.png" alt="SimpleOne" title="SimpleOne"></a>
          <!-- Top Nav Start -->
          <div class="pull-left">
            <div class="navbar" id="topnav">
              <div class="navbar-inner">
                <ul class="nav">
                  <li><a class="home active" href="${pageContext.request.contextPath}/index">首页</a>
                  </li>
                  <li><a class="myaccount" href="#">菜谱分类</a>
                  </li>
                  <li><a class="checkout" href="${pageContext.request.contextPath}/center">个人中心</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="pull-right">
            <form class="form-search top-search" action="search" method="post">
              <input type="text" name='key' class="input-medium search-query" placeholder="搜索菜谱">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</header>