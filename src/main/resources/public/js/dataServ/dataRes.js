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

    sidenavBarToggle();
    tableEchartToggle();
})


// table和echarts的切换;
function tableEchartToggle() {
    $(".table-echart>li").click(function () {
        // $(".table-echart:not('.hide')>li").removeClass("active");
        $(this).parents(".data-show").find(".table-echart").children("li").removeClass("active");
        $(this).addClass("active");

        var name = $(this).attr("name");
        $(this).parents(".data-show").find(".data-show-module").addClass("hide");
        // $(".data-show-module").addClass("hide");
        $(this).parents(".data-show").find("#" + name).removeClass("hide");
        // $("#" + name).removeClass("hide");
    })
}

// sidebar-nav切换;
function sidenavBarToggle() {
    $(".nav-sidebar .nav-item").click(function () {
        $(".nav-sidebar .nav-item").removeClass("active");
        $(this).addClass("active");

        var name = $(this).attr("name");
        $(".data-show").addClass("hide");
        $("#" + name).removeClass("hide");
    })
}


function getTableColumns() {
    var columns = [{
        field: 'deCode',
        title: '数据元标识符（DE)',
        align: 'center'
    }, {
        field: 'deInnercode',
        title: '内部标识符',
        sortable:true,
        align: 'center'
    }, {
        field: 'deDesc',
        title: '数据元名称',
        sortable:true,
        align: 'center'
    },{
        field: 'deDefine',
        title: '定义',
        sortable:true,
        align: 'center'
    },{
        field: 'deType',
        title: '数据元值的数据类型',
        sortable:true,
        align: 'center'
    },{
        field: 'deFormat',
        title: '表示格式',
        sortable:true,
        align: 'center'
    },{
        field: 'allowValue',
        title: '数据元允许值',
        sortable:true,
        align: 'center'
    }];

    return columns;
}

