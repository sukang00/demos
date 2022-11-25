<template>
  <div class="hello">
      <el-row>
        <el-col :span="8">
          dv-decoration-1
          <dv-decoration-1 style="width:200px;height:50px;" />
        </el-col>
        <el-col :span="8">
          dv-decoration-2
          <dv-decoration-2 style="width:200px;height:5px;" />
        </el-col>
        <el-col :span="8">
          dv-decoration-2
          <dv-decoration-2 :reverse="true" style="width:5px;height:150px;" />
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          dv-decoration-3
          <dv-decoration-3 style="width:250px;height:30px;" />
        </el-col>
        <el-col :span="8">
          dv-decoration-4
          <dv-decoration-4 :color="['red', 'green']" style="width:5px;height:150px;" />
        </el-col>
        <el-col :span="8">
          dv-decoration-4
          <dv-decoration-4 :reverse="true" :color="['red', 'green']" style="width:250px;height:5px;" />
        </el-col>
      </el-row>
      
      <el-row>
        <el-col :span="8">
          dv-decoration-5
          <dv-decoration-5 style="width:300px;height:40px;" />
        </el-col>
        <el-col :span="8">
          dv-decoration-6
          <dv-decoration-6 style="width:300px;height:30px;" />
        </el-col>
        <el-col :span="8">
          dv-decoration-7
          <dv-decoration-7 style="width:150px;height:30px;">Decoration</dv-decoration-7>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          dv-decoration-8
          <dv-decoration-8 style="width:300px;height:50px;" />
        </el-col>
        <el-col :span="8">
          dv-decoration-8
          <dv-decoration-8 :reverse="true" style="width:300px;height:50px;" >dv-decoration-8</dv-decoration-8>
        </el-col>
        <el-col :span="8">
          dv-decoration-9
          <dv-decoration-9 style="width:150px;height:150px;">66%</dv-decoration-9>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          dv-decoration-10
          <dv-decoration-10 style="width:90%;height:60px;" >dv-decoration-10</dv-decoration-10>
        </el-col>
        <el-col :span="8">
          <dv-decoration-11 style="width:200px;height:60px;">dv-decoration-11</dv-decoration-11>
        </el-col>
        <el-col :span="8">
          <dv-decoration-12 style="width:150px;height:150px;" >dv-decoration-12</dv-decoration-12>
        </el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  name: 'DecorationDemo',
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
