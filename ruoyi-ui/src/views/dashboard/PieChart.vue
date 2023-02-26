<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
  import echarts from 'echarts'
  import {borrowrecordBycataloguePercentage} from "@/api/admin/borrowrecord";

  require('echarts/theme/macarons') // echarts theme
  import resize from './mixins/resize'

  export default {
    mixins: [resize],
    props: {
      className: {
        type: String,
        default: 'chart'
      },
      width: {
        type: String,
        default: '100%'
      },
      height: {
        type: String,
        default: '300px'
      }
    },
    data() {
      return {
        chart: null,
        echatsData: null
      }
    },
    created() {
      this.initData()
    },
    mounted() {
      /* this.$nextTick(() => {
         this.initChart()
       })*/
    },
    beforeDestroy() {
      if (!this.chart) {
        return
      }
      this.chart.dispose()
      this.chart = null
    },
    methods: {
      initData() {
        borrowrecordBycataloguePercentage().then(response => {
          this.echatsData = response.data;
          this.$nextTick(() => {
            this.initChart()
          })
        })
      },
      initChart() {
        let title=[]
        for (let i = 0; i <this.echatsData.length; i++) {
          title.push(this.echatsData[i].name)
        }

        this.chart = echarts.init(this.$el, 'macarons')

        this.chart.setOption({
          title: {
            text: '图书借阅分类占比',
            textStyle: {
              // color: 'white'
            }},
          toolbox: {
            feature: {
              saveAsImage: {}, // 导出图片
              dataView: {
                show: true,
                title: '数据视图',
                optionToContent: function (opt) {
                  var axisData = opt.xAxis[0].data;
                  var series = opt.series;
                  var tdHeads = '<td  style="padding:0 10px">名称</td>';
                  series.forEach(function (item) {
                    tdHeads += '<td style="padding: 0 10px">' + item.name + '</td>';
                  });
                  var table = '<table class="layui-table" style=" height:100%;width:100%;text-align:center ;margin-left:20px;"><tbody><tr>' + tdHeads + '</tr>';
                  var tdBodys = '';
                  for (var i = 0, l = axisData.length; i < l; i++) {
                    for (var j = 0; j < series.length; j++) {
                      if (typeof (series[j].data[i]) == 'object') {
                        tdBodys += '<td>' + series[j].data[i].value + '</td>';
                      } else {
                        tdBodys += '<td>' + series[j].data[i] + '</td>';
                      }
                    }
                    table += '<tr><td style="padding: 0 10px">' + axisData[i] + '</td>' + tdBodys + '</tr>';
                    tdBodys = '';
                  }
                  table += '</tbody></table>';
                  return table;
                }
              },
              restore: {}, // 重置
              dataZoom: {}, // 区域缩放
           /*   magicType: {
                type: ["bar", "line"],
              }, // 动态图表类型的切换*/
            },
            iconStyle:{
              normal:{
                color:'white',//设置颜色
              }
            },
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
          },
          legend: {
            left: 'center',
            bottom: '10',
            data: title
            // data: ['Industries', 'Technology', 'Forex', 'Gold', 'Forecasts']
          },
          series: [
            {
              name: '图书借阅占比',
              type: 'pie',
              roseType: 'radius',
              radius: [15, 95],
              center: ['50%', '38%'],
              data: this.echatsData,
              animationEasing: 'cubicInOut',
              animationDuration: 2600
            }
          ]
        })
      }
    }
  }
</script>
