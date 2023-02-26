<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'
import {borrowrecordByDeptPercentage } from "@/api/admin/borrowrecord";
const animationDuration = 6000

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
      echatsData:null
    }
  },
  mounted() {
   /* this.$nextTick(() => {
      this.initChart()
    })*/
  },
created(){
  this.initData();
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
      borrowrecordByDeptPercentage().then(response => {
        this.echatsData = response.data;
        this.$nextTick(() => {
          this.initChart()
        })
      });
    },
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')

      this.chart.setOption({
        title: {
          text: '图书班级借阅量',
          textStyle: {
            // color: 'white'
          }},
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
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
            magicType: {
              type: ["bar", "line"],
            }, // 动态图表类型的切换
          },
          iconStyle:{
            normal:{
              color:'white',//设置颜色
            }
          },
        },
        grid: {
          top: 10,
          left: '2%',
          right: '2%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          data: this.echatsData.name,
          // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
          axisTick: {
            alignWithLabel: true
          }
        }],
        yAxis: [{
          type: 'value',
          axisTick: {
            show: false
          }
        }],
        series: [{
          name: '数量',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: this.echatsData.value,
          // data: [79, 52, 200, 334, 390, 330, 220],
          animationDuration
        }, /*{
          name: 'pageB',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: [80, 52, 200, 334, 390, 330, 220],
          animationDuration
        }, {
          name: 'pageC',
          type: 'bar',
          stack: 'vistors',
          barWidth: '60%',
          data: [30, 52, 200, 334, 390, 330, 220],
          animationDuration
        }*/]
      })
    },

  }
}
</script>
