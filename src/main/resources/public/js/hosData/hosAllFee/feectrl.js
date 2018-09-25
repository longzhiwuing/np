$(function(){
    showEcharts();
});

function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('echart1',getOptionByRatio('药费占比(住院+门诊)','药费占比','bar'),'/api/totalCost/physicByTotal.json',param,callback);
    showEChartWithParam('echart2',getOptionByRatio('耗材费占比(住院+门诊)','耗材费占比','bar'),'/api/totalCost/materialByTotal.json',param,callback);
    showEChartWithParam('echart3',getOptionByRatio('检查费占比(住院+门诊)','检查费占比','bar'),'/api/totalCost/checkByTotal.json',param,callback);
    showEChartWithParam('echart4',getOptionByRatio('化验费占比(住院+门诊)','化验费占比','bar'),'/api/totalCost/laboratoryByTotal.json',param,callback);
}

function search(){
    showEcharts();
}

function callback(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;
}

function getOptionByRatio(title, name, type) {
    var option = {
        color: ['#4A83F8'],
        title: {
            text: title
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
        yAxis: {
            type : 'value',
            axisLabel : {
                formatter: '{value}%'
            }
        },
        series: [
            {
                name: name,
                type: type,
                markLine: {
                    data: [
                        {type: 'average'}
                    ]
                },
                smooth: true,
                data: []
            }]
    };
    return option;
}