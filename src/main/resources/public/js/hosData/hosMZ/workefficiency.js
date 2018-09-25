$(function(){
    showEcharts();
});
function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('docAvgOeManTime',getOption('医师平均担负门急诊人次','bar','医师担负人次'),'/api/docAvgOeManTime/echart.json',param,callbackDiscount);
}
function search() {
    showEcharts();
}
function getOption(titles,types,names) {
    var option = {
        color: ['#4A83F8'],
        title: {
            text: titles
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
            data:['门诊人次']
        },
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
                name: names,
                type: types,
                smooth: true,
                data: []
            }]
    };

    return option;
}


function callbackDiscount(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;

}


