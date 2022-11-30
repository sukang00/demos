<template>
  <div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
            <dv-capsule-chart :config="config" style="width:300px;height:200px" />
          </div>
        </el-col>
        <el-col :span="8">
          <div class="chartCalss">
            <dv-capsule-chart :config="config1" style="width:300px;height:300px" />
          </div>
        </el-col>
      </el-row>
      <div style="margin-bottom: 20px;"></div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
          <dv-capsule-chart :config="config2" style="width:300px;height:300px" />
          </div>
        </el-col>
         <el-col :span="8">
          <div class="chartCalss">
            <dv-capsule-chart :config="config3" style="width:300px;height:300px" />
          </div>
        </el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  name: 'CapsuleChart',
  props: {
    msg: String
  },
  data() {
    return {
      config:{
        data: [
          {
            name: '南阳',
            value: 167
          },
          {
            name: '周口',
            value: 67
          },
          {
            name: '漯河',
            value: 123
          },
          {
            name: '郑州',
            value: 55
          },
          {
            name: '西峡',
            value: 98
          }
        ]
      },
      config1:{
        data: [
          {
            name: '南阳',
            value: 167
          },
          {
            name: '周口',
            value: 67
          },
          {
            name: '漯河',
            value: 123
          },
          {
            name: '郑州',
            value: 55
          },
          {
            name: '西峡',
            value: 98
          }
        ],
        unit: '单位'
      },
      config2:{
        data: [
          {
            name: '南阳',
            value: 167
          },
          {
            name: '周口',
            value: 67
          },
          {
            name: '漯河',
            value: 123
          },
          {
            name: '郑州',
            value: 55
          },
          {
            name: '西峡',
            value: 98
          }
        ],
        colors: ['#e062ae', '#fb7293', '#e690d1', '#32c5e9', '#96bfff'],
        unit: '单位'
      },
      config3:{
        data: [
          {
            name: '南阳',
            value: 167
          },
          {
            name: '周口',
            value: 67
          },
          {
            name: '漯河',
            value: 123
          },
          {
            name: '郑州',
            value: 55
          },
          {
            name: '西峡',
            value: 98
          }
        ],
        colors: ['#e062ae', '#fb7293', '#e690d1', '#32c5e9', '#96bfff'],
        unit: '单位',
        showValue: true
      },
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
