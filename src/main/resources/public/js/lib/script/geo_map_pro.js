// geo_map_pro.jsp相关js

/* 注：陕西省和福州市两套jkda的经纬度反了，需要修改时请搜索“FIXME 经纬度” */ 


// 控制地市是否存在点击事件
var CountryCanClick = true;
/**
 * 控制地市是否存在点击事件
 * @param flag true or false 
 */
function setCountryCanClick(flag) {
	CountryCanClick = flag;
}

var requestData = {
    sid:Math.random()
};
var currentMonthData ;
// 首次加载时某省中各地市的数据
var RetProData;
// 首次加载时某地市中各区县的数据
var RetCityData;
var ConvertedDataProvince;
var ConvertedDataCity;
var CityCodeParam;

var ContextName;
var ShowProvinceUrl;
var ShowCityUrl;

var MYCHART;
var DOMID;
// 当前显示地图类型(province/city)
var CurrentMapType;
var MyChartOption;

/**
 * 
 * @param domId
 * @param showProvinceUrl
 * @param chartOption echarts的option参数，key为与echarts同目录同名参数
 */
function showProvince(domId,showProvinceUrl,chartOption) {
	var provinceChart = echarts.init(document.getElementById(domId));
	MYCHART = provinceChart;
	DOMID = domId;
	provinceChart.showLoading({
        text : 'loading...',
        effect : 'bar',
        textStyle : {
            fontSize : 20
        }
    });
	
    $.ajax({
        url: showProvinceUrl,
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded; charset=utf-8', 
        data: requestData,
        dataType:"json",
        async: false, //默认为true 异步
        error: function (e) {
            console.log("地图数据获取错误");
        },
        success: function (returnData) {
//        	$(".china-map").addClass("china-map-disabled");
            RetProData = returnData;
            var myData = toCreateData(RetProData);
            var geoCoordMapTemp = myData[0];
            var dataTemp = myData[1];
            ConvertedDataProvince = getConvertedData(geoCoordMapTemp, dataTemp);
            var provinceOption = getProvinceOption(domId,ConvertedDataProvince);
            // 合并属性
        	$.extend(true,provinceOption,provinceOption,chartOption);
            provinceChart.setOption(provinceOption,true);
            provinceChart.on('brushselected', brushSelected);
            // 更新右侧柱状图
            brushChart(provinceChart);
            provinceChart.hideLoading();
        }
    });
    
    /**
     * 点击某市位置，展示该市地图
     * @param params
     */
    provinceChart.on('click', function (params) {
    	/*for(var i=0;i<RetProData.length;i++) {
	        if(RetProData[i][2] == params.name){
	            var cityData = {
	                cityCode: RetProData[i][1],
	                cityNameCh: RetProData[i][2],
	                x1: RetProData[i][3],
	                y1: RetProData[i][4]
	            };
	            showCity(domId,ShowCityUrl,cityData);
	            break;
	        }
	    }*/
    	mapOnClick(params);
    });
}

