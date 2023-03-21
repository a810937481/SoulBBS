
    let url=window.location.search; //获取url中"?"符后的字串
    let PostId;
    console.log(url);
    if(url.indexOf("?")!=-1){
        let id = url.substr(url.indexOf("=")+1);
        PostId = url.split('=');
        console.log(PostId[1]);
    };
