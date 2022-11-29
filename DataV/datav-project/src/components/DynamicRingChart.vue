<template>
  <div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
            <dv-active-ring-chart :config="config" style="width:300px;height:300px" />
          </div>
        </el-col>
        <el-col :span="8">
          <div class="chartCalss">
            <dv-active-ring-chart :config="config2" style="width:300px;height:300px" />
          </div>
        </el-col>
      </el-row>
      <div style="margin-bottom: 20px;"></div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
          <dv-active-ring-chart :config="config1" style="width:300px;height:300px" />
          </div>
        </el-col>
         <el-col :span="8">
          <div class="chartCalss">
            <dv-active-ring-chart :config="config3" style="width:300px;height:300px" />
          </div>
        </el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  name: 'DynamicRingChart',
  props: {
    msg: String
  },
  data() {
    return {
      config: {
        data: [
          {
            name: '周口',
            value: 55
          },
          {
            name: '南阳',
            value: 120
          },
          {
            name: '西峡',
            value: 78
          },
          {
            name: '驻马店',
            value: 66
          },
          {
            name: '新乡',
            value: 80
          }
        ]
      },
      config1: {
        data: [
          {
            name: '周口',
            value: 55
          },
          {
            name: '南阳',
            value: 120
          },
          {
            name: '西峡',
            value: 78
          },
          {
            name: '驻马店',
            value: 66
          },
          {
            name: '新乡',
            value: 80
          }
        ],
        lineWidth: 10
      },
      config2: {
        radius: '40%',
        activeRadius: '45%',
        data: [
          {
            name: '周口',
            value: 55
          },
          {
            name: '南阳',
            value: 120
          },
          {
            name: '西峡',
            value: 78
          },
          {
            name: '驻马店',
            value: 66
          },
          {
            name: '新乡',
            value: 80
          }
        ],
        digitalFlopStyle: {
          fontSize: 20
        }
      },
      config3: {
        radius: '40%',
        activeRadius: '45%',
        data: [
          {
            name: '周口',
            value: 55
          },
          {
            name: '南阳',
            value: 120
          },
          {
            name: '西峡',
            value: 78
          },
          {
            name: '驻马店',
            value: 66
          },
          {
            name: '新乡',
            value: 80
          }
        ],
        digitalFlopStyle: {
          fontSize: 20
        },
        showOriginValue: true
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
