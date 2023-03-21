function findpost(){
    let searchPostTitle = $("#searchpostTitle").val();
    let searchurl = "searchPost.html?postTitle="+searchPostTitle;
    window.location.href=searchurl;
}