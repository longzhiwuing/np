var validForm = {
    onfocusout: function (element) {
        $(element).valid();
    },
    success: function (label, element) {

    },
    rules: {
        email: {
            required: true,
            email: true
        },
        userName: {
            required: true,
            minlength: 2,
            maxlength: 32
        },
        password: {
            required: true,
            minlength: 6,
            maxlength: 32
        },
        confirmPassword: {
            required: true,
            minlength: 6,
            maxlength: 32,
            equalTo: "#password"
        },
        cardType: {
            required: true
        },
        cardNum: {
            required: true,
            minlength: 6,
            maxlength: 32
        },
        userType: {
            required: true
        },
        orgCode: {
            required: true
        },
        phone: {
            required: true,
            minlength : 11,
            isMobile : true
        }

    },
    messages: {
        email: {
            required: "请输入邮箱",
            email: "邮箱格式不正确"
        },
        userName: {
            required: "请输入用户名",
            minlength: "不能小于2个字符",
            maxlength: "不能大于32个字符"
        },
        password: {
            required: "请输入密码",
            minlength: "不能小于6个字符",
            maxlength: "不能大于32个字符"
        },
        confirmPassword: {
            required: "请输入确认密码",
            minlength: "不能小于6个字符",
            maxlength: "不能大于32个字符",
            equalTo: "两次输入的密码不同"
        },
        cardType: {
            required: "请输入卡类型"
        },
        cardNum: {
            required: "请输入卡号",
            minlength: "不能小于6个字符",
            maxlength: "不能大于32个字符"
        },
        userType: {
            required: "请输入用户类型"
        },
        orgCode: {
            required: "请输入组织机构代码"
        },
        phone: {
            required: "请输入手机号",
            minlength : "确认手机不能小于11个字符",
            isMobile : "请正确填写您的手机号码"
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
    $('#submitBtn').text('注册中...').attr('disabled', true).css("background-color","rgba(74,131,248,0.6)");
}

function showMsg(msg) {
    if (msg && msg != 'null') {
        $('#errorinfo').text(msg).parent().fadeIn();
    }
}

$('#submitBtn').click(function () {
    $('#registerForm').submit();
});

$('#registerForm').submit(function (e) {
    console.log('registerForm submit....');
    showloading();
    if (!$("#registerForm").validate(validForm).form()) {
        e.preventDefault();
        $('#submitBtn').text('登陆').attr('disabled', false);
        console.log("Submit prevented");
    }
});

$("#registerForm").keydown(function (e) {
    var e = e || event,
        keycode = e.which || e.keyCode;
    if (keycode == 13) {
        $("#submitBtn").trigger("click");
    }
});

$("#registerForm").validate(validForm);

$('span.close').click(function () {
    $(this).parent().fadeOut();
});

jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码");