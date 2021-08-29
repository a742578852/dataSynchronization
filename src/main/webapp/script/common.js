//正则匹配url参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
};

//提示框
function msgbox(msg, time) {
    var msgbox = "#msgbox";
    msg ? msg : msg = '成功';
    time ? time : time = 1000;
    if ($(msgbox).length > 0) {
        return false;
    }
    var timer;
    var div = '<div id="msgbox">' + msg + '</div>'
    clearTimeout(timer);
    $('body').append(div);
    timer = setTimeout(function() {
        $(msgbox).fadeOut(300, function() {
            $(msgbox).remove();
        });
    }, time)
}

//msgbox(123);

//验证手机号
function checkPhone(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(str)) {
        return false;
    } else {
        return true;
    }
}

//判断用户是否登录
// function loginCheck(){
//     if (!localStorage.getItem('ticket')) {
//         window.location.href="login.html"
//     } else {
//         window.location.href = "user.html";
//     }
// }

//判断是否进入详情页面
function checkLogin(detailId,number){
    if (!localStorage.getItem('ticket')) {
        window.location.href="login.html"
    } else {
        window.location.href = "prodetail.html?id="+detailId+"&number="+number;
    }
}