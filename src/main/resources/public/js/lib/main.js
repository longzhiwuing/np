function showEChart(div_id,op,url,callback) {
    var chart = echarts.init(document.getElementById(div_id));
    var option = op;
    $.ajax({
        url:url,
        type: "GET",
        beforeSend:function(){
            chart.showLoading({
                text : 'loading...',
                effect : 'spin',
                textStyle : {
                    fontSize : 20
                }
            });
        },
        success:function(data){
            callback(option,data);
            chart.setOption(option, true);
        },
        error:function(data){
            console.debug(data);
        },
        complete:function () {
            chart.hideLoading();
        }
    });
}

function showTable(tableId,url,columns){
    $('#'+tableId).bootstrapTable({
        method: 'GET',
        toolbar: '#'+tableId+'-toolbar',    //工具按钮用哪个容器
        striped: true,      //是否显示行间隔色
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,     //是否显示分页（*）
        sortable: true,      //是否启用排序
        pageNumber:1,      //初始化加载第一页，默认第一页
        pageSize: 10,      //每页的记录行数（*）
        pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
        url: url,//这个接口需要处理bootstrap table传递的固定参数
        queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                            // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber

        queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
        sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
        search: true,  //是否显示表格搜索
        strictSearch: true,
        showColumns: true,     //是否显示所有的列
        showRefresh: true,     //是否显示刷新按钮
        minimumCountColumns: 2,    //最少允许的列数
        clickToSelect: true,    //是否启用点击选中行
        // searchOnEnterKey: true,
        columns: columns
    });
}

function showEChartWithParam(div_id,op,url,params,callback) {
    var chart = echarts.init(document.getElementById(div_id));
    var option = op;
    $.ajax({
        url:url,
        type: "GET",
        data: params,
        beforeSend:function(){
            chart.showLoading({
                color: '#4A83F8',
                text : 'loading...',
                effect : 'spin',
                textStyle : {
                    fontSize : 20
                }
            });
        },
        success:function(data){
            callback(option,data);
            chart.setOption(option, true);
        },
        error:function(data){
            console.debug(data);
        },
        complete:function () {
            chart.hideLoading();
        }
    });
}

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

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

navHover();


//得到查询的参数
function queryParams(params) {
    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        // limit: params.limit,   //页面大小
        offset: params.offset,  //页码
        pageSize:params.pageSize,
        pageNumber:params.pageNumber,
        sortOrder:params.sortOrder,
        sortName:params.sortName,
        searchText:params.searchText,
        startDate: $("#startDate").val(),
        endDate:$("#endDate").val(),
    };
    console.log('queryParams:' + JSON.stringify(temp));
    return temp;
};