function getProvinceOption(domId,convertedData) {
    var t = convertedData[1];
    var sumData = 0;
    var maxData = 0;
    var tempData = 0;
    var maxRate = 0;
    if(t[0] != null && t[0] != ''){
        for(var i=0;i<t.length;i++) {
            tempData = t[i]['value'][2]
            sumData += tempData;
            if(maxData < tempData) {
                maxData = tempData;
            }
        }
        if(sumData<=0) {
            sumData = 1;
        }
    }
    if(maxData / sumData < 0.001) {
            maxRate = 0;
    } else if(maxData / sumData < 0.01) {
            maxRate = 1;
    } else if(maxData / sumData < 0.1) {
            maxRate = 2;
    } else if(maxData / sumData < 1) {
            maxRate = 3;
    }

    return option = {
//        backgroundColor: '#222',
        animation: true,
        animationDuration: 1000,
        animationEasing: 'cubicInOut',
        animationDurationUpdate: 1000,
        animationEasingUpdate: 'cubicInOut',
        title: [
            {
                text: myTitle + '数据采集总量监控',
                left: '45%',
                top: "10",
                textStyle: {
                    color: '#fff',
                    fontSize: 20
                }
            },
            {
                id: 'statistic_0',
                right: 120,
                top: 40,
                width: 100,
                textStyle: {
                    color: '#fff',
                    fontSize: 16
                }
            }
        ],
        toolbox: {
            iconStyle: {
                normal: {
                    borderColor: '#fff'
                },
                emphasis: {
                    borderColor: '#b1e4ff'
                }
            }
        },
        brush: {
            outOfBrush: {
                color: '#abc'
            },
            brushStyle: {
                borderWidth: 2,
                color: 'rgba(0,0,0,0.2)',
                borderColor: 'rgba(0,0,0,0.5)',
            },
            seriesIndex: [0, 1],
            throttleType: 'debounce',
            throttleDelay: 300,
            geoIndex: 0
        },
        geo: {
            map: domId,
            layoutCenter: ['30%', '52%'],
            layoutSize: "92%",
            // left: '25%',
            // top: "200",
            // right: '60%',
            // center:[108.973260527344, 34.7379274726563],
            zoom: 0.9,
            label: {
                emphasis: {
                    show: false
                }
            },
            roam: false,
            itemStyle: {
                normal: {
                    areaColor: '#323c48',
                    borderColor: '#111'
                },
                emphasis: {
                    areaColor: '#2a333d'
                }
            }
        },
        tooltip: {
            trigger: 'item'
        },
        grid: {
            right: "15%",
            top: 100,
            bottom: 40,
            width: '30%'
        },
        xAxis: {
            min:0,
            type: 'value',
            scale: true,
            position: 'top',
            splitNumber: 3, 
            boundaryGap: false,
            splitLine: {show: false},
            axisLine: {show: false},
            axisTick: {show: false},
            axisLabel: {margin: 2, textStyle: {color: '#aaa'}},
        },
        yAxis: {
            type: 'category',
            name: '',
            nameGap: 16,
            axisLine: {show: false, lineStyle: {color: '#ddd'}},
            axisTick: {show: false, lineStyle: {color: '#ddd'}},
            axisLabel: {interval: 0, textStyle: {color: '#ddd'}},
            data: []
        },
        series: [ {
            name: '',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: convertedData[0],
            symbolSize: function (val) {
                return 8;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: false
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#ddb926'
                }
            },
            tooltip: {
                formatter: function(params) {
                    return params.name + "：" + params.value[2];
                }
            }
        },
        {
            name: '',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            data: convertedData[1],
            symbolSize: function (val) {// 控制点的大小
                if (maxRate == 0) {
                    return Math.max((val[2] / sumData * 23000).toFixed(2), '10');
                } else if (maxRate == 1) {
                    return Math.max((val[2] / sumData * 2300).toFixed(2), '10');
                } else if (maxRate == 2) {
                    return Math.max((val[2] / sumData * 230).toFixed(2), '10');
                } else if (maxRate == 3) {
                    return Math.max((val[2] / sumData * 23).toFixed(2), '10');
                } else {
                    return 15;
                }
            },
            showEffectOn: 'emphasis',
            rippleEffect: {
                brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#f4e925',
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            zlevel: 1,
            tooltip: {
                formatter: function(params) {
                    return params.name + "：" + params.value[2];
                }
            }
        },
        {
            id: 'bar_0',
            zlevel: 2,
            type: 'bar',
            symbol: 'none',
            itemStyle: {
                normal: {
                    color: '#ddb926'
                }
            },
            data: []
        } ]
    };
}

// 填充省份/地市右侧柱状图
function brushSelected(params) {
	if (CurrentMapType == "province") {
		renderBrushed(params,MYCHART,"0",ConvertedDataProvince);
	} else {
		renderBrushed(params,MYCHART,CityCodeParam,ConvertedDataCity);
	}
}


