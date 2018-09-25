/**
 * Created by roy on 2018/6/25.
 */

function showFunnelRight(div_id, url) {
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
            var yAxisData = data.yAxis;
            var seriesIn = data.series.in;
            var RGBColor = data.RGBColor;
            var tagTital = '住院人均费用';
            var option = getFunnelOption(tagTital, RGBColor, yAxisData, seriesIn);
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

function showFunnelLeft(div_id, url) {
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
            var yAxisData = data.yAxis;
            var seriesIn = data.series.in;
            var RGBColor = data.RGBColor;
            var tagTotal = '门诊人均费用';
            var option = getFunnelOption(tagTotal, RGBColor, yAxisData, seriesIn);
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

function getFunnelOption(tagTotal, RGBColor, yAxisData, seriesIn) {
    return {
        textStyle: {
            color: '#FFF'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            textStyle: {
                color: '#FFF'
            },
            bottom: 10,
            data: [tagTotal]
        },
        grid: {
            show: false,
            left: 10,
            right: '4%',
            bottom: 40,
            top: 2,
            containLabel: true
        },
        xAxis: [
            {
                type: 'value'
            }
        ],
        yAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: yAxisData
            }
        ],
        series: [
            {
                name: tagTotal,
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true
                    }
                },
                data: seriesIn
            }
        ], color: RGBColor
    };
}


function showAreaReceivedPaymentEChart(div_id, url) {
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
            var xAxisData = data.xAxis;
            var seriesContractValue = data.series.contractValue;
            var seriesReimbursementAmount = data.series.reimbursementValue;
            var RGBColor = data.RGBColor;
            var option = getAreaReceivedPaymentOption(RGBColor, xAxisData, seriesContractValue, seriesReimbursementAmount);
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

function getAreaReceivedPaymentOption(RGBColor, xAxisData, seriesContractValue, seriesReimbursementAmount) {
    return {
        textStyle: {
            color: '#FFF'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#FFF'
                }
            }
        },
        title: {
            show: true,
            textStyle: {
                color: '#FFF'
            },
            text: '各医疗机构门急诊人次统计情况',
            top: 2,
            left: 800
        },
        grid: {
            show: true,
            borderWidth: 0,
            left: 70,
            bottom: 30,
            right: 120,
            top: 40
        },
        legend: {
            textStyle: {
                color: '#FFF'
            },
            top: 70,
            right: 10,
            orient: 'vertical',
            data: ['门急诊人次', '急诊人次']
        },
        xAxis: [
            {
                type: 'category',
                data: xAxisData,
                // splitLine: {
                //     show: false
                // },
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '门急诊人次',
                // splitLine: {
                //     show: false
                // },
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '急诊人次',
                // splitLine: {
                //     show: false
                // },
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name: '门急诊人次',
                type: 'bar',
                data: seriesContractValue
            },
            {
                name: '急诊人次',
                type: 'bar',
                data: seriesReimbursementAmount
            }
        ],
        color: RGBColor
    };
}


