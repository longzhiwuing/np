slideshow();
navHover();
tagToggle();
getIndexData();
// header-nav下拉框hover显示;
function navHover() {
    $(document).ready(function(){
        dropdownOpen();//调用
    });
    /**
     * 鼠标划过就展开子菜单，免得需要点击才能展开
     */
    function dropdownOpen() {

        var $dropdownLi = $('.navbar-box li.dropdown');

        $dropdownLi.mouseover(function() {
            $(this).addClass('open');
        }).mouseout(function() {
            $(this).removeClass('open');
        });
    }
}


function tagToggle() {
    $(".category-li").click(function () {
        $(".category-li").removeClass("active");
        $(this).addClass("active");

        var name = $(this).attr("name");
        $(".category-module").addClass("hide");
        $("#" + name).removeClass("hide");
    })
}

function getIndexData() {
    $.ajax({
        url: '/api/indexData.json',
        type: "GET",
        dataType: 'json',
        cache: false,
        success: function (data) {
            $('.hos-num').text(formatNum(data.hos));
            $('.total-num').text(formatNum(data.total));
            $('.metadata-num').text(formatNum(data.metadata));
        },
        error: function (data) {
            console.debug(data);
        }
    });
}

function formatNum(num){
    return (num+'').replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}

function slideshow() {
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#banner-box',
            width: '100%', //设置容器宽度
            height: '100%', //设置容器高度
            arrow: 'none' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
}