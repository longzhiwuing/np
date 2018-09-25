function getOption() {
    var option = {
        title: {
            text: '统计样例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: []
        }]
    };

    return option;
}

function callback(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;
}

function getTableColumns() {
    var columns = [{
        field: 'id',
        title: 'id',
        align: 'center'
    }, {
        field: 'name',
        title: '城市',
        sortable:true,
        align: 'center'
    }, {
        field: 'count',
        title: '數量',
        sortable:true,
        align: 'center'
    },{
        field: 'id',
        title: '操作',
        align: 'center',
        formatter:function(value,row,index){
            //通过formatter可以自定义列显示的内容
            //value：当前field的值，即id
            //row：当前行的数据
            var a = '<a href="" >测试</a>';
            return a;
        }
    }];

    return columns;
}