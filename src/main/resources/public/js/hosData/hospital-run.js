$(function () {
    // bootstrap工具提示
    $('[data-toggle="tooltip"]').tooltip();

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#startDate', //指定元素
            value: '2016-01-01'
        });

        laydate.render({
            elem: '#endDate', //指定元素
            value: new Date()
        });
    });

    $("#startDate").val('2016-01-01');
    $("#endDate").val(new Date().Format("yyyy-MM-dd"));

    // top-title的定位位置;
    $(".top-title").each(function () {
        $(this).css("top",$(this).parents(".data-show").find(".form-box").css("height") + (($(this).parents(".data-show").find(".data-show-top").css("height") - $(this).css("height"))/2));
    })

    $('ul.table-echart>li').click(function () {
        $('ul.table-echart>li').removeClass('active');
        $(this).addClass('active');

        if($(this).hasClass('echart-chosen')){
            $('div.echart-content').removeClass('hide');
            $('div.table-content').addClass('hide');
        }
    });

    $('ul.table-echart>ul.dropdown-menu>li').click(function () {
        $('div.echart-content').addClass('hide');
        $('div.table-content').removeClass('hide');
    })

})