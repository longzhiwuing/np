$(function(){
    showEcharts();
});

function showEcharts(){
    var param = {'startDate':$("#startDate").val(),'endDate':$("#endDate").val()};
    showEChartWithParam('dispFeeProportion',getOptionPie('门诊费用占比图','门诊费用明细'),'/api/dispFeeProportion/echart.json',param,callbackPie);
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


