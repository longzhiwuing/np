function getOption2(titles,names) {
    var option = {
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
            data:['手术人次']
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
                type: 'line',
                smooth: true,
                data: []
            },
            {
                name: names,
                type: 'line',
                smooth: true,
                data: []
            }]
    };

    return option;
}
function getOptionZero() {
    var option = {
        title: {
            text: '入院人次'
        },
        tooltip: {},
        legend: {
            data:['入院人次']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '入院人次',
            type: 'bar',
            data: []
        }]
    };

    return option;
}

function getOptionOne() {
    var option = {
        title: {
            text: '出院人次'
        },
        tooltip: {},
        legend: {
            data:['出院人次']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '出院人次',
            type: 'bar',
            data: []
        }]
    };

    return option;
}

function getOptionOneA() {
    var option = {
        title: {
            text: '手术人数'
        },
        tooltip: {},
        legend: {
            data:['手术人数']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '手术人数',
            type: 'bar',
            data: []
        }]
    };

    return option;
}

function getOptionOneB() {
    var option = {
        title: {
            text: '死亡人数'
        },
        tooltip: {},
        legend: {
            data:['死亡人数']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '死亡人数',
            type: 'bar',
            data: []
        }]
    };

    return option;
}

function getOptionOneC() {
    var option = {
        title: {
            text: '实际占用总床日数'
        },
        tooltip: {},
        legend: {
            data:['实际占用总床日数']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '实际占用总床日数',
            type: 'bar',
            data: []
        }]
    };

    return option;
}

function getOptionTwo() {
    var option = {
        title: {
            text: '平均住院日'
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
            data:['平均住院日']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [
            {
                name: '平均住院日',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionThree() {
    var option = {
        title: {
            text: '31天重返率'
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
            data:['31天重返率']
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
                name: '31天重返率',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionFour() {
    var option = {
        title: {
            text: '床位使用率'
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
            data:['床位使用率']
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
                name: '床位使用率',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionFive() {
    var option = {
        title: {
            text: '人均费用'
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
            data:['人均费用']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '人均费用',
            type: 'bar',
            data: []
        }]
    };
    return option;
}

function getOptionSix() {
    var option = {
        title: {
            text: '药占比'
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
            data:['药占比']
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
                name: '药占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionSeven() {
    var option = {
        title: {
            text: '耗材费占比'
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
            data:['耗材费占比']
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
                name: '耗材费占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionEight() {
    var option = {
        title: {
            text: '检查费占比'
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
            data:['检查费占比']
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
                name: '检查费占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionNine() {
    var option = {
        title: {
            text: '化验费占比'
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
            data:['化验费占比']
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
                name: '化验费占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionEleven() {
    var option = {
        title: {
            text: '药费占比'
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
            data:['药费占比']
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
                name: '药费占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionTwelve() {
    var option = {
        title: {
            text: '耗材费占比'
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
            data:['耗材费占比']
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
                name: '耗材费占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionThirdteen() {
    var option = {
        title: {
            text: '检查费占比'
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
            data:['检查费占比']
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
                name: '检查费占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionFourteen() {
    var option = {
        title: {
            text: '化验费占比'
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
            data:['化验费占比']
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
                name: '化验费占比',
                type: 'line',
                smooth: true,
                data: []
            }]
    };
    return option;
}

function getOptionFiveteen() {
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
    option.series[0].data = data.yAxis1;
}

function callbacks(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis1;
    option.series[1].data = data.yAxis2;
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

function getTableColumns() {
    var columns = [{
        field: '字段1',
        title: '显示1',
        align: 'center'
    }, {
        field: '字段2',
        title: '显示2',
        sortable:true,
        align: 'center'
    }, {
        field: '字段3',
        title: '显示3',
        sortable:true,
        align: 'center'
    }, {
        field: '字段4',
        title: '显示4',
        sortable:true,
        align: 'center'
    }];

    return columns;
}
