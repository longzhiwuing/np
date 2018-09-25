var validForm = {
    onfocusout: function (element) {
        $(element).valid();
    },
    success: function (label, element) {

    },
    rules: {
        username: {
            required: true,
            minlength: 2,
            maxlength: 32
        },
        password: {
            required: true,
            minlength: 6,
            maxlength: 32
        },
        vcode: {
            required: true
        }
    },
    messages: {
        username: {
            required: "请输入用户名",
            minlength: "不能小于2个字符",
            maxlength: "不能大于32个字符"
        },
        password: {
            required: "请输入密码",
            minlength: "不能小于6个字符",
            maxlength: "不能大于32个字符"
        },
        vcode: {
            required: "请输入验证码"
        }
    },
    errorPlacement: function (error, element) {
        //error是错误提示元素span对象  element是触发错误的input对象
        //发现即使通过验证 本方法仍被触发
        //当通过验证时 error是一个内容为空的span元素
        element.nextAll('span.errorinfo').empty().text(error.html());
        $("input").css({"background":"#fff","border":"1px solid #ccc"})
    }
};

function showloading() {
    $('#submitBtn').text('登陆中...').attr('disabled', true).css("background-color","rgba(74,131,248,0.6)");
}

function showMsg(msg) {
    if (msg && msg != 'null') {
        $('#errorinfo').text(msg).parent().fadeIn();
    }
}

$('#submitBtn').click(function () {
    $('#loginForm').submit();
});

$('#loginForm').submit(function (e) {
    console.log('loginForm submit....');
    showloading();
    if (!$("#loginForm").validate(validForm).form()) {
        e.preventDefault();
        $('#submitBtn').text('登陆').attr('disabled', false);
        console.log("Submit prevented");
    }
});

$("#vcode").click(function () {
    $(this).attr('src', $(this).attr('src') + '?' + Math.random());
});

$("#loginForm").keydown(function (e) {
    var e = e || event,
        keycode = e.which || e.keyCode;
    if (keycode == 13) {
        $("#submitBtn").trigger("click");
    }
});

$("#loginForm").validate(validForm);

$('span.close').click(function () {
    $(this).parent().fadeOut();
});