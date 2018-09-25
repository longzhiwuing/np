function getEcologicalTableColumns() {
    var columns = [{
        field: 'deCode',
        title: '数据元标识符（DE)',
        align: 'center'
    }, {
        field: 'deInnercode',
        title: '内部标识符',
        sortable:true,
        align: 'center'
    }, {
        field: 'deDesc',
        title: '数据元名称',
        sortable:true,
        align: 'center'
    },{
        field: 'deDefine',
        title: '定义',
        sortable:true,
        visible:false,
        align: 'center'
    },{
        field: 'deType',
        title: '数据类型',
        sortable:true,
        align: 'center'
    },{
        field: 'deFormat',
        title: '表示格式',
        sortable:true,
        align: 'center'
    },{
        field: 'allowValue',
        title: '数据元允许值',
        sortable:true,
        align: 'center'
    }];

    return columns;
}