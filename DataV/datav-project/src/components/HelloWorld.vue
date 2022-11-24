<template>
  <div class="hello">
   <!--  <dv-full-screen-container>
      <dv-loading>Loading...</dv-loading>
    </dv-full-screen-container> -->
      <el-row>
        <el-col :span="8">
          <dv-border-box-1><div class="box">dv-border-box-1</div></dv-border-box-1>
        </el-col>
        <el-col :span="8">
          <dv-border-box-2 :color="['red', 'green']"><div class="box">dv-border-box-2</div></dv-border-box-2>
        </el-col>
        <el-col :span="8">
          <dv-border-box-3><div class="box">dv-border-box-3</div></dv-border-box-3>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <dv-border-box-4><div class="box">dv-border-box-4</div></dv-border-box-4>
        </el-col>
        <el-col :span="8">
          <dv-border-box-4 :reverse="true"><div class="box">dv-border-box-4</div></dv-border-box-4>
        </el-col>
        <el-col :span="8">
          <dv-border-box-5 :color="['red', 'green']"><div class="box">dv-border-box-5</div></dv-border-box-5>
        </el-col>
      </el-row>
      
      <el-row>
        <el-col :span="8">
          <dv-border-box-6 :color="['red', 'green']"><div class="box">dv-border-box-6</div></dv-border-box-6>
        </el-col>
        <el-col :span="8">
          <dv-border-box-7 :color="['red', 'green']"><div class="box">dv-border-box-7</div></dv-border-box-7>
        </el-col>
        <el-col :span="8">
          <dv-border-box-5 :reverse="true" :color="['red', 'green']"><div class="box">dv-border-box-5</div></dv-border-box-5>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <dv-border-box-8><div class="box">dv-border-box-8</div></dv-border-box-8>
        </el-col>
        <el-col :span="8">
          <dv-border-box-8 :reverse="true"><div class="box">dv-border-box-8</div></dv-border-box-8>
        </el-col>
        <el-col :span="8">
          <dv-border-box-9><div class="box">dv-border-box-9</div></dv-border-box-9>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <dv-border-box-10><div class="box">dv-border-box-10</div></dv-border-box-10>
        </el-col>
        <el-col :span="8">
          <dv-border-box-11 title="dv-border-box-11"><div class="box">dv-border-box-11</div></dv-border-box-11>
        </el-col>
        <el-col :span="8">
          <dv-border-box-12><div class="box">dv-border-box-12</div></dv-border-box-12>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <dv-border-box-13><div class="box">dv-border-box-13</div></dv-border-box-13>
        </el-col>
      </el-row>
      
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.box {
  height: 200px;
  text-align: center;
  vertical-align: middle;
  margin-bottom: 20px;
  line-height: 200px;
}
</style>
