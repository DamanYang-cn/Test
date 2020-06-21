<template>
   <div :data="tableData">
      <el-card class="box-card">
         <div slot="header" class="clearfix">
            <h2>{{tableData.title}}</h2>
         </div>
         <div class="text item">
            <p>{{tableData.content}}</p>
         </div>
      </el-card>
   </div>
</template>

<style>

</style>

<script>
    export default {
      methods: {

      },
      created() {
         const _this = this
         axios.get('http://localhost:9091/test/findById/'+this.$route.query.id).then(function (resp) {
            console.log(resp)
            _this.tableData = resp.data
         })
      },
      data(){
         return{
            tableData: null
         }
      }
    }
</script>

<style>
   .box-card {
      width: 680px;
   }
</style>