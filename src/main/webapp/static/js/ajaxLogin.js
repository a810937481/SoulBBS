$(function (){
    let userName = $.cookie("userName");
    //检测是否登录，如果没有登录则跳回登录界面
    if ($.cookie("userName")!=null){
        $("#welcome").html("");
        let welcome =
            "<li class=\"dropdown\">" +
            "<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">你好，"+$.cookie("userName")+" <span class=\"caret\"></span></a>" +
            "<ul class=\"dropdown-menu\">" +
            "<li><a href=\"userCenter.html\">个人中心</a></li>" +
            "<li><a id=\"moveCookie\" href=\"#\">退出登录</a></li>"+
            "</ul>" +
            "</li>"
        $("#welcome").append(welcome);
    } else{
        alert("未登录或登录信息过期，请重新登录哦");
        window.location.href="userLogin.html";
    }
    //退出登录
    $("#moveCookie").click(function (){
        $.removeCookie('userUid');
        $.removeCookie('userName');
        $.removeCookie('userId');
        $.removeCookie('userState');
        window.location.href="userLogin.html";
    })

    let userState = $.cookie("userState");
    if (userState == 0){
        alert("您已被封禁，请联系管理员解封");
        window.location.href="userLogin.html";
    }
})