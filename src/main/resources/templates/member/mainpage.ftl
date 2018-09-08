<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<div class="container-fluid innerScroll">
	<div class="row hr-bottom">
		<div class="col-md-12">
			<p class="text-left">网站访问量：${viewCount!'0'}</p>
			<p class="text-left">文章数量：${blogCount!'0'}</p>
			<p class="text-right"><a class="btn btn-success text-right" href="/security/initsystem">初始化系统数据</a></p>
		</div>
	</div>
	<div class="row ">
		<div class="col-md-6">
			<div id="chartmain" style="width:600px; height: 400px;"></div>
		</div>
		<div class="col-md-6">
			<div id="chartmain1" style="width:600px; height: 400px;"></div>
		</div>
	</div>
	<div class="row ">
		<div class="col-md-12">
			<div id="chartmain2" style="width:900px; height: 400px;"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	window.onload = function(){
		//指定图标的配置和数据
		var option = {
		    title : {
		        text: '各板块访问量',
		        subtext: '纯属虚构',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient : 'vertical',
		        x : 'left',
		        data:['博客','工具速递','联盟广告','系列主题','新闻']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'访问量',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:1335, name:'博客'},
		                {value:310, name:'工具速递'},
		                {value:234, name:'广告'},
		                {value:135, name:'系列主题'},
		                {value:584, name:'新闻'}
		            ]
		        }
		    ]};
		var option2={
	             title:{
	                 text:"各分类浏览量"
	             } ,
	             tooltip:{}  ,
	             legend:{
	                 data:'浏览量'
	             },
	             xAxis:{
	                 data:['springboot','云计算','开发平台','springcloud','java','框架']
	             },
	             yAxis:{}  ,
	             series:{
	                 name:'浏览量',
	                 type:'bar'  ,
	                 data:[1500,2098,369,102,1506,2077]
	             }
	         };
        //2.创建Oprion
        var option3={
             title:{
                 text:'访问趋势'
             } ,
            tooltip:{
                 trigger:'axis'
            }  ,
            legend:{
                 data:['博客','工具速递','联盟广告','系列主题','新闻']
            } ,
            grid:{
                 left:'3%' ,
                 right:'4%' ,
                 bottom:'3%' ,
                 containLabel:true
            } ,
            toolbox:{
                 feature:{
                     saveAsImage:{}
                 }
            } ,
            xAxis:{
                 type:'category',
                 boundaryGap:false ,
                 data:['周一','周二','周三','周四','周五','周六','周日']
            } ,
            yAxis:{
                 type:'value'
            }  ,
            series:[
                     {
                             name  :   '博客',
                             type  :   'line'     ,
                             stack  :  '总量' ,
                             data   :  [120,132,101,134,90,230,210]
                     } ,
                     {
                             name  : '工具速递' ,
                             type  :  'line'   ,
                             stack :  '总量'   ,
                             data  :[220,182,191,234,290,330,310]
                     } ,
                    {
                               name  :   '联盟广告' ,
                               type  :  'line' ,
                               stack :  '总量' ,
                               data  :  [150,232,201,154,190,330,410]
                    } ,
                   {
                                name  :  '系列主题',
                                type  :  'line'  ,
                                stack :'   总量'  ,
                                 data :[320,332,301,334,390,330,320]
                   },
                  {
                                 name : '新闻'  ,
                                 type : 'line'   ,
                                 stack : '总量' ,
                                 data : [920,932,901,934,1290,1330,1320]
                  }
            ]};
		//初始化echarts实例
		var myChart = echarts.init(document.getElementById('chartmain'));
		var myChart1 = echarts.init(document.getElementById('chartmain1'));
		var myChart2 = echarts.init(document.getElementById('chartmain2'));
		//使用制定的配置项和数据显示图表
		myChart.setOption(option);
		myChart1.setOption(option2);
		myChart2.setOption(option3);
	}
</script>
</body>
</html>