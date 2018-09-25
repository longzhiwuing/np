$(function(){
    showEcharts();
});
function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('dispRegisterNum',getOption('门急诊人次','bar','门诊人数'),'/api/selectDispRegisterNumByTime.json',param,callbackDiscount);
    showEChartWithParam('dispProfessionNum',getOption('专家门诊人次','bar','专家门诊人数'),'/api/selectDispProfessionNumSum.json',param,callbackDiscount);
    showEChartWithParam('prescribeDispNum',getOption('门急诊处方数','bar','门急诊处方数'),'/api/selectPrescribeDispNumSum.json',param,callbackDiscount);
    showEChartWithParam('disp0perationNum',getOption('门诊手术例数','bar','门诊手术例数'),'/api/selectDisp0perationNumSum.json',param,callbackDiscount);

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


