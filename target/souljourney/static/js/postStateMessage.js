$(function (){
    $.ajax({
        url:"/souljourney_war_exploded/getPostMessage?pmUserId="+$.cookie("userId"),
        type:"get",
        success:function (data){
            if (data != null){
                $.each(data , function (key,val){
                    let mes = val.finalMessage;
                    let nowpmid = val.pmId;
                    console.log(mes);
                    alert(mes);
                    $.ajax({
                        url:"/souljourney_war_exploded/deletePostMessage?pmId="+nowpmid,
                        type:"post",
                        success:function(data){
                            if (data){
                                console.log("删除成功");
                            }else {
                                console.log("删除失败");
                            }
                        }
                    })
                })
            }else {
                console.log("没有新消息");
            }
        }

    })
})