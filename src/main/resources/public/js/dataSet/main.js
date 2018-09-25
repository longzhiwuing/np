$(function () {
    // bootstrap工具提示
    $('[data-toggle="tooltip"]').tooltip();

    // layui日期控件
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        lay('.time-select').each(function() {
            laydate.render({
                elem : this,
            });
        });
    });


    navHover();
});

// header-nav下拉框hover显示;
function navHover() {
    $(document).ready(function(){
        dropdownOpen();//调用
    });
    /**
     * 鼠标划过就展开子菜单，免得需要点击才能展开
     */
    function dropdownOpen() {

        var $dropdownLi = $('li.dropdown');

        $dropdownLi.mouseover(function() {
            $(this).addClass('open');
        }).mouseout(function() {
            $(this).removeClass('open');
        });
    }
}