function showCircleCharts(div_id, url) {
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
            var this_option = {
                total: data.total,
                value: data.percent,//百分比,必填
                name: data.name,//必填
                backgroundColor: null,
                color: data.color,
                fontSize: 16,
            }

            percentPie = new PercentPie(this_option);
            var option = percentPie.init();

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

function showRoseCharts(div_id, url) {
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
            var legend_data = data.legendData;
            var series_data = data.seriesData;
            var title = data.title
            var option = rose(legend_data, series_data, title);

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

function showLineCharts(div_id, url) {
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
            var x_data = data.xData;
            var s_data = data.sData;
            var legend_data = data.legendData;
            var title = data.title;
            var color = data.color;
            var option = smooth_line(legend_data, x_data, s_data, title, color);

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

//圆环百分比
function PercentPie(option) {
    this.backgroundColor = option.backgroundColor || '#fff';
    this.color = option.color || ['#38a8da', '#d4effa'];
    this.fontSize = option.fontSize || 12;
    this.domEle = option.domEle;
    this.value = option.value;
    this.name = option.name;
    this.title = option.title;
    this.total = option.total;
}
PercentPie.prototype.init = function () {
    var _that = this;
    var option = {
        //backgroundColor: _that.backgroundColor,
        graphic: {
            elements: [{
                type: 'circle',
                shape: {
                    r: 60
                },
                style: {
                    fill: '#fff'

                },
                left: 'center',
                top: 'center'
            }]
        },
        color: _that.color,
        title: {
            text: _that.title,
            top: '3%',
            left: '1%',
            textStyle: {
                color: '#fff',
                fontStyle: 'normal',
                fontWeight: 'normal',
                fontFamily: 'sans-serif',
                fontSize: 16,
            }
        },
        series: [{
            name: '来源',
            type: 'pie',
            radius: ['60%', '75%'],
            avoidLabelOverlap: false,
            hoverAnimation: false,
            label: {
                backgroundColor: '#fff',
                normal: {

                    show: false,
                    position: 'center',
                    textStyle: {
                        fontSize: 12,
                        fontWeight: 'bold',
                        color: '#000'
                    },
                    formatter: '{c}%\n{b}:' + getTotal(_that.value, _that.total / 100000000) + '亿'
                }
            },
            data: [{
                value: _that.value,
                name: _that.name,
                label: {
                    normal: {
                        show: true
                    }
                }
            },
                {
                    value: 100 - _that.value,
                    name: ''
                }
            ]
        }]
    };

    //echarts.init(_that.domEle).setOption(option);
    return option;
};

function getTotal(percent, total) {
    return new Number(percent * total / 100).toFixed(2)
}

function rose(legend_data, series_data, title) {
    var option = {
        //backgroundColor: '#fff',
        title: {
            text: title,
            textStyle: {
                color: '#FFF'
            },
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            right: 0,
            top: 20,
            bottom: 20,
            data: legend_data,
            textStyle: {
                color: '#FFF'
            }
        },
        calculable: true,
        series: [
            {
                name: '医院数据分布',
                type: 'pie',
                radius: [50, 75],
                center: ['40%', '50%'],
                roseType: 'radius',
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                lableLine: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                data: series_data
            }
        ],
        color: ['#800080', '#87CEFA', '#00FF7F', '#DC143C', '#FFFF00', '#9370DB']
    };
    return option;
}

function smooth_line(legend_data, x_data, series_data, title, color) {
    var option = {
        // backgroundColor: '#fff',
        textStyle: {
            color: '#FFF'
        },
        title: {
            text: title,
            textStyle: {
                color: '#FFF'
            },
        },
        tooltip: {
            trigger: 'axis',
        },
        legend: {
            data: legend_data,
            textStyle: {
                color: '#FFF'
            },
            bottom: 10
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: x_data,
            splitLine: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#FFF',
                }
            }
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value}'
            },
            splitLine: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#FFF',
                }
            }
        },
        series: series_data,
        color: color
    };

    return option;

}


function showHomeMap(div_id, url) {
    $.get('./js/lib/script/allCitys/35/350100.json', function (geoJson) {
        echarts.registerMap(div_id, geoJson);
        fillHomeMap(div_id, url);
    });
}

