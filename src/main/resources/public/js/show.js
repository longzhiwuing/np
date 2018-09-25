function getOption() {
    var option = {
        title: {
            text: '年度签单&回款统计'
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
            data:['合同金额','回款金额']
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
                name: '合同金额',
                type: 'line',
                smooth: true,
                data: []
            },
            {
                name: '回款金额',
                type: 'line',
                smooth: true,
                data: []
            }]
    };

    return option;
}

function getOptionPie() {
    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:[]
        },
        series: [
            {
                name:'年份',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[]
            }
        ]
    };

    return option;
}

function getDoctorCountOption() {
    var option = {
        title: {
            text: '医生人数'
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
                name: '医生数',
                type: 'bar',
                smooth: true,
                data: []
            }]
    };

    return option;
}

function callbackDefault(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;
}

function callback(option,data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis1;
    option.series[1].data = data.yAxis2;
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

function getTableColumnsHospital() {
    var columns = [{
        field: 'hospitalName',
        title: '医疗机构名称',
        align: 'center'
    }, {
        field: 'orgCode',
        title: '医疗机构代码',
        sortable:true,
        align: 'center'
    }, {
        field: 'incomeTotal',
        title: '医疗总收入',
        sortable:true,
        align: 'center'
    }, {
        field: 'incomePhysic',
        title: '药品收入',
        sortable:true,
        align: 'center'
    }, {
        field: 'incomeMaterial',
        title: '卫生材料收入',
        sortable:true,
        align: 'center'
    }, {
        field: 'incomeCheck',
        title: '检查收入',
        sortable:true,
        align: 'center'
    },{
        field: 'incomeLaboratory',
        title: '化验收入',
        sortable:true,
        align: 'center'
    }, {
        field: 'incomeDisp',
        title: '门诊收入',
        sortable:true,
        align: 'center'
    }, {
        field: 'dispRegisterNum',
        title: '门急诊人次',
        sortable:true,
        align: 'center'
    },{
        field: 'incomeResi',
        title: '住院收入',
        sortable:true,
        align: 'center'
    }, {
        field: 'settleNum',
        title: '结算人次',
        sortable:true,
        align: 'center'
    },{
        field: 'orgCode',
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