function getOptionLine() {
    var option = {
        title: {
            text: '标题'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data:['数据名称']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [
            {
                name: '数据名称',
                type: 'line',
                smooth: true,
                data: []
            }]
    };

    return option;
}

function callbackLine(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;
}

function getOptionBar() {
    var option = {
        title: {
            text: '标题'
        },
        tooltip: {},
        legend: {
            data:['数据名称']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '数据名称',
            type: 'bar',
            data: []
        }]
    };

    return option;
}

function callbackBar(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;
}

function getOptionPie() {
    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:[]
        },
        series: [
            {
                name:'数据名称',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[]
            }
        ]
    };

    return option;
}

function callbackPie(option,data) {
    option.legend.data = data.legend;
    option.series[0].data = data.yAxis;
}

function getTableColumns() {
    var columns = [{
        field: '字段1',
        title: '显示1',
        align: 'center'
    }, {
        field: '字段2',
        title: '显示2',
        sortable:true,
        align: 'center'
    }, {
        field: '字段3',
        title: '显示3',
        sortable:true,
        align: 'center'
    }, {
        field: '字段4',
        title: '显示4',
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