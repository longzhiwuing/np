$(function(){
    showEcharts();
});

function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('echart1',getOptionPie(),'/api/totalCost/totalCostPie.json',param,callbackPie);
}

function search(){
    showEcharts();
}

function callbackPie(option,data) {
    option.series[0].data[0] = {value:data.incomePhysic,name:'药品收入'};
    option.series[0].data[1] = {value:data.incomeMaterial,name:'耗材收入'};
    option.series[0].data[2] = {value:data.incomeTreat,name:'治疗收入'};
    option.series[0].data[3] = {value:data.incomeCheck,name:'检查收入'};
    option.series[0].data[4] = {value:data.incomeLaboratory,name:'化验收入'};
    option.series[0].data[5] = {value:data.incomeOperation,name:'手术收入'};
    option.series[0].data[6] = {value:data.incomeOther,name:'其他收入'};
    option.series[0].data[7] = {value:data.incomeBed,name:'床位收入'};
}

function getOptionPie() {
    var option = {
        title : {
            text: '费用占比图',
            x:'left'
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
                name: '费用占比图',
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