$(function(){
    showEcharts();
});

function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('echart1',getOptionByRatio('床位使用率','床位使用率','bar'),'/api/hospital/bedUseRatio.json',param,callback);
    showEChartWithParam('echart2',getOption('出院者平均住院日','出院者平均住院日','bar'),'/api/hospital/averageHospitalDay.json',param,callback);
    showEChartWithParam('echart3',getOption('医师平均担负住院床日数','医师平均担负住院床日数','bar'),'/api/docLoadBedCount/echart.json',param,callback);
    showEChartWithParam('echart4',getOption('实际占用总床日数','实际占用总床日数','bar'),'/api/hospital/bedUseNum.json',param,callback);
    showEChartWithParam('echart5',getOption('出院者占用床日数','出院者占用床日数','bar'),'/api/outBedNum/echart.json',param,callback);
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