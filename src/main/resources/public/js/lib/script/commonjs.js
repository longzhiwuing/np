/*    function getContextName() {
        var context = '<%=((String[])(request.getRequestURI().split("/")))[1]%>';
        if (context == null || context == '') {
            return "";
        } else {
            return '/' + context;
        }
    }*/
    function getContextName() {
        var href = window.location.href;
        var t = href.substring(href.indexOf('//') + 2);
        var s = t.substring(t.indexOf('/') + 1);
        var ret = s.substring(0, s.indexOf('/'));
        if (ret == null || ret == '') {
            return "";
        } else {
            return '/' + ret;
        }
    }


    function getRequestParams(url) {
        // var url = location.search; //获取url中含"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(url.indexOf("?")+1);
            str = decodeURIComponent(str);
            strs = str.split("&");
            for(var i = 0; i < strs.length; i ++) {
                theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    /*
     * 根据duns值获取市级、区县、乡镇等数据
     * @params duns
     */
    /*function getDataByDuns(duns) {
        $.ajax({
            url: "/<%=((String[])(request.getRequestURI().split("/")))[1]%>/network/ajaxCall?cmd=redisEtlHisByDuns&duns=" + duns,
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded; charset=utf-8', 
            data: requestData,
            dataType:"json",
            async: false, //默认为true 异步
            error: function (e) {
                console.log("地图数据获取错误");
            },
            success: function (returnData) {
                return returnData;
            }
        });
    }*/


    // 更新右侧柱状图
    function brushChart(chart) {
        chart.dispatchAction({
            type: 'brush',
            areas: [
                {
                    geoIndex: 0,
                    brushType: 'polygon',
                    // coordRange: [[70, 15],[150, 15],[150, 75],[70, 75]]
                    coordRange: [[73, 3],[136, 3],[136, 53],[73, 53]]
                }
            ]
        });
    }

    // 填充右侧柱状图
    function renderBrushed(params,chart,cityCode,convertedData) {
        var mainSeries = params.batch[0].selected[0];
        var selectedItems = [];
        var categoryData = [];
        var barData = [];
        var maxBar = 120;
        var sum = 0;
        var count = 0;

        for (var i = 0; i < mainSeries.dataIndex.length; i++) {
            var rawIndex = mainSeries.dataIndex[i];
            var dataItem = convertedData[0][rawIndex];
            if (dataItem == "undefined" || typeof(dataItem) == "undefined")
            	break;
            var pmValue = dataItem.value[2];
            sum += pmValue;
            count++;
            selectedItems.push(dataItem);
        }

        selectedItems.sort(function (a, b) {
            return a.value[2] - b.value[2];
        });

        for (var i = 0; i < Math.min(selectedItems.length, maxBar); i++) {
            categoryData.push(selectedItems[i].name);
            barData.push(selectedItems[i].value[2]);
        }

        chart.setOption({
            yAxis: {
                data: categoryData
            },
            xAxis: {
                axisLabel : {
//				show : !!count,
				formatter: function (value) {
	                var texts = [];
	                var text = "";
	                if (value >= 10000 && value < 10000000) {
	                	text = value / 10000 + "万";
	                } else if (value >= 10000000) {
	                	text = value / 100000000 + "亿";
	                }
	                texts.push(text);
	                return texts;
//	                return text;
	            }
			}
            },
            title: {
                id: 'statistic_' + cityCode,
                text: count ? '总量: ' + (formatNum(sum)) : ''
            },
            series: {
                id: 'bar_' + cityCode,
                data: barData
            }
        });
    } 


    function toCreateData(returnData) {
        var geoCoordMapTemp = {};
        var dataTemp = new Array();
        for (var i = 0; i < returnData.length; i++)
        {
            if(geoCoordMapTemp[returnData[i][4]] == null)
            {
                var name = returnData[i][2];
                geoCoordMapTemp[returnData[i][2]] = [Number(returnData[i][3]), Number(returnData[i][4])];
                var dataelement = {name: name, value: Number(returnData[i][5])};
                dataTemp.push(dataelement);
            }else {
                for(var j =0 ;j<dataTemp.length;j++)
                {
                    if(dataTemp[j].name ==returnData[i][2] )
                    {
                        dataTemp[j].value = dataTemp[j].value+Number(returnData[i][5]);
                    }
                }
            }
        }
        return [ geoCoordMapTemp, dataTemp ];
    }

    function toCreateData2(returnData, cityCode) {
        var geoCoordMapTemp = {};
        var dataTemp = new Array();
        for (var i = 0; i < returnData.length; i++)
        {
            if(cityCode.substring(0,4) == returnData[i][1].substring(0,4)) {
                if(geoCoordMapTemp[returnData[i][4]] == null)
                {
                    var name = returnData[i][2];
                    geoCoordMapTemp[returnData[i][2]] = [Number(returnData[i][3]), Number(returnData[i][4])];
                    var dataelement = {name: name, value: Number(returnData[i][5])};
                    dataTemp.push(dataelement);
                }else {
                    for(var j =0 ;j<dataTemp.length;j++)
                    {
                        if(dataTemp[j].name ==returnData[i][2] )
                        {
                            dataTemp[j].value = dataTemp[j].value+Number(returnData[i][5]);
                        }
                    }
                }
            }
        }
        return [ geoCoordMapTemp, dataTemp ];
    }

    function toConvertData(geoCoordMap, data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        return res;
    };  

    function getConvertedData(geoCoordMap, data) {
        var convertedData = [
            toConvertData(geoCoordMap, data),
            toConvertData(geoCoordMap, data.sort(function (a, b) {
                return b.value - a.value;
            }))
        ];
        return convertedData;
    }

    /**
     * 将数字转化成逗号分隔形式，例 1457485 => 1,457,485
     * 
     * @param id
     */
    function formatNum(num) {
    	var parts = num.toString().split(".");
    	parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    	return parts.join(".");

    }