/**
 * 
 * @param domId
 * @param showCityUrl
 * @param cityData
 * @param chartOption echarts的option参数，key为与echarts同目录同名参数
 */
function showCity(domId,showCityUrl,cityData,chartOption) {
	var cityChart = echarts.init(document.getElementById(domId));
	MYCHART = cityChart;
	DOMID = domId;
	cityChart.showLoading({
        text : 'loading...',
        effect : 'bar',
        textStyle : {
            fontSize : 20
        }
    });
//	$(".china-map").removeClass("china-map-disabled");
    CurrentMapType = "city";
    
    CityCodeParam = cityData["cityCode"];
    // 接口返回值修改了，第二个返回值本为6位，现在改成了4位
    $.get(contextName + '/main/dist/bistatic/allCitys/' + CityCodeParam.substring(0, 2) + '/' + CityCodeParam + '00.json',
	    function(geoJson) {
	        $.ajax({
	            url: showCityUrl + CityCodeParam,
	            type: 'POST',
	            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
	            data: requestData,
	            dataType: "json",
	            async: false,
	            // 默认为true 异步
	            error: function(e) {
	                console.log("地图数据获取错误");
	            },
	            success: function(returnData) {
	                var singleCityData = returnData;
	                RetCityData = singleCityData;
	                // var myData = toCreateData(singleCityData);
	                var myData = toCreateData2(singleCityData, CityCodeParam);
	                var geoCoordMapTemp = myData[0];
	                var dataTemp = myData[1];
	                ConvertedDataCity = getConvertedData(geoCoordMapTemp, dataTemp);
	
	                echarts.registerMap(cityData['cityNameCh'], geoJson);
	                /*if (cityChart != null) {
	                    cityChart.clear();
	                }*/
	
	                var cityOption = getCityOption(cityData['cityNameCh'], CityCodeParam, ConvertedDataCity, cityData['x1'], cityData['y1']);
	                // 合并属性
	            	$.extend(true,cityOption,cityOption,chartOption);
	                cityChart.setOption(cityOption, true);
	                cityChart.on('brushselected', brushSelected);
	                // 更新右侧柱状图
	                brushChart(cityChart);
	                
	                cityChart.hideLoading();
	            }
	        });
	    });
    
    /**
     * 点击某区县位置，展示该区县柱状图
     * @param params
     */
    cityChart.on('click', function (params) {
    	/*for(var i=0;i<RetCityData.length;i++) {
            if(RetCityData[i][2] == params.name){
                var countryData = {
                    countryCode: RetCityData[i][1]
                };
                window.open(window.location.href + '../../geo_map_country.jsp?countryCode=' + RetCityData[i][1] + '&countryName=' + RetCityData[i][2], RetCityData[i][2] + '数据采集总量监控','width=1200,height=800,status=yes,toolbar=yes, menubar=no,location=yes');
                break;
            }
        }*/
    	mapOnClick(params);
    });
}


// 填充地市右侧柱状图
/*function brushSelectedCity(params) {
    renderBrushed(params, MYCHART, CityCodeParam, ConvertedDataCity);
}*/

