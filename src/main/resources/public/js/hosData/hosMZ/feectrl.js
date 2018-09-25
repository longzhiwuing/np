$(function(){
    showEcharts();
});

function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('avgFeeByPeople',getOption2('门诊人均费用','bar','门诊人均费用'),'/api/avgFeeByPeople.json',param,callbackDiscount);
    showEChartWithParam('MedicineProportion',getOption('门诊药占比','bar','门诊药占比'),'/api/selectMedicineProportion.json',param,callbackDiscount);
    showEChartWithParam('ConsumablesProportion',getOption('门诊耗材费占比','bar','门诊耗材费占比'),'/api/selectConsumablesProportion.json',param,callbackDiscount);
    showEChartWithParam('CheckFeeProportion',getOption('门诊检查费占比','bar','门诊检查费占比'),'/api/selectCheckFeeProportion.json',param,callbackDiscount);
    showEChartWithParam('LaboratoryFeeProportion',getOption('门诊化验费占比','bar','门诊化验费占比'),'/api/selectLaboratoryFeeProportion.json',param,callbackDiscount);
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
        yAxis: {
            axisLabel: {
                formatter: '{value} %'
            }
        },
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
function getOption2(titles,types,names) {
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
        yAxis: {
        },
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


