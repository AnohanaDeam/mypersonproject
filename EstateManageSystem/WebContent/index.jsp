<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>房产管理系统</title>
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css">                
    <!-- Font Awesome -->
    <link rel="stylesheet" href="css/bootstrap.min.css">                                      
    <!-- Bootstrap style -->
    <link rel="stylesheet" href="css/hero-slider-style.css">                              
    <!-- Hero slider style (https://codyhouse.co/gem/hero-slider/) -->
    <link rel="stylesheet" href="css/magnific-popup.css">                                 
    <!-- Magnific popup style (http://dimsemenov.com/plugins/magnific-popup/) -->
    <link rel="stylesheet" href="css/templatemo-style.css">                                   
    <!-- Templatemo style -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
    <style type="text/css">
    	.grid-item{
    		opacity:0.9;
    	}
    </style>
</head>
    <body style="font-family: -webkit-body;">
        <!-- Content -->
        <div class="cd-hero">
            <!-- Navigation -->        
            <div class="cd-slider-nav">
                <nav class="navbar">
                    <div class="tm-navbar-bg">
                        <a class="navbar-brand text-uppercase" href="index.html"><i class="fa fa-flash tm-brand-icon"></i>房产管理系统</a>
                        <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                            &#9776;
                        </button>
                        <div class="collapse navbar-toggleable-md text-xs-center text-uppercase tm-navbar" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <li class="nav-item active selected">
                                    <a class="nav-link" href="#0" data-no="1">首页<span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="2">后台登陆</a>
                                </li>
                            </ul>
                        </div>                        
                    </div>
                </nav>
            </div> 

            <ul class="cd-hero-slider">
                <!-- Page 1 Home -->
                <li class="selected">
                    <div class="cd-full-width">
						<div class="container-fluid js-tm-page-content" data-page-no="2" data-page-type="gallery">
                            <div class="tm-img-gallery-container">
                                <div class="tm-img-gallery gallery-one">
                                <!-- Gallery One pop up connected with JS code below -->                                    
                                    <div class="tm-img-gallery-info-container">                                    
                                        <h2 class="tm-text-title tm-gallery-title tm-white"><span class="tm-white">选择你的业务</span></h2>
                                    </div>
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/1.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">商品房初始登记</h2>
                                                <p class="tm-figure-description">商品房在中国兴起于80年代，它是指经政府有关部门批准，由房地产开发经营公司开发的，建成后用于市场出售出租的房屋，包括住宅、商业用房以及其他建筑物。</p>
                                                <a href="table?f_service=D&service_number=M">开始业务</a>
                                            </figcaption>           
                                        </figure>
                                    </div>
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/2.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">经济适用房初始登记</h2>
                                                <p class="tm-figure-description">经济适用住房是指根据国家经济适用住房建设计划安排建设的住宅。</p>
                                                <a href="table?f_service=D&service_number=A">开始业务</a>
                                            </figcaption>
                                        </figure>
                                    </div>
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/3.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">城市房屋新建</h2>
                                                <p class="tm-figure-description">城市房屋新建，是指在城市规划区内国有土地上实施的房屋新建</p>
                                                <a href="table?f_service=D&service_number=U">开始业务</a>
                                            </figcaption>           
                                        </figure>
                                    </div>
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/4.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">集体入住房屋新建</h2>
                                                <p class="tm-figure-description">集体产权房屋修建在集体土地上，不能办理房屋土地使用证，不属于私产，不能上市交易。</p>
                                                <a href="table?f_service=D&service_number=C">开始业务</a>
                                            </figcaption>           
                                        </figure>
                                    </div>   
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/58.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">集资建房</h2>
                                                <p class="tm-figure-description">集资房是改变住房建设由国家和单位统包的制度，实行政府、单位、个人三方面共同承担，通过筹集资金，建造的房屋。</p>
                                                <a href="table?f_service=D&service_number=F">开始业务</a>
                                            </figcaption>           
                                        </figure>
                                    </div> 
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/6.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">抵押权登记</h2>
                                                <p class="tm-figure-description">抵押权登记是指抵押权人向法律规定的有关部门将其在特定物上所设定的抵押权的事项予以记载的事实。</p>
                                                <a href="table?f_service=M&service_number=A">开始业务</a>
                                            </figcaption>           
                                        </figure>
                                    </div> 
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/7.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">地役权登记</h2>
                                                <p class="tm-figure-description">地役权是指按照合同约定，利用他人的不动产，以提高自己的不动产的效益的权利。</p>
                                                <a href="table?f_service=E&service_number=A">开始业务</a>
                                            </figcaption>           
                                        </figure>
                                    </div> 
                                    <div class="grid-item">
                                        <figure class="effect-ruby">
                                            <img src="img/8.jpg" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                                <h2 class="tm-figure-title" style="background: #fff; color: #000; opacity:0.8">预告登记</h2>
                                                <p class="tm-figure-description">预告登记指当事人签订买卖房屋或者其他不动产物权的协议，为保障将来实现物权，而按照约定可以向登记机关申请预告登记。</p>
                                                <a href="table?f_service=T&service_number=A">开始业务</a>
                                            </figcaption>           
                                        </figure>
                                    </div>                                                                        
                                </div>                                 
                            </div>
                        </div> 
                    </div>
                </li>
                
                <!-- Page 2 Gallery One -->
                <li>                    
                    <div class="cd-full-width">
						<iframe src="login.jsp" style="width: 100%;height: 100%"></iframe>                                            
                    </div>                    
                </li>

                <!-- Page 3 Gallery Two -->
                <li>                    
                    <div class="cd-full-width">
                                             
                    </div>
                </li>

                <!-- Page 4 Gallery Three -->
                <li>
                    <div class="cd-full-width">
                                
                    </div>  
                </li>

                <!-- Page 5 About -->
                <li>
                    <div class="cd-full-width">
                                      
                    </div> <!-- .cd-full-width -->

                </li>

                <!-- Page 6 Contact Us -->
                <li>
                    <div class="cd-full-width">

                    </div> <!-- .cd-full-width -->
                </li>
            </ul> <!-- .cd-hero-slider -->
            
            <footer class="tm-footer">
            
            </footer>
                    
        </div> <!-- .cd-hero -->
        

        <!-- Preloader, https://ihatetomatoes.net/create-custom-preloading-screen/ -->
        <div id="loader-wrapper">
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>
        
        <!-- load JS files -->
        <script src="js/jquery-1.11.3.min.js"></script>         <!-- jQuery (https://jquery.com/download/) -->
        <script src="js/tether.min.js"></script> <!-- Tether for Bootstrap (http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h) --> 
        <script src="js/bootstrap.min.js"></script>             <!-- Bootstrap js (v4-alpha.getbootstrap.com/) -->
        <script src="js/hero-slider-main.js"></script>          <!-- Hero slider (https://codyhouse.co/gem/hero-slider/) -->
        <script src="js/jquery.magnific-popup.min.js"></script> <!-- Magnific popup (http://dimsemenov.com/plugins/magnific-popup/) -->
        
        <script>
            function adjustHeightOfPage(pageNo) {
                var offset = 80;
                var pageContentHeight = 0;
                var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

                if( pageType != undefined && pageType == "gallery") {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
                }
                else {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height();
                }

                if($(window).width() >= 992) { offset = 120; }
                else if($(window).width() < 480) { offset = 40; }
               
                // Get the page height
                var totalPageHeight = 15 + $('.cd-slider-nav').height()
                                        + pageContentHeight + offset
                                        + $('.tm-footer').height();

                // Adjust layout based on page height and window height
                if(totalPageHeight > $(window).height()) 
                {
                    $('.cd-hero-slider').addClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
                }
                else 
                {
                    $('.cd-hero-slider').removeClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
                }
            }

            /*
                Everything is loaded including images.
            */
            $(window).load(function(){

                adjustHeightOfPage(1); // Adjust page height

                /* Gallery One pop up
                -----------------------------------------*/
                /*$('.gallery-one').magnificPopup({
                    delegate: 'a', // child items selector, by clicking on it popup will open
                    type: 'image',
                    gallery:{enabled:true}                
                });*/
				
				/* Gallery Two pop up
                -----------------------------------------*/
				/*$('.gallery-two').magnificPopup({
                    delegate: 'a',
                    type: 'image',
                    gallery:{enabled:true}                
                });
*/
                /* Gallery Three pop up
                -----------------------------------------*/
                /*$('.gallery-three').magnificPopup({
                    delegate: 'a',
                    type: 'image',
                    gallery:{enabled:true}                
                });*/

                /* Collapse menu after click 
                -----------------------------------------*/
                $('#tmNavbar a').click(function(){
                    $('#tmNavbar').collapse('hide');

                    adjustHeightOfPage($(this).data("no")); // Adjust page height       
                });

                /* Browser resized 
                -----------------------------------------*/
                $( window ).resize(function() {
                    var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");
                    
                    // wait 3 seconds
                    setTimeout(function() {
                        adjustHeightOfPage( currentPageNo );
                    }, 1000);
                    
                });
        
                // Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
                $('body').addClass('loaded');
                           
            });
            /*//////////////////////////////////////*/
	    	function login1(){
	    		var username=document.getElementById("username").value;
	    		var isnull= /\S/;
	    		if(!isnull.test(username)){
	    			
	    				document.getElementById("user").innerHTML="不能为空";
	    			}
	    		else{
	    			document.getElementById("user").innerHTML="";
	    		}
	    	}
	    	function login2(){
	    		var password=document.getElementById("password").value;
	    		var isnull= /\S/;
	    		if(!isnull.test(password)){
	    			
	    				document.getElementById("pass").innerHTML="不能为空";
	    			}
	    		else{
	    			document.getElementById("pass").innerHTML="";
	    		}
	    	}
            /*//////////////////////////////////////*/
        </script>            
</body>
</html>