function getCityOption(cityNameCh,cityCode,convertedData,x1,y1) {
    var t = convertedData[1];
    var sumData = 0;
    var maxData = 0;
    var tempData = 0;
    var maxRate = 0;
    if(t[0] != null && t[0] != ''){
        for(var i=0;i<t.length;i++) {
            tempData = t[i]['value'][2]
            sumData += tempData;
            if(maxData < tempData) {
                maxData = tempData;
            }
        }
        if(sumData<=0) {
            sumData = 1;
        }
    }
    if(maxData / sumData < 0.001) {
            maxRate = 0;
    } else if(maxData / sumData < 0.01) {
            maxRate = 1;
    } else if(maxData / sumData < 0.1) {
            maxRate = 2;
    } else if(maxData / sumData < 1) {
            maxRate = 3;
    }

    return option = {
//        backgroundColor: '#222',
        animation: true,
        animationDuration: 1000,
        animationEasing: 'cubicInOut',
        animationDurationUpdate: 1000,
        animationEasingUpdate: 'cubicInOut',
        title: [
            {
                text: myTitle + '数据采集总量监控——' + cityNameCh,
                left: '45%',
                top: "10",
                textStyle: {
                    color: '#fff',
                    fontSize: 20
                }
            },
            {
                id: 'statistic_' + cityCode,
                right: 120,
                top: 40,
                width: 100,
                textStyle: {
                    color: '#fff',
                    fontSize: 16
                }
            }
        ],
        toolbox: {
            iconStyle: {
                normal: {
                    borderColor: '#fff'
                },
                emphasis: {
                    borderColor: '#b1e4ff'
                }
            },
            feature: {
                myReturnToProvince: { // 自定义按钮，必须以my开头
                    show: true,
                    title: '返回省份地图',
                    icon: "image://../../dist/images/return.png",
                    option: {},
                    onclick: function(option1) {
                    	returnToProvince();
                    }
                }
            }
        },
        brush: {
            outOfBrush: {
                color: '#abc'
            },
            brushStyle: {
                borderWidth: 2,
                color: 'rgba(0,0,0,0.2)',
                borderColor: 'rgba(0,0,0,0.5)',
            },
            seriesIndex: [0, 1],
            throttleType: 'debounce',
            throttleDelay: 300,
            geoIndex: 0
        },
        geo: {
            map: cityNameCh,
            // left: '8%',
            // top: "50",
            // right: '60%',
            // center:[x1, y1],
            layoutCenter: ['30%', '48%'],
            layoutSize: "92%",
            zoom: 0.9,
            label: {
                emphasis: {
                    show: false
                }
            },
            roam: false,
            itemStyle: {
                normal: {
                    areaColor: '#323c48',
                    borderColor: '#111'
                },
                emphasis: {
                    areaColor: '#2a333d'
                }
            }
        },
        tooltip: {
            trigger: 'item'
        },
        grid: {
            right: "15%",
            top: 100,
            bottom: 40,
            width: '30%'
        },
        xAxis: {
            min:0,
            type: 'value',
            scale: true,
            position: 'top',
            splitNumber: 3, 
            boundaryGap: false,
            splitLine: {show: false},
            axisLine: {show: false},
            axisTick: {show: false},
            axisLabel: {margin: 2, textStyle: {color: '#aaa'}},
        },
        yAxis: {
            type: 'category',
            name: '',
            nameGap: 16,
            axisLine: {show: false, lineStyle: {color: '#ddd'}},
            axisTick: {show: false, lineStyle: {color: '#ddd'}},
            axisLabel: {interval: 0, textStyle: {color: '#ddd'}},
            data: []
        },
        series: [
            {
                name: '',
                type: 'scatter',
                coordinateSystem: 'geo',
                data: convertedData[0],
                symbolSize: function (val) {
                    return 8;
                },
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#ddb926'
                    }
                },
                tooltip: {
                    formatter: function(params) {
                        return params.name + "：" + params.value[2];
                    }
                }
            },
            {
                name: '',
                type: 'effectScatter',
                coordinateSystem: 'geo',
                data: convertedData[1],
                symbolSize: function (val) {// 控制点的大小
                    if (maxRate == 0) {
                        return Math.max((val[2] / sumData * 23000).toFixed(2), '10');
                    } else if (maxRate == 1) {
                        return Math.max((val[2] / sumData * 2300).toFixed(2), '10');
                    } else if (maxRate == 2) {
                        return Math.max((val[2] / sumData * 230).toFixed(2), '10');
                    } else if (maxRate == 3) {
                        return Math.max((val[2] / sumData * 23).toFixed(2), '10');
                    } else {
                        return 15;
                    }
                },
                showEffectOn: 'emphasis',
                rippleEffect: {
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#f4e925',
                        shadowBlur: 10,
                        shadowColor: '#333'
                    }
                },
                zlevel: 1,
                tooltip: {
                    formatter: function(params) {
                        return params.name + "：" + params.value[2];
                    }
                }
            },
            {
                id: 'bar_' + cityCode,
                zlevel: 2,
                type: 'bar',
                symbol: 'none',
                itemStyle: {
                    normal: {
                        color: '#ddb926'
                    }
                },
                data: []
            }
        ]
    };
}