function fillHomeMap(div_id, url) {
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
            var data = data.data;
            var option = getHomeMapOption(div_id, data);
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

function getHomeMapOption(div_id, data) {
    var retOption;

    var effectScatterData = [];
    var convertData = [];
    // 统计各市数据量
    var cityData = [];
    var sumData = 0;
    var maxData = 0;
    var minData = 0;
    var maxRate = 0;

    var sumDataHos = 0;
    var maxDataHos = 0;
    var minDataHos = 0;
    var maxRateHos = 0;

    minDataHos = data[0].num;
    if (data && data.length > 0) {
        var tempData = 0;
        var tempHospital = "";
        var tempArea = "";
        var temp;
        for (var i = 0; i < data.length; i++) {
            temp = data[i];
            tempData = temp.num;
            tempHospital = temp.hospital_name;
            tempArea = temp.area_name;

            sumDataHos += tempData;
            if (minDataHos > tempData) {
                minDataHos = tempData;
            }
            if (maxDataHos < tempData) {
                maxDataHos = tempData;
            }

            effectScatterData.push({
                name: tempHospital,
                value: tempData
            });
            convertData.push({
                name: tempHospital,
                value: [temp.longitude, temp.latitude, tempData]
            });

            var isExisted = false;
            for (var j = 0; j < cityData.length; j++) {
                if (tempArea == cityData[j].name) {
                    cityData[j].value += tempData;
                    isExisted = true;
                    break;
                }
            }
            if (!isExisted) {
                cityData.push({
                    name: tempArea,
                    value: tempData
                });
            }
        }
        if (sumDataHos <= 0) {
            sumDataHos = 1;
        }
    }
    if (maxDataHos / sumDataHos < 0.001) {
        maxRateHos = 0;
    } else if (maxDataHos / sumDataHos < 0.01) {
        maxRateHos = 1;
    } else if (maxDataHos / sumDataHos < 0.1) {
        maxRateHos = 2;
    } else if (maxDataHos / sumDataHos < 1) {
        maxRateHos = 3;
    }

    minData = minDataHos;
    for (var i = 0; i < cityData.length; i++) {
        tempData = cityData[i].value;
        sumData += tempData;
        if (minData > tempData) {
            minData = tempData;
        }
        if (maxData < tempData) {
            maxData = tempData;
        }
    }
    if (sumData <= 0) {
        sumData = 1;
    }

    // group与colors数量一致
    var group = 4;
    var colors = ["#DCFDFF", "#AFE2F9", "#82C8F4", "#60B4F0"];
    var zoom = 1.3;
    var avgVal = Math.ceil((maxData - minData) / group);
    var pieces = [];
    for (var i = 0; i < group; i++) {
        var pt = {
            min: minData + avgVal * i,
            max: minData + avgVal * (i + 1),
            color: colors[i]
        };
        pieces.push(pt);
    }

    var series = [];
    series.push({
        name: '定位',
        type: 'effectScatter',
        coordinateSystem: 'geo',
        data: effectScatterData,
        /*symbolSize: function(val) {
         return val[2] / 2;
         },*/
        showEffectOn: 'render',
        rippleEffect: {
            brushType: 'stroke'
        },
        hoverAnimation: true,
        itemStyle: {
            normal: {
                color: '#0ce928',
                shadowBlur: 20,
                shadowColor: '#0ce928',
            }
        },
        zlevel: 1
    }, {
        type: 'map',
        map: div_id,
        zoom: zoom,
        // roam: true,
        zlevel: 0,
        itemStyle: {
            normal: {
                borderColor: 'transparent',
                color: '#555'
            }
        },
        data: cityData
    }, {
        name: '点',
        type: 'scatter',
        coordinateSystem: 'geo',
        symbol: 'pin',
        symbolSize: function (val) {// 控制点的大小
            if (maxRateHos == 0) {
                return Math.max((val[2] / sumDataHos * 70000).toFixed(2), '10');
            } else if (maxRateHos == 1) {
                return Math.max((val[2] / sumDataHos * 7000).toFixed(2), '10');
            } else if (maxRateHos == 2) {
                return Math.max((val[2] / sumDataHos * 700).toFixed(2), '10');
            } else if (maxRateHos == 3) {
                return Math.max((val[2] / sumDataHos * 70).toFixed(2), '10');
            } else {
                return 15;
            }
        },
        label: {
            normal: {
                show: true,
                textStyle: {
                    color: '#000',
                }
            }
        },
        itemStyle: {
            normal: {
                color: '#fff',
                borderColor: "#fff",
                borderWidth: 2,
            },
            emphasis: {
                borderColor: '#fff',
                borderWidth: 2
            }
        },
        zlevel: 6,
        data: convertData
    });

    retOption = {
        tooltip: {
            trigger: 'item',
            formatter: function (params) {
                var val = 0;
                if (params.seriesIndex == 1) {
                    val = params.data.value;
                    if (!val) {
                        val = 0;
                    }
                } else if (params.seriesIndex == 2) {
                    val = params.data.value[2];
                }
                return params.name + '：<br/>' + val + "人次";
            }
        },
        visualMap: {
            type: 'piecewise',
            splitNumber: 6,
            inverse: true,
            pieces: pieces,
            left: 'left',
            top: 'bottom',
            textStyle: {
                color: '#fff'
            }
        },
        geo: {
            map: div_id,
            zoom: zoom,
            // roam: true,
            itemStyle: {
                normal: {
                    areaColor: '#ddd',
                    borderColor: 'transparent'
                },
                emphasis: {
                    areaColor: '#ccc'
                }
            },
        },
        series: series
    };

    return retOption;
}


function showChinaMap(div_id, url) {
    var retChinaData = [
        /*["350000000","35","福建",117.984943,26.050118,0],
         ["130000000","13","河北",115.661434,38.61384,0],
         ["440000000","44","广东",113.394818,23.408004,0],
         ["620000000","62","甘肃",102.457625,38.103267,0],
         ["150000000","15","内蒙古",114.415868,43.468238,0],
         ["120000000","12","天津",117.210813,39.14393,0],
         ["230000000","23","黑龙江",128.047414,47.356592,0],
         ["410000000","41","河南",113.486804,34.157184,0],
         ["450000000","45","广西",108.924274,23.552255,0],
         ["340000000","34","安徽",117.216005,31.859252,0],
         ["140000000","14","山西",112.515496,37.866566,0],
         ["320000000","32","江苏",119.368489,33.013797,0],
         ["430000000","43","湖南",111.720664,27.695864,0],
         ["500000000","50","重庆",106.530635,29.544606,0],
         ["210000000","21","辽宁",122.753592,41.6216,0],
         ["360000000","36","江西",115.676082,27.757258,0],
         ["610000000","61","陕西",109.503789,35.860026,0],
         ["650000000","65","新疆",85.614899,42.127001,0],
         ["540000000","54","西藏",89.137982,31.367315,0],
         ["370000000","37","山东",118.527663,36.09929,0],
         ["510000000","51","四川",102.89916,30.367481,0],
         ["640000000","64","宁夏",106.155481,37.321323,0],
         ["110000000","11","北京",116.395645,39.929986,0],
         ["330000000","33","浙江",119.957202,29.159494,0],
         ["420000000","42","湖北",112.410562,31.209316,0],
         ["460000000","46","海南",109.733755,19.180501,0],
         ["520000000","52","贵州",106.734996,26.902826,0],
         ["630000000","63","青海",96.202544,35.499761,0],
         ["220000000","22","吉林",126.262876,43.678846,0],
         ["310000000","31","上海",121.487899,31.249162,0],
         ["530000000","53","云南",99.580343,22.334366,0],*/
        ["350100000", "350100", "福州市", 119.330221, 26.047125, 30000]
    ];
    var chinaChart = echarts.init(document.getElementById(div_id));
    $.get('./js/lib/script/china.json', function (geoJson) {
        echarts.registerMap("china", geoJson);
        var myData = toConvertDataForChina(retChinaData);
        var chinaOption = getChinaOption(myData);
        chinaChart.setOption(chinaOption);
    });

    chinaChart.on("click", function (params) {
        for (var i = 0; i < retChinaData.length; i++) {
            if (params.name == retChinaData[i][2]) {
                window.open("http://www.baidu.com", "福州市已采集医院列表");
                break;
            }
        }
    });
}

function toConvertDataForChina(data) {
    var res = [];
    var resScatter = [];
    for (var i = 0; i < data.length; i++) {
        var geoCoord = data[i][2];
        if (geoCoord) {
            res.push({
                name: geoCoord,
                value: data[i][5]
            });
            resScatter.push({
                name: geoCoord,
                value: [data[i][3], data[i][4], data[i][5]]
            });
        }
    }
    return [res, resScatter];
};

function getChinaOption(data) {
    var mapData = data[0];
    var scatterData = data[1];
    var t = mapData;
    var zoom = 1.2;
    /*var sumData = 0;
     var maxData = 0;
     var tempData = 0;
     var maxRate = 0;
     if(t[0] != null && t[0] != ''){
     for(var i=0;i<t.length;i++) {
     tempData = t[i]['value'];
     sumData += tempData;
     if(maxData < tempData) {
     maxData = tempData;
     }
     }
     if(sumData<=0) {
     sumData = 1;
     }
     }*/

    return option = {
        backgroundColor: {
            color: '#1e73be'
        },
        animation: true,
        animationDuration: 1000,
        animationEasing: 'cubicInOut',
        animationDurationUpdate: 1000,
        animationEasingUpdate: 'cubicInOut',
        title: {
            text: '全国数据总览',
            left: '42%',
            top: "10",
            textStyle: {
                color: '#fff',
                fontSize: 20
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params) {
                /*var value = 0;
                 var name = "-";
                 if (params.data) {
                 value = params.data.value;
                 name = params.data.name;
                 if (typeof(value) == 'undefined') {
                 value = "-";
                 }
                 if (typeof(name) == 'undefined') {
                 name = "-";
                 }
                 } else {
                 value = "-";
                 }
                 return params.seriesName + '<br/>' + name + "：" + value;*/
                if (params.data) {
                    return params.data.name;
                } else {
                    return "";
                }
            }
        },
        /*visualMap: {
         min: 0,
         max: maxData,
         left: 'left',
         top: 'bottom',
         text: ['数量：高', '低'],
         calculable: true,
         inRange: {
         color: ['#50a3ba', '#eac736', '#d94e5d']
         }
         },*/
        toolbox: {
            show: true,
            feature: {
                saveAsImage: {show: true}
            }
        },
        geo: {
            show: true,
            map: 'china',
            zoom: zoom,
            label: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: true,
                }
            },
            roam: false,
            /*itemStyle: {
             normal: {
             areaColor: '#031525',
             borderColor: '#3B5077',
             },
             emphasis: {
             areaColor: '#2B91B7',
             }
             }*/
        },
        series: [
            {
                name: '散点',
                type: 'scatter',
                coordinateSystem: 'geo',
                data: scatterData,
                symbolSize: function (val) {
                    return val[2] / 2000;
                },
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#05C3F9'
                    }
                }
            },
            {
                name: '统计数据',
                type: 'map',
                mapType: 'china',
                zoom: zoom,
//                    roam: true,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                selectedMode: 'single',
                /*itemStyle:{
                 // normal:{label:{show:true,formatter:'{b}\n{c}'}},
                 normal:{
                 label:{
                 show:true,
                 formatter: function (params) {
                 var value = 0;
                 if (params.data) {
                 value = params.data.value;
                 if (typeof(value) == 'undefined') {
                 value = 0;
                 }
                 } else {
                 value = 0;
                 }
                 return params.name + "\n" + value;
                 }
                 }
                 },
                 emphasis:{label:{show:true}}
                 },*/
                data: mapData
            }, {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin',
                symbolSize: function (val) {
                    return 40;
                },
                label: {
                    normal: {
                        show: false,// 显示数字
                        textStyle: {
                            color: '#fff',
                            fontSize: 14,
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#F62157', //标志颜色
                    }
                },
                zlevel: 6,
                data: scatterData,
            },
            {
                name: 'Top 5',
                type: 'effectScatter',
                coordinateSystem: 'geo',
                data: scatterData,
                symbolSize: function (val) {
                    return val[2] / 2000;
                },
                showEffectOn: 'render',
                rippleEffect: {
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: false
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#05C3F9',
                        shadowBlur: 10,
                        shadowColor: '#05C3F9'
                    }
                },
                zlevel: 1
            },
        ]
    };
}