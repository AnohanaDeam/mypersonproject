$(function(){
	$('.data-img').click(function(){
		var img = this.getAttribute('src'); 
		$('.pic_show img').attr('src',img);
		$('.pic_looper').fadeIn(500), $('.pic_show').fadeIn(500); }); 
		$('.gb').click(function(){
			$('.pic_looper').fadeOut(300); 
			$('.pic_show').fadeOut(300); 
		}); 
})
document.write(
	"<style>"+
		".data-img{cursor:pointer} "+
		".pic_looper{"+
			"width:100%; "+
			"height:100%; "+
			"position: fixed; "+
			"left: 0; "+
			"top:0; "+
			"opacity: 0.5; "+
			"background: #000; "+
			"display: none; "+
			"z-index: 12; "+
		"} "+
		".pic_show{"+
			"width:100%; "+
			"max-width: 1020px; "+
			"height:520px; "+
			"position:absolute; "+
			"left:0; "+
			"top:0; "+
			"right:0; "+
			"bottom:0; "+
			"margin:auto; "+
			"text-align: center; "+
			"display: none; "+
			"z-index: 13; "+
		"} "+
		".pic_box{"+
			"width:90%; "+
			"height:450px; "+
			"margin:40px auto; "+
			"text-align: center; "+
			"overflow: hidden; "+
		"} "+
		".pic_box img{"+
			"height:100%; "+
		"} "+
		".pic_close{"+
			"width:100%; "+
			"height:16px; "+
			"float: right; "+
		"} "+
		".pic_close span{"+
			"display: block; "+
			"width:16px; "+
			"height:16px; "+
			"float: right; "+
			"margin:2px 5px; "+
			"text-align: center; "+
			"line-height: 16px; "+
			"cursor: pointer; "+
			"color:#fff; "+
			"font-size: 22px; "+
		"} "+
	"</style>"+
	"<div class='pic_looper'></div> "+
	"<div class='pic_show'> "+
		"<p class='pic_close'><span class='gb' title='关闭'>x</span></p> "+
		"<div class='pic_box'><img src=''/></div> "+
	"</div>")