//返回省份地图
function returnToProvince() {
	CurrentMapType = "province";
	showProvince(DOMID,ShowProvinceUrl,MyChartOption);
}

/**
 * 点击某市位置，展示该市地图;点击某区县位置，展示该区县柱状图
 * @param params
 */
function mapOnClick(params) {
	if (CurrentMapType == "province") {
		for(var i=0;i<RetProData.length;i++) {
	        if(RetProData[i][2] == params.name){
	            var cityData = {
	                cityCode: RetProData[i][1],
	                cityNameCh: RetProData[i][2],
	                x1: RetProData[i][3],
	                y1: RetProData[i][4]
	            };
	            showCity(DOMID,ShowCityUrl,cityData,MyChartOption);
	            break;
	        }
	    }
	} else {
		for(var i=0;i<RetCityData.length;i++) {
            if(RetCityData[i][2] == params.name){
                var countryData = {
                    countryCode: RetCityData[i][1]
                };
//                window.open(window.location.href + '../../geo_map_country.jsp?countryCode=' + RetCityData[i][1] + '&countryName=' + RetCityData[i][2], RetCityData[i][2] + '数据采集总量监控','width=1200,height=800,status=yes,toolbar=yes, menubar=no,location=yes');
                window.open(ContextName + '/main/bi/monitor/geo_map_country.jsp?countryCode=' + RetCityData[i][1] + '&countryName=' + RetCityData[i][2], RetCityData[i][2] + '数据采集总量监控','width=1200,height=800,status=yes,toolbar=yes, menubar=no,location=yes');
                break;
            }
        }
	}
}

/**
 * 控制省份、地市地图显示
 * params包含以下参数：contextName(context name)、domId(元素ID)、mapGeoCode(行政区划代码)、mapGeoName(行政区划名称)、showProvinceUrl(省份地图url)、showCityUrl(地市地图url)
 * @param  {[type]} params
 */
function showMap(params) {
	ContextName = params.contextName; 
	var domId = params.domId;
	var mapGeoCode = params.mapGeoCode;
	var mapGeoName = params.mapGeoName;
	ShowProvinceUrl = params.showProvinceUrl;
	ShowCityUrl = params.showCityUrl;
	MyChartOption = params.chartOption;
	if (mapGeoCode.length == 2) {
		CurrentMapType = "province";
	    $.get(ContextName + '/main/dist/bistatic/allProvinces/' + mapGeoCode + '.json', function (geoJson) {
	        echarts.registerMap(domId, geoJson);
	        showProvince(domId,ShowProvinceUrl,MyChartOption);
	    });
	} else if (mapGeoCode.length == 4) {
		CurrentMapType = "city";
	    $.get(ContextName + '/main/dist/bistatic/allCitys/' + mapGeoCode.substring(0,2) + '/' + mapGeoCode + '00.json', function (geoJson) {
	        echarts.registerMap(domId, geoJson);
	        var cityData = {
	            cityCode: mapGeoCode,
	            cityNameCh: mapGeoName,
	            x1: "",
	            y1: ""
	        };
	        showCity(domId,ShowCityUrl,cityData,MyChartOption);
	    });
	}/* else {
	    window.location.href="./indexDemo.jsp";
	}*/
}
