$(function(){
    showEcharts();
});

function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('echart1',getOption('入院人次','入院人次','bar'),'/api/hospital/admissionNum.json',param,callback);
    showEChartWithParam('echart2',getOption('出院人次','出院人次','bar'),'/api/hospital/outNum.json',param,callback);
    showEChartWithParam('echart3',getOption('手术人数','手术人数','bar'),'/api/hospital/operatioRens.json',param,callback);
    showEChartWithParam('echart4',getOption('手术人次','手术人次','bar'),'/api/selectOperationNumberSum.json',param,callback);
    showEChartWithParam('echart5',getOption('死亡人数','死亡人数','bar'),'/api/hospital/deathRens.json',param,callback);
}

function search(){
    showEcharts();
}

function callback(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;
}

function getOption(title, name, type) {
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
        yAxis: {},
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
