<template>
  <div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
            <dv-charts :option="option" />
          </div>
        </el-col>
        <el-col :span="8">
          <div class="chartCalss">
            <dv-charts :option="option1" />
          </div>
        </el-col>
        <el-col :span="8">
          <div class="chartCalss1">
            <dv-charts :option="option2" />
          </div>
        </el-col>
      </el-row>
      <div style="margin-bottom: 20px;"></div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
            <dv-charts :option="option3" />
          </div>
        </el-col>
       
      </el-row>
  </div>
</template>

<script>
export default {
  name: 'ChartsDemo',
  props: {
    msg: String
  },
  data() {
    return {
      option: {
        title: {
          text: '剩余油量表',
          style: {
            fill: '#fff'
          }
        },
        series: [
          {
            type: 'gauge',
            data: [ { name: 'itemA', value: 55 } ],
            center: ['50%', '55%'],
            axisLabel: {
              formatter: '{value}%',
              style: {
                fill: '#fff'
              }
            },
            axisTick: {
              style: {
                stroke: '#fff'
              }
            },
            animationCurve: 'easeInOutBack'
          }
        ]
      },
      option1: {
        title: {
          text: '周销售额趋势',
          style: {
            fill: '#fff'
          }
        },
        xAxis: {
          name: '第一周',
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
          axisLabel: {
            style: {
              fill: '#fff'
            }
          },
          axisTick: {
            style: {
              stroke: '#fff'
            }
          },
        },
        yAxis: {
          name: '销售额',
          data: 'value',
          axisLabel: {
            style: {
              fill: '#fff'
            }
          },
          axisTick: {
            style: {
              stroke: '#fff'
            }
          },
        },
        series: [
          {
            data: [1200, 2230, 1900, 2100, 3500, 4200, 3985],
            type: 'line',
            lineArea: {
              show: true,
              gradient: ['rgba(55, 162, 218, 0.6)', 'rgba(55, 162, 218, 0)']
            }
          }
        ]
      },
      option2: {
        title: {
          text: '周销售额趋势'
        },
        legend: {
          data: [
            {
              name: '销售额',
              color: '#aeeff0'
            },
            {
              name: '人流量',
              color: '#f1829f'
            }
          ]
        },
        xAxis: {
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: [
          {
            name: '销售额',
            data: 'value'
          },
          {
            name: '人流量',
            data: 'value',
            position: 'right',
            max: 2000,
            splitLine: {
              show: false
            }
          }
        ],
        series: [
          {
            name: '人流量',
            data: [1000, 1200, 900, 1500, 900, 1200, 1000],
            type: 'line',
            smooth: true,
            lineArea: {
              show: true,
              gradient: ['rgba(251, 114, 147, 1)', 'rgba(251, 114, 147, 0)']
            },
            lineStyle: {
              stroke: 'rgba(251, 114, 147, 1)',
              lineDash: [3, 3]
            },
            linePoint: {
              style: {
                stroke: 'rgba(251, 114, 147, 1)'
              }
            },
            yAxisIndex: 1
          },
          {
            name: '销售额',
            data: [1500, 1700, 1400, 2000, 1400, 1700, 1500],
            type: 'bar',
            gradient: {
              color: ['rgba(103, 224, 227, .6)', 'rgba(103, 224, 227, .1)']
            },
            barStyle: {
              stroke: 'rgba(103, 224, 227, 1)'
            }
          }
        ]
      },
      option3: {
        title: {
          text: '气温与降雨量走势图',
          style: {
            fill: '#fff'
          }
        },
        legend: {
          data: ['降雨量', '气温'],
          bottom: 10,
          textStyle: {
            fill: '#fff'
          }
        },
        xAxis: {
          data: [
          '一月份', '二月份', '三月份', '四月份', '五月份', '六月份',
          '七月份', '八月份', '九月份', '十月份', '十一月份', '十二月份'
          ],
          axisLabel: {
            style: {
              rotate: 20,
              textAlign: 'left',
              textBaseline: 'top',
              fill: '#fff'
            }
          },
          axisTick: {
            show: false,
            style: {
              stroke: '#fff'
            }
          },
        },
        yAxis: [
          {
            name: '降雨量',
            data: 'value',
            min: 0,
            max: 300,
            interval: 50,
            splitLine: {
              style: {
                lineDash: [3,3]
              }
            },
            axisLabel: {
              formatter: '{value} ml',
              style: {
                fill: '#fff'
              }
            },
            axisTick: {
              show: false,
              style: {
                stroke: '#fff'
              }
            }
          },
          {
            name: '气温',
            data: 'value',
            position: 'right',
            min: 0,
            max: 30,
            interval: 5,
            splitLine: {
              show: false
            },
            axisLabel: {
              formatter: '{value} °C',
              style: {
                fill: '#fff'
              }
            },
            axisTick: {
              show: false,
              style: {
                stroke: '#fff'
              }
            }
          }
        ],
        series: [
          {
            name: '降雨量',
            data: [
              175, 125, 90, 130, 45, 65,
              65, 47, 50, 52, 45, 37
            ],
            type: 'bar',
            gradient: {
              color: ['#37a2da', '#67e0e3']
            },
            animationCurve: 'easeOutBounce'
          },
          {
            name: '气温',
            data: [
            23, 18, 16, 14, 10, 8,
            6, 6, 6, 6, 6, 5
            ],
            type: 'line',
            yAxisIndex: 1,
            animationCurve: 'easeOutBounce'
          }
        ]
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.chartCalss{
  height: 300px;
  background-color: #2c3e50;
}
.chartCalss1{
  height: 300px;
}
</style>
