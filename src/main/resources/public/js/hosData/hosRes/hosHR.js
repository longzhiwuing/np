$(function () {
    showHosResourseEcharts();
    // showMyTable();
});

function search() {
    showHosResourseEcharts();
    showMyTable();
}

function showHosResourseEcharts() {
    var param = {'startDate': $("#startDate").val(), 'endDate': $("#endDate").val()};
    showEChartWithParam('doctorCount', getOption('医生人数', '医生数', 'bar'), '/api/doctorCount/echart.json', param, callback);
    showEChartWithParam('nurseCount', getOption('护士人数', '护士数', 'bar'), '/api/nurseCount/echart.json', param, callback);
    showEChartWithParam('docNurseRatio', getOption('医生护士比', '医生护士比', 'bar'), '/api/docNurseRatio/echart.json', param, callback);
    showEChartWithParam('docBedRatio', getOption('医生床位比', '比率', 'bar'), '/api/docBedRatio/echart.json', param, callback);

}

function showMyTable() {
    showTable('hos-cost-analysis-table', '/api/totalCost/table.json', getTableColumns());
}

function getOption(titlex, namex, typex) {
    var option = {
        color: ['#4A83F8'],
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


function callback(option, data) {
    option.xAxis.data = data.xAxis;
    option.series[0].data = data.yAxis;
}

function getTableColumns() {
    var columns = [{
        field: 'hospitalName',
        title: '医疗机构名称',
        align: 'center'
    }, {
        field: 'orgCode',
        title: '医疗机构代码',
        sortable: true,
        align: 'center'
    }, {
        field: 'incomeTotal',
        title: '医疗总收入',
        sortable: true,
        align: 'center'
    }, {
        field: 'incomePhysic',
        title: '药品收入',
        sortable: true,
        align: 'center'
    }, {
        field: 'incomeMaterial',
        title: '卫生材料收入',
        sortable: true,
        align: 'center'
    }, {
        field: 'incomeCheck',
        title: '检查收入',
        sortable: true,
        align: 'center'
    }, {
        field: 'incomeLaboratory',
        title: '化验收入',
        sortable: true,
        align: 'center'
    }, {
        field: 'incomeDisp',
        title: '门诊收入',
        sortable: true,
        align: 'center'
    }, {
        field: 'dispRegisterNum',
        title: '门急诊人次',
        sortable: true,
        align: 'center'
    }, {
        field: 'incomeResi',
        title: '住院收入',
        sortable: true,
        align: 'center'
    }, {
        field: 'settleNum',
        title: '结算人次',
        sortable: true,
        align: 'center'
    }];

    return columns;
}


$("#hos-table-1").on("click", function () {
    showMyTable();
});