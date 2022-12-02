<template>
  <div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
            <dv-percent-pond :config="config" style="width:200px;height:100px;" />
          </div>
        </el-col>
        <el-col :span="8">
          <div class="chartCalss">
            <dv-percent-pond :config="config1" style="width:200px;height:100px;" />
          </div>
        </el-col>
      </el-row>
      <div style="margin-bottom: 20px;"></div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
          <dv-percent-pond :config="config2" style="width:200px;height:100px;" />
          </div>
        </el-col>
        <el-col :span="8">
          <div class="chartCalss">
          <dv-percent-pond :config="config3" style="width:200px;height:100px;" />
          </div>
        </el-col>
      </el-row>
      <div style="margin-bottom: 20px;"></div>
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="chartCalss">
          <dv-percent-pond :config="config4" style="width:200px;height:100px;" />
          </div>
        </el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  name: 'PercentPond',
  props: {
    msg: String
  },
  data() {
    const fullWidth = 300
    const borderGap = 3
    const borderWidth = 3
    const usefulWidth = fullWidth - (borderGap + borderWidth) * 2

    const pieceLength = [0.25, 0.5, 0.25]
    const pieceGap = 3

    const lineDash = pieceLength
      .map(l => [usefulWidth * l, pieceGap])
      .reduce((all, current) => [...all, ...current], [])
    return {
      config: {
        data: [66]
      },
      config1: {
        value: 66,
        borderWidth: 5,
        borderRadius: 10,
        borderGap: 5
      },
      config2: {
        value: 66,
        lineDash: [10, 2]
      },
      config3: {
        value: 66,
        localGradient: true
      },
      config4: {
        value: 100,
        colors: ['#01c4f9', '#c135ff'],
        lineDash
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
