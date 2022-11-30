<template>
  <div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
            <dv-water-level-pond :config="config" style="width:150px;height:200px" />
          </div>
        </el-col>
        <el-col :span="8">
          <div class="chartCalss">
            <dv-water-level-pond :config="config1" style="width:150px;height:200px" />
          </div>
        </el-col>
      </el-row>
      <div style="margin-bottom: 20px;"></div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
          <dv-water-level-pond :config="config2" style="width:150px;height:200px" />
          </div>
        </el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  name: 'WaterLevel',
  props: {
    msg: String
  },
  data() {
    return {
      config: {
        data: [66]
      },
      config1: {
        data: [66, 45],
        shape: 'roundRect'
      },
      config2: {
        data: [55],
        shape: 'round'
      },
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.chartCalss{
  position: relative;
  background-color: #282c34;
  overflow: hidden;
  border-radius: 6px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #7ec699;
  font-weight: 700;
  height: 300px;
}

</style>
