/**
 * Created by roy on 2018/6/28.
 */

function showHosCountDataEChart(div_id, url) {
    var chart = echarts.init(document.getElementById(div_id));
    $.ajax({
        url: url,
        type: "GET",
        dataType: 'json',
        cache: false,
        beforeSend: function () {
            chart.showLoading({
                text: 'loading...',
                effect: 'spin',
                textStyle: {
                    fontSize: 20
                }
            });
        },
        success: function (data) {
            var titleText = '医院数据总量占比';
            var legendData = data.legend;
            var seriesData = data.series;
            var option = getHosCountDataOption(titleText,legendData,seriesData);
            chart.setOption(option, true);
        },
        error: function (data) {
            console.debug(data);
        },
        complete: function () {
            chart.hideLoading();
        }
    });
}

function showHosSysCountDataEChart(div_id, url) {
    var chart = echarts.init(document.getElementById(div_id));
    $.ajax({
        url: url,
        type: "GET",
        dataType: 'json',
        cache: false,
        beforeSend: function () {
            chart.showLoading({
                text: 'loading...',
                effect: 'spin',
                textStyle: {
                    fontSize: 20
                }
            });
        },
        success: function (data) {
            var titleText = '系统数据总量占比';
            console.log(data);
            var legendData = data.legend;
            var seriesData = data.series;
            var option = getHosCountDataOption(titleText,legendData,seriesData);
            chart.setOption(option, true);
        },
        error: function (data) {
            console.debug(data);
        },
        complete: function () {
            chart.hideLoading();
        }
    });
}

function getHosCountDataOption(titleText,legendData,seriesData) {
    return {
        title : {
            text: titleText,
            // subtext: '纯属虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: legendData
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:seriesData,
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
}