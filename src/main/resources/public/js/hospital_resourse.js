function getOption(titlex,namex,typex) {
    var option = {
        title: {
            text: titlex
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
        legend: {},
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {readOnly: false},
                magicType: {type: ['line', 'bar']},
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [
            {
                name: namex,
                type: typex,
                markLine : {
                    data : [
                        {type : 'average'}
                    ]
                },
                smooth: true,
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
        field: 'getCount',
        title: '合同金额',
        sortable:true,
        align: 'center'
    }, {
        field: 'handleCount',
        title: '回款金额',
        sortable:true,
        align: 'center'
    }, {
        field: 'dimYear',
        title: '年份',
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

function search(){
    showEcharts();
}