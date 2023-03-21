$(function (){
    //检测是否登录，如果没有登录则跳回登录界面
    if ($.cookie("adminName")!=null){
        $("#AdminName").html("");
        let welcome = "<i class=\"fa fa-user\"></i> "+ $.cookie("adminName") +" <b class=\"caret\"></b>";
        $("#AdminName").append(welcome);
    } else{
        alert("未登录或登录信息过期，请重新登录哦");
        window.location.href="admin.html";
    }
    //退出登录
    $("#moveCookie").click(function (){
        $.removeCookie('adminId');
        $.removeCookie('adminUid');
        $.removeCookie('adminName');
        $.removeCookie('rightsNotice');
        $.removeCookie('rightsPost');
        $.removeCookie('rightsUser');
        $.removeCookie('rightsBest');
        window.location.href="admin.html";
    })
})