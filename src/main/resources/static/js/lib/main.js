// login
var touchtime = new Date().getTime();
$("[name='switch-status-more']").on("click", function(){      //快捷入口
  if( new Date().getTime() - touchtime < 150 ){     //防止无聊人士快速双击
      setTimeout(function(){$(".switch-status").removeClass("show");}, 151);
      setTimeout(function(){$("[name='switch-status-more']").removeClass("open");}, 151);
  }else{
    touchtime = new Date().getTime();
    if($(".switch-status").hasClass("show")){
      $(".switch-status").removeClass("show");
      $("[name='switch-status-more']").removeClass("open");
    }
    else{
      setTimeout(function(){$("[name='switch-status-more']").addClass("open");}, 10);
      setTimeout(function(){$("#login_btn").addClass("show");}, 0);
      setTimeout(function(){$("#register_btn").addClass("show");}, 50);
      setTimeout(function(){$("#forget_btn").addClass("show");}, 150);
    }
    $(".wx-scopy").on("click", function(){
      $(".switch-status").removeClass("show");
      $("[name='switch-status-more']").removeClass("open");
    })
  }
});

$(document).on("click", "#login_btn, #register_btn", function(){    //登录、注册或忘记密码按钮  #forget_btn
  var mark = $(this).next(".switch_mark");
  mark.addClass("is-active");    //全屏涟漪
  $(".login_loading").removeClass("low");     //改变loading动效层级  上一层
  $(".wx-scopy").addClass("anti-overflow");      //涟漪不超出body
  setTimeout(function(){$(".login_loading").addClass("is-active");}, 200);    //加载loading
  setTimeout(function(){
    mark.addClass("remove");        //删掉蒙板和loading
    $(".login_loading").removeClass("is-active");
  }, 2000);
  setTimeout(function(){
    mark.removeClass("is-active remove");
    $(".login_loading").addClass("low");
    $(".wx-scopy").removeClass("anti-overflow");
  }, 3000);
})

$(document).on("click", "#login_btn, #register_btn, #forget_btn", function(){   //切换登录、注册、忘记密码
  $(".switch-status").removeAttr("disabled");
  $(".switch-status").addClass("mdl-button--colored");
  $(this).attr("disabled","true");
  $(this).removeClass("mdl-color--accent");
})

$(document).on("click", "#login_btn", function(){   //切换成登录
  setTimeout(function(){
    $("[name='login_form']").show(300);
    $("[name='register_form']").hide(300);
  }, 200);
})

$(document).on("click", "#register_btn", function(){   //切换成注册
  setTimeout(function(){
    $("[name='register_form']").show(300);
    $("[name='login_form']").hide(300);
  }, 200);
})

$(document).on("click", "#setpw i", function(){   //注册时查看密码
  $(this).toggleClass("open");
  if ($("[name='setpw']").attr("type") == "password") {$("[name='setpw']").attr("type", "text")}
  else {$("[name='setpw']").attr("type", "password")}
})

$(".mdl-layout__content").scroll(function(){    //向下滚收起首页一部分头部
// 滚动条距离顶部的距离 小于 8px时
  if($(this).scrollTop() < 8){
    $(".mdl-header-bar, .mdl-layout__header-bg, .mdl-layout__tab-bar, .mdl-layout__tab-bar-button").removeClass("hide");    //展开来
  }
  else{
    $(".mdl-header-bar, .mdl-layout__header-bg, .mdl-layout__tab-bar, .mdl-layout__tab-bar-button").addClass("hide");   //收起来
  }
});

// 中间内容的高度若是小于887并且大于544时，直接赋值为887
var mainh_content = $(".page-content").height()
if( mainh_content > 544 && mainh_content < 887 ){
    $(".page-content").css("height", "887px");
}