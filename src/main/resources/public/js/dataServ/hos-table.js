function getHospitalTableColumns() {
    var columns = [{
        field: 'datasetName',
        title: '数据集名称',
        align: 'center',
        formatter: function (value, row, index) {
            console.log('datasetStrucId:' + row.datasetStrucId + ',row:' + JSON.stringify(row));
            return '<a href="/dataStand/classify/dsDesc?id='+row.datasetStrucId+'">' + value + '</a>';
        }
    }, {
        field: 'businessSystem',
        title: '业务系统',
        sortable: true,
        align: 'center'
    }, {
        field: 'applicationTheme',
        title: '应用主题',
        sortable: true,
        align: 'center'
    }, {
        field: 'drsRows',
        title: '数据元总数',
        sortable: true,
        align: 'center'
    }, {
        field: 'dataTotal',
        title: '关联数据总数',
        sortable: true,
        align: 'center'
    }, {
        field: 'medicalOrgName',
        title: '所属机构',
        sortable: true,
        align: 'center'
    }];

    return columns;
}