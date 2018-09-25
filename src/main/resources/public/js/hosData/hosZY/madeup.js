$(function(){
    showEcharts();
});

function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('resFeeProportion',getOptionPie('住院费用占比图','费用明细'),'/api/resFeeProportion/echart.json',param,callbackPie);
}

function search(){
    showEcharts();
}

function getOptionPie(textx,namex) {
    var option = {
        title : {
            text: textx,
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: []
        },
        series : [
            {
                name: namex,
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